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
    vector<int> rightSideView(TreeNode* root) {
        vector<int> res;
        if (root == NULL) {
            return res;
        }
        queue<TreeNode*> q;
        q.push(root);
        while (!q.empty()) {
            int size = q.size();
            int mostright;
            for (int i = 0; i < size; i++) {
                TreeNode* node = q.front();
                q.pop();
                mostright = node->val;
                if (node->left != NULL) {
                    q.push(node->left);
                }
                if (node->right != NULL) {
                    q.push(node->right);
                }
            }
            res.push_back(mostright);
        }
        return res;
    }

    vector<int> rightSideView2(TreeNode* root) {
        if (root == NULL) {
            return res;
        }
        dfs(root, 0);
        return res;
    }

private:
    vector<int> res;
    void dfs(TreeNode* node, int depth) {
        if (node == NULL) {
            return;
        }
        if (res.size() == depth) {
            res.push_back(node->val);
        }
        dfs(node->right, depth+1);
        dfs(node->left, depth+1);
    }
};