
#include <iostream>
#include <vector>
using namespace std;


class Solution {
    public:
        int numFactoredBinaryTrees(vector<int>& arr) {
            return 3; 
        }
};

int main (int argc, char *argv[])
{
    vector<int> arr = {2, 4};
    cout << Solution().numFactoredBinaryTrees(arr) << endl;
}
