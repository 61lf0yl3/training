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
    bool isSubtree(TreeNode* root, TreeNode* subRoot) {
        if (subRoot == NULL) {
            return true;
        }
        if (root == NULL) {
            return false;
        }
        bool res = false;
        if (root->val == subRoot->val) {
            res = dfs(root, subRoot);
        }
        return res || isSubtree(root->left, subRoot) || isSubtree(root->right, subRoot);
    }
    
private:
    bool dfs(TreeNode* root, TreeNode* subRoot) {
        if (root == NULL && subRoot == NULL) {
            return true;
        }
        if (root == NULL || subRoot == NULL) {
            return false;
        }
        if (root->val != subRoot->val) {
            return false;
        }
        return dfs(root->left, subRoot->left) && dfs(root->right, subRoot->right);
    }
};