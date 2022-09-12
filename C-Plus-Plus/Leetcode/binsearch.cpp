#include <iostream>
#include <vector>
#include <math.h>

using namespace std;

class Solution {
    public:
        int search(vector<int>& nums, int target) {
            int j = 1;
            int i = nums.size()/pow(2, j);
            while (nums[i] != target) {
                int incdec = nums.size()/pow(2,j);
                if (incdec < 1) {
                    return -1;
                }

                if (nums[i] < target) {
                    i += incdec;
                } else {
                    i -= incdec;
                    j++;
                }
            }
            return i;
        }
};

int main(void) {
    Solution s = Solution();
    vector<int> nums = {-1,0,3,5,9,12};
    cout << s.search(nums, 9) << endl;
}
