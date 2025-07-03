#!/usr/bin/env python3
"""
Test script for the README updater.
Run this to test the automation locally before pushing to GitHub.
"""

import sys
import os

# Add the scripts directory to the path
sys.path.append(os.path.dirname(os.path.abspath(__file__)))

from update_readme import scan_solutions, update_statistics, generate_table_content

def test_scanning():
    """Test the solution scanning functionality."""
    print("🧪 Testing solution scanning...")
    
    solutions = scan_solutions()
    
    print(f"Found {len(solutions)} topics:")
    for topic, problems in solutions.items():
        print(f"  📁 {topic}: {len(problems)} problems")
        for problem, languages in problems.items():
            print(f"    - {problem}: {', '.join(languages)}")
    
    return solutions

def test_statistics(solutions):
    """Test the statistics calculation."""
    print("\n📊 Testing statistics calculation...")
    
    total_problems, topics_covered, all_languages = update_statistics(solutions)
    
    print(f"Total problems: {total_problems}")
    print(f"Topics covered: {topics_covered}")
    print(f"Languages used: {', '.join(sorted(all_languages))}")
    
    return total_problems, topics_covered, all_languages

def test_table_generation(solutions):
    """Test the table generation."""
    print("\n📋 Testing table generation...")
    
    table_content = generate_table_content(solutions)
    
    print("Generated table content:")
    print(table_content)
    
    return table_content

if __name__ == "__main__":
    print("🚀 Starting README updater tests...\n")
    
    # Test scanning
    solutions = test_scanning()
    
    # Test statistics
    test_statistics(solutions)
    
    # Test table generation
    table_content = test_table_generation(solutions)
    
    print("\n✅ All tests completed!")
    print("💡 To update the actual README, run: python scripts/update_readme.py") 