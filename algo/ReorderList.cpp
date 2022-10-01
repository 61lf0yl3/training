/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution
{
public:
    void reorderList(ListNode *head)
    {
        ListNode *slow = head;
        ListNode *fast = head;
        while (fast != NULL && fast->next != NULL)
        {
            fast = fast->next->next;
            slow = slow->next;
        }

        ListNode *reversed = NULL;
        ListNode *tmp;
        while (slow != NULL)
        {
            tmp = slow->next;
            slow->next = reversed;
            reversed = slow;
            slow = tmp;
        }

        while (reversed->next != NULL)
        {
            tmp = head->next;
            head->next = reversed;
            head = tmp;

            tmp = reversed->next;
            reversed->next = head;
            reversed = tmp;
        }
    }
};