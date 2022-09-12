
#include <iostream>
#include <vector>
#include <sstream>
#include <map>

#include "twoSum.h"
using namespace std;

vector<int> Solution::twoSum(vector<int> &nums, int target) {
    map<int, int> hashmap;
    for (int i = 0; i < nums.size(); i++) {
        map<int, int>::iterator kv = hashmap.find(target-nums[i]);
        if (kv != hashmap.end())
            return {kv->second, i};
        hashmap.insert({nums[i], i});
    }
    return {0,0};
}

/*
class Solution {
    public:
        vector<int> twoSum(vector<int>& nums, int target) {
            map<int, int> hashmap;
            for (int i = 0; i < nums.size(); i++) {
                map<int, int>::iterator kv = hashmap.find(target-nums[i]);
                if (kv != hashmap.end())
                    return vector<int> {kv->second, i};
                hashmap.insert({nums[i], i});
            }
            return vector<int> {0,0};
    }
};
*/
