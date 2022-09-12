
#include <iostream>
using namespace std;

// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
 };
 
ListNode* reverse(int a);
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        bool carry = false;
        
        ListNode *left = l1;
        ListNode *right = l2;
        
        int sum = left->val + right->val;
        if (sum > 9){carry = true; sum = sum % 10;}
        
        left = left->next;
        right = right->next;
        
        ListNode *result = new ListNode(sum);
        ListNode *head = result;
        
        while(left != NULL && right != NULL) {
            sum = left->val + right->val + ((carry)?1:0);
            
            if (sum >= 10) {carry = true; sum = sum % 10;}
            else {carry = false;}
            
            result->next = new ListNode(sum);
            result = result->next;
            
            left = left->next;
            right = right->next;
        }
        
        if (right != NULL) {
            while (right != NULL) {
                sum = right->val + ((carry)?1:0);
                
                if (sum >= 10) {carry = true; sum = sum % 10;}
                else {carry = false;}

                result->next = new ListNode(sum);
                result = result->next;

                right = right->next;
            }
        } else if (left != NULL) {
            while (left != NULL) {
                sum = left->val + ((carry)?1:0);
                
                if (sum >= 10) {carry = true; sum = sum % 10;}
                else {carry = false;}

                result->next = new ListNode(sum);
                result = result->next;

                left = left->next;
            }
        }

        if (carry) {
            result -> next = new ListNode(1);
        }
        
        return head;
    }
};

int main (int argc, char *argv[])
{
    int left  [] = {9,9,9,9,9,9,9};
    int right [] = {9,9,9,9};

    ListNode *l1 = new ListNode(left[0]);
    ListNode *l1head = l1;
    int l1Size = *(&left+1)-left;
    for (int i = 1; i < l1Size; i++) {
        l1->next = new ListNode(left[i]);
        l1 = l1->next;
    }

    ListNode *l2 = new ListNode(right[0]);
    ListNode *l2head = l2;
    int l2Size = *(&right+1)-right;
    for (int i = 1; i < l2Size; i++) {
        l2->next = new ListNode(right[i]);
        l2 = l2->next;
    }
    
    ListNode *result = Solution().addTwoNumbers(l1head, l2head);
    while (result != NULL) {
        cout << result->val;
        result = result->next;
    }
    cout << endl;

    return 0;
}
