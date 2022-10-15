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
    
    TreeNode* lowestCommonAncestor2(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (root == NULL) {
            return NULL;
        }
        
        if (p->val < root->val && q->val < root->val) {
                return lowestCommonAncestor(root->left, p, q);
        } else if (p->val > root->val && q->val > root->val) {
                return lowestCommonAncestor(root->right, p, q);
        } else {
                return root;
        }
        
    }
};