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

    vector<vector<int>> levelOrder2(TreeNode* root) {
        if (root == NULL) {
            return {};
        }
        vector<vector<int>> res;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()) {
            int size = q.size();
            vector<int> level;
            for (int i = 0; i< size; i++) {
                TreeNode* node = q.front();
                q.pop();
                level.push_back(node->val);
                if (node->left != NULL) {
                    q.push(node->left);
                }
                if (node->right != NULL) {
                    q.push(node->right);
                }
            }
            res.push_back(level);
        }
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