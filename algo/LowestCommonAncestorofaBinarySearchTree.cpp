/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        queue<TreeNode*> qu;
        qu.push(root);
        while (!qu.empty()) {
            TreeNode* node = qu.front();
            qu.pop();
            if (p->val < node->val && q->val < node->val) {
                qu.push(node->left);
            } else if (p->val > node->val && q->val > node->val) {
                qu.push(node->right);
            } else {
                return node;
            }
        }
        return NULL;
    }
};