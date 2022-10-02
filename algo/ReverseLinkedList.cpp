/**
 * Definition for singly-linked list.
 * struct ListNode {
 * int val;
 * ListNode *next;
 * ListNode() : val(0), next(nullptr) {}
 * ListNode(int x) : val(x), next(nullptr) {}
 * ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution
{
public:
    ListNode *reverseList(ListNode *head)
    {
        if (head == NULL || head->next == NULL)
        {
            return head;
        }

        ListNode *prev = NULL;

        while (head != NULL)
        {
            ListNode *temp = new ListNode(head->val);
            temp->next = prev;
            prev = temp;
            head = head->next;
        }
        return prev;
    }

public:
    ListNode *reverseList(ListNode *head)
    {
        if (head == NULL || head->next == NULL)
        {
            return head;
        }

        ListNode *prev = NULL;
        ListNode *curr = head;
        ListNode *next = curr->next;

        while (curr != NULL)
        {
            next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

public:
    ListNode *reverseList(ListNode *head)
    {
        return helper(head, NULL);
    }

private:
    ListNode *helper(ListNode *node, ListNode *prev)
    {
        if (node == NULL)
        {
            return prev;
        }
        else
        {
            ListNode *temp = new ListNode(node->val);
            temp->next = prev;
            prev = temp;
            return helper(node->next, prev);
        }
    }
};