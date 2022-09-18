/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool isValidBST(TreeNode* root) {
        return dfs(root, NULL, NULL);
    }
    
private: 
    bool dfs(TreeNode* root, int start, int end) {
        if (root == NULL) {
            return true;
        }
        if ((start != NULL && root->val <= start) ||
            (end != NULL && root->val >= end)) {
            return false;
        }
        return dfs(root->left, start, root->val)
            && dfs(root->right, root->val, end);
    }
};