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
    bool dfs(TreeNode* root, TreeNode* start, TreeNode* end) {
        if (root == NULL) {
            return true;
        }
        if ((start != NULL && root->val <= start->val) ||
            (end != NULL && root->val >= end->val)) {
            return false;
        }
        return dfs(root->left, start, root)
            && dfs(root->right, root, end);
    }
};