#include <iostream>
#include <vector>
using namespace std;

class Solution {
    public:
        int lengthOfLIS(vector<int>& nums) {
            int longest = 1;
            int current = 1;
            for (int i = 0; i < nums.size(); i++) {
                for (int j = i+1; j < nums.size(); j++) {
                    if (nums[j] > nums[i]) {
                        current ++;
                        cout << nums[j] << '>' << nums[i] << endl;
                        cout << current << endl;
                    }
                }
                longest = max(longest, current);
                current = 1;
            }
            return longest;
        }
};

int max(const int &a, const int &b){
    return (a > b) ? a : b;
}

int main(void) {
    Solution s = Solution();
    vector<int> nums = {10,9,2,5,3,7,101,18};
    int result = s.lengthOfLIS(nums);
    int answer = 4;
    cout << result << " vs " << answer << endl;    
    const char *compare = (answer == result) ? "True" : "False";
    cout << compare << endl;
}
