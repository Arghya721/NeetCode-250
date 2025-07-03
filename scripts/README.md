# README Updater Scripts

This directory contains automation scripts to keep your NeetCode 250 progress README.md automatically updated.

## Files

- `update_readme.py` - Main script that updates README.md based on your solution files
- `test_update.py` - Test script to verify the automation works locally
- `requirements.txt` - Python dependencies for the scripts

## How It Works

The automation system:

1. **Scans your repository structure** to find solution files
2. **Extracts LeetCode links** from the first comment of each solution file
3. **Organizes solutions by topic** (folder structure)
4. **Tracks multiple programming languages** automatically
5. **Updates statistics** (total problems, topics, languages)
6. **Generates formatted tables** for the README

## Supported Languages

The system automatically detects and tracks solutions in:
- Java (.java)
- Python (.py)
- C++ (.cpp)
- C (.c)
- JavaScript (.js)
- TypeScript (.ts)
- Go (.go)
- Rust (.rs)
- C# (.cs)
- Swift (.swift)
- Kotlin (.kt)
- Ruby (.rb)
- Scala (.scala)
- Dart (.dart)

## Usage

### Local Testing
```bash
# Test the automation locally
python scripts/test_update.py

# Update README locally
python scripts/update_readme.py
```

### GitHub Actions
The automation runs automatically when you:
- Push code to main/master branch
- Add new solution files
- Modify existing solution files

## File Structure Requirements

For the automation to work correctly, organize your solutions like this:

```
Topic Name/
├── Problem Name/
│   ├── Main.java          # Java solution
│   ├── solution.py        # Python solution
│   └── solution.cpp       # C++ solution
└── Another Problem/
    └── Main.java
```

## LeetCode Link Format

Add the LeetCode link as the first comment in your solution files:

```java
// leetcode problem: https://leetcode.com/problems/two-sum/
```

```python
# leetcode problem: https://leetcode.com/problems/two-sum/
```

## Adding New Languages

To add support for a new programming language:

1. Add the file extension to `LANGUAGE_EXTENSIONS` in `update_readme.py`
2. Add the display name to `LANGUAGE_NAMES` in `update_readme.py`
3. Update the GitHub Actions workflow to trigger on the new file extension

## Troubleshooting

- **Missing LeetCode links**: Make sure the first comment contains the LeetCode URL
- **Wrong problem names**: The script extracts names from LeetCode URLs, ensure URLs are correct
- **File encoding**: Ensure solution files use UTF-8 encoding
- **GitHub Actions not running**: Check that file extensions are included in the workflow triggers 