#include <iostream>
#include <string>
#include <vector>
#include <map>

using namespace std;

class Solution {
    public:
        int romanToInt(string str) {
            map<char, int> rintegers = {
                {'I' , 1},
                {'V' , 5},
                {'X' , 10},
                {'L' , 50},
                {'C' , 100},
                {'D' , 500},
                {'M' , 1000},
            };
            int result = 0;
            int cur = 0;
            for (int i = 0; i < str.length(); i++) {
                cur = rintegers[str[i]];
                if (cur < rintegers[str[i+1]]) {
                    result -= cur;
                } else {
                    result += cur;
                }
            }
            return result;
        }
};

int main (void) {
    Solution s = Solution();
    vector<string> romans = {
        // "III",
        // "IV",
        // "VI",
        // "IIV",
        // "LIV",
        // "VII",
        // "LVI",
        // "LVIII",
        "MCMXCIV",
    };
    for (int i = 0; i < romans.size(); i++) {
        cout << s.romanToInt(romans[i]) << endl;
    }
}
