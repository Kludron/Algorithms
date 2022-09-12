
#include <iostream>
#include <vector>

#include "twoSum.h"
#include "lis.h"
using namespace std;

int main() {
    Solution sol;

    vector<int> nums = {2,7,6,9, 5};
    int target = 7;

    vector<int> result = sol.twoSum(nums, target);
    for (int i = 0; i < result.size(); i++)
        cout << result.at(i) << ' ';
    cout << endl;
}
