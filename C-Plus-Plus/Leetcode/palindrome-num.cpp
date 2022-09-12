
#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0) {return false;}
        if (x < 10) {return true;}
        string number = to_string(x);
        int left = 0;
        int right = number.length()-1;
        while (left < right) {
            if (number[left] != number[right]) {return false;}
            left ++;
            right --;
        }
        return true; 
    }
};

int main (int argc, char *argv[])
{
    int x = 121;
    if (Solution().isPalindrome(x))
        cout << "True" << endl;
    else
        cout << "False" << endl;
}
