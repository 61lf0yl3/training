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
    ListNode *mergeKLists(vector<ListNode *> &lists)
    {
        priority_queue<int, vector<int>, greater<int> > pq;
        for (int i = 0; i < lists.size(); i++)
        {
            ListNode *list = lists[i];
            while (list != NULL)
            {
                pq.push(list->val);
                list = list->next;
            }
        }
        ListNode *res = new ListNode();
        ListNode *p = res;
        while (!pq.empty())
        {
            p->next = new ListNode(pq.top());
            pq.pop();
            p = p->next;
        }
        return res->next;
    }
};