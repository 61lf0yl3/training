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
    vector<vector<int>> res;
    vector<vector<int>> levelOrder(TreeNode* root) {
        if (root == NULL) {
            return res;
        }
        dfs(root, 0);
        return res;
    }
    
private:
    void dfs(TreeNode* node, int level) {
        if (node == NULL) {
            return;
        }
        if (res.size() <= level) {
            res.push_back({});
        }
        res[level].push_back(node->val);
        dfs(node->left, level+1);
        dfs(node->right, level+1);
    }
};