#!/usr/bin/env python3
"""
Automated README updater for NeetCode 250 progress tracking.
Scans repository structure and updates README.md with current progress.
"""

import os
import re
import glob
from pathlib import Path
from typing import Dict, List, Set, Tuple
import requests
from bs4 import BeautifulSoup

# Language file extensions mapping
LANGUAGE_EXTENSIONS = {
    'java': '.java',
    'python': '.py',
    'cpp': '.cpp',
    'c': '.c',
    'javascript': '.js',
    'typescript': '.ts',
    'go': '.go',
    'rust': '.rs',
    'csharp': '.cs',
    'swift': '.swift',
    'kotlin': '.kt',
    'ruby': '.rb',
    'scala': '.scala',
    'dart': '.dart'
}

# Reverse mapping for extension to language key
EXTENSION_TO_LANG = {v: k for k, v in LANGUAGE_EXTENSIONS.items()}

# Language display names
LANGUAGE_NAMES = {
    'java': 'Java',
    'python': 'Python',
    'cpp': 'C++',
    'c': 'C',
    'javascript': 'JavaScript',
    'typescript': 'TypeScript',
    'go': 'Go',
    'rust': 'Rust',
    'csharp': 'C#',
    'swift': 'Swift',
    'kotlin': 'Kotlin',
    'ruby': 'Ruby',
    'scala': 'Scala',
    'dart': 'Dart'
}

# Directories to ignore as topics
IGNORE_TOPICS = {'.git', '.github', 'scripts', 'node_modules', '__pycache__'}

# Helper: check if a directory contains at least one valid solution file
def has_valid_solution_files(problem_dir: str) -> bool:
    for file_path in glob.glob(os.path.join(problem_dir, '*')):
        if not os.path.isfile(file_path):
            continue
        ext = os.path.splitext(file_path)[1]
        if ext in EXTENSION_TO_LANG:
            return True
    return False

def extract_leetcode_link(file_path: str) -> str:
    """Extract leetcode link from the first comment of a solution file."""
    try:
        with open(file_path, 'r', encoding='utf-8') as f:
            first_line = f.readline().strip()
            # Look for leetcode link in first line
            match = re.search(r'https://leetcode\.com/problems/[^/\s]+/?', first_line)
            if match:
                return match.group(0)
            # If not in first line, check next few lines
            for _ in range(5):
                line = f.readline().strip()
                if line:
                    match = re.search(r'https://leetcode\.com/problems/[^/\s]+/?', line)
                    if match:
                        return match.group(0)
    except Exception as e:
        print(f"Error reading {file_path}: {e}")
    return ""

def get_problem_name_from_url(url: str) -> str:
    """Extract problem name from leetcode URL."""
    if not url:
        return ""
    # Extract the problem slug from URL
    match = re.search(r'/problems/([^/]+)/?', url)
    if match:
        slug = match.group(1)
        # Convert slug to title case
        name = slug.replace('-', ' ').title()
        return name
    return ""

def scan_solutions() -> Dict[str, Dict[str, Set[str]]]:
    """
    Scan the repository for solution files and organize them by topic and language.
    Returns: {topic: {problem_name: {languages}}}
    """
    solutions = {}
    # Scan for topic directories (excluding ignored ones)
    for topic_dir in glob.glob("*/"):
        topic = topic_dir.rstrip('/')
        if topic in IGNORE_TOPICS or topic.startswith('.'):
            continue
        if not os.path.isdir(topic_dir):
            continue
        topic_problems = {}
        # Scan for problem directories within each topic
        for problem_dir in glob.glob(os.path.join(topic_dir, '*/')):
            problem_name = os.path.basename(os.path.normpath(problem_dir))
            if problem_name in IGNORE_TOPICS or problem_name.startswith('.'):
                continue
            if not os.path.isdir(problem_dir):
                continue
            if not has_valid_solution_files(problem_dir):
                continue
            langs = set()
            # Scan for solution files in each problem directory
            for file_path in glob.glob(os.path.join(problem_dir, '*')):
                if not os.path.isfile(file_path):
                    continue
                ext = os.path.splitext(file_path)[1]
                lang = EXTENSION_TO_LANG.get(ext)
                if lang:
                    langs.add(lang)
            if langs:
                topic_problems[problem_name] = langs
        if topic_problems:
            solutions[topic] = topic_problems
    return solutions

