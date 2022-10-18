/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;

    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution
{

public:
    Node *copyRandomList(Node *head)
    {
        unordered_map<Node *, Node *> m;

        Node *res = new Node(0);
        Node *p = head;

        while (p != NULL)
        {
            m[p] = new Node(p->val);
            p = p->next;
        }

        p = head;
        Node *p2 = res;
        while (p != NULL)
        {
            p2->next = m[p];
            p2 = p2->next;
            p2->random = m[p->random];
            p = p->next;
        }
        return res->next;
    }
};