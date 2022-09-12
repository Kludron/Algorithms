// Longest Common Prefix

#include <vector>
#include <iostream>
#include <string>

using namespace std;

int max(int a, int b) {return (a>b)?a:b;}
int min(int a, int b) {return (a<b)?a:b;}

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string prefix = strs[0];
        for (int i = 1; i < strs.size(); i++) {
            string str = strs[i];
            int len = min(prefix.size(), str.size());
            while (str.substr(0,len) != prefix.substr(0, len)) {
                len -= 1;
            }
            if (len < 1) {return "";}
            if (str.substr(0, len) == prefix.substr(0, len)) {
                prefix = prefix.substr(0, len);
            } else {
                return "";
            }
        }
        return prefix;
    }
};

int main (int argc, char *argv[])
{
    Solution s = Solution();
    vector<string> strs = {"flower", "flow", "flight"};
    cout << s.longestCommonPrefix(strs) << endl;
    return 0;
}       
