"""
Given a string *s* containing just the characters
'(', ')', '{', '}', '[' and ']', determine if the input string is valid.

Input string is valid if:
    1. Open brackets must be closed by the same type of brackets
    2. Open brackets must be closed in the correct order.

Example 1:
    s = "()"
    Answer = True

Example 2:
    s = "()[]{}"
    Answer = True

Example 3:
    s = "(]"
    Answer = False

Constraints:
    - 1 <= s.length <= 10^4
    - s consists of only ()[]{}
"""
