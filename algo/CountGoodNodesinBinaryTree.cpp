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
    int goodNodes(TreeNode* root) {
        dfs(root, root->val);
        return res;
    }
    
private:
    int res;
    void dfs(TreeNode* root, int currentMax) {
        if (root == NULL) {
            return;
        }
        if (root->val >= currentMax) {
            res++;
        }
        dfs(root->left, max(currentMax, root->val));
        dfs(root->right, max(currentMax, root->val));
    }
};