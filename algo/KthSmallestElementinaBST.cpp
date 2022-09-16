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
    int kthSmallest(TreeNode* root, int k) {
        dfs(root, k);
        return list[k-1];
    }
private:
    vector<int> list;
    void dfs(TreeNode* node, int k) {
        if (node == NULL) {
            return;
        }
        if (list.size() < k) {
            dfs(node->left, k);
            list.push_back(node->val);
            dfs(node->right, k);
        } else {
            return;
        }
    }
};