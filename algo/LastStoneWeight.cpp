class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        priority_queue<int> q;
        for (int i = 0; i < stones.size(); i++) {
            q.push(stones[i]);
        }
        while (q.size() > 1) {
            int y = q.top();
            q.pop();
            int x = q.top();
            q.pop();
            q.push(y-x);
        }
        return q.top();
    }
};