def generate_table_content(solutions: Dict[str, Dict[str, Set[str]]]) -> str:
    """Generate the table content for the README."""
    table_content = ""
    for topic, problems in solutions.items():
        if not problems:
            continue
        # Get all languages used in this topic
        all_languages = set()
        for problem_langs in problems.values():
            all_languages.update(problem_langs)
        # Sort languages for consistent ordering
        sorted_languages = sorted(all_languages, key=lambda x: list(LANGUAGE_EXTENSIONS.keys()).index(x))
        # Generate topic header
        table_content += f"\n### {topic}\n\n"
        # Generate table header
        header = "| Problem |"
        separator = "|---------|"
        for lang in sorted_languages:
            header += f" {LANGUAGE_NAMES[lang]} |"
            separator += "------|"
        table_content += header + "\n"
        table_content += separator + "\n"
        # Generate table rows
        for problem_name in sorted(problems.keys()):
            # Get leetcode link for this problem
            leetcode_link = ""
            for lang in problems[problem_name]:
                ext = LANGUAGE_EXTENSIONS[lang]
                file_pattern = os.path.join(topic, problem_name, f'*{ext}')
                files = glob.glob(file_pattern)
                if files:
                    leetcode_link = extract_leetcode_link(files[0])
                    break
            # Generate problem name with link
            if leetcode_link:
                problem_display_name = get_problem_name_from_url(leetcode_link)
                if not problem_display_name:
                    problem_display_name = problem_name.replace('-', ' ').title()
                problem_cell = f"[{problem_display_name}]({leetcode_link})"
            else:
                problem_display_name = problem_name.replace('-', ' ').title()
                problem_cell = problem_name.replace('-', ' ').title()
            row = f"| {problem_cell} |"
            # Add language checkmarks
            for lang in sorted_languages:
                if lang in problems[problem_name]:
                    ext = LANGUAGE_EXTENSIONS[lang]
                    file_pattern = os.path.join(topic, problem_name, f'*{ext}')
                    files = glob.glob(file_pattern)
                    if files:
                        file_path = files[0]
                        row += f" <sub><div align='center'>[✔️](./{file_path.replace(' ', '%20')})</div></sub> |"
                    else:
                        row += f" <sub><div align='center'>[✔️](./{topic}/{problem_name}/)</div></sub> |"
                else:
                    row += " <sub><div align='center'>❌</div></sub> |"
            table_content += row + "\n"
    return table_content

def update_statistics(solutions: Dict[str, Dict[str, Set[str]]]) -> Tuple[int, int, Set[str]]:
    """Calculate statistics for the README."""
    total_problems = sum(len(problems) for problems in solutions.values())
    topics_covered = len(solutions)
    # Get all languages used
    all_languages = set()
    for problems in solutions.values():
        for problem_langs in problems.values():
            all_languages.update(problem_langs)
    return total_problems, topics_covered, all_languages

def update_readme():
    """Main function to update the README.md file."""
    print("🔍 Scanning repository for solutions...")
    solutions = scan_solutions()
    print("📊 Calculating statistics...")
    total_problems, topics_covered, all_languages = update_statistics(solutions)
    print("📝 Generating table content...")
    table_content = generate_table_content(solutions)
    print("📖 Reading current README...")
    with open('README.md', 'r', encoding='utf-8') as f:
        content = f.read()
    # Update statistics section
    stats_pattern = r'## Statistics\n\n(.*?)\n\n'
    stats_content = f"""## Statistics\n\n- **Total Problems Solved**: {total_problems}\n- **Topics Covered**: {topics_covered}\n- **Languages**: {', '.join(sorted([LANGUAGE_NAMES[lang] for lang in all_languages]))}"""
    content = re.sub(stats_pattern, stats_content + '\n\n', content, flags=re.DOTALL)
    # Update progress tracking section
    progress_pattern = r'## Progress Tracking\n\n.*?(?=\n## |$)'
    progress_content = f"""## Progress Tracking\n\nThe tables below track all the problems I have successfully solved, organized by topic and including links to the original problems.{table_content}"""
    content = re.sub(progress_pattern, progress_content, content, flags=re.DOTALL)
    print("💾 Writing updated README...")
    with open('README.md', 'w', encoding='utf-8') as f:
        f.write(content)
    print(f"✅ README updated successfully!")
    print(f"📈 Statistics: {total_problems} problems, {topics_covered} topics, {len(all_languages)} languages")

if __name__ == "__main__":
    update_readme() 