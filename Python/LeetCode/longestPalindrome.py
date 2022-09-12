class Solution:
    def longestPalindrome(self, s: str) -> str:    
        longest=s[0]
        for i in range(len(s)):
            start = end = i
            while s[start] == s[end]:
                # Try move start back one
                if start > 0 and end < len(s)-1:
                    if s[start-1] == s[end+1]:
                        start -= 1
                        end += 1
                    elif s[start-1] == s[end]:
                        start -= 1
                    elif s[start] == s[end+1]:
                        end += 1
                    else:
                        break
                elif end < len(s)-1:
                    # Ensure that EVERY letter is the same then...
                    isSame=True
                    for letter in s[start:end+1]:
                        if letter != s[start]:
                            isSame=False
                    if s[start] == s[end+1] and isSame:
                        end += 1
                    else:
                        break
                elif start > 0:
                    # Ensure that EVERY letter is the same then...
                    isSame=True
                    for letter in s[start:end+1]:
                        if letter != s[start]:
                            isSame=False
                    if s[start-1] == s[end] and isSame:
                        start -= 1
                    else:
                        break
                else:
                    break
            sub=s[start:end+1]
            if sub[0]==sub[-1] and len(longest) < len(sub):
                longest=sub
        return longest

if __name__ == '__main__':
    s = Solution()
    print(s.longestPalindrome("aacabdkacaa"))