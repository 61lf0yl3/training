import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
class NestedInteger {
    // Constructor initializes an empty nested list.
    public NestedInteger() {
    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {
    }

    // @return true if this NestedInteger holds a single integer, rather than a
    // nested list.

    public boolean isInteger() {
        return true;
    }

    // @return the single integer that this NestedInteger holds, if it holds a
    // single integer

    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return 0;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {
    }
    // Set this NestedInteger to hold a nested list and adds a nested integer to it.

    public void add(NestedInteger ni) {
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested
    // list

    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return null;
    }
}

class NestedListWeightSum {

    // Approach 1: Recursive
    // Time complexity : O(N)
    // Space complexity : O(N)
    int res;

    public int depthSum(List<NestedInteger> nestedList) {
        res = 0;
        depthSumR(nestedList, 0, 1);
        return res;
    }

    private void depthSumR(List<NestedInteger> nestedList, int i, int depth) {
        if (i >= nestedList.size()) {
            return;
        }
        for (int j = 0; j < nestedList.size(); j++) {
            if (nestedList.get(j).isInteger()) {
                res += nestedList.get(j).getInteger() * depth;
            } else {
                depthSumR(nestedList.get(j).getList(), 0, depth + 1);
            }
        }
    }

    // Approach 2: DFS
    // Time complexity : O(N)
    // Space complexity : O(N)
    private void dfs(List<NestedInteger> nestedList, int depth) {
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                res += n.getInteger() * depth;
            } else {
                dfs(n.getList(), depth + 1);
            }
        }
    }

    // Approach 3: BFS
    // Time complexity : O(N)
    // Space complexity : O(N)
    private void bfs(List<NestedInteger> nestedList) {
        int depth = 1;
        Queue<NestedInteger> q = new ArrayDeque();
        q.addAll(nestedList);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                NestedInteger n = q.poll();
                if (n.isInteger()) {
                    res += n.getInteger() * depth;
                } else {
                    q.addAll(n.getList());
                }
            }
            depth++;
        }
    }
}