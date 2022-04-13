import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * // Constructor initializes an empty nested list.
 * public NestedInteger();
 *
 * // Constructor initializes a single integer.
 * public NestedInteger(int value);
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list.
 * public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // Set this NestedInteger to hold a single integer.
 * public void setInteger(int value);
 *
 * // Set this NestedInteger to hold a nested list and adds a nested integer to
 * it.
 * public void add(NestedInteger ni);
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
class NestedListWeightSum2 {
    // Approach 1: Depth-first Search
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    int maxDepth = 0;
    int res = 0;

    public int depthSumInverse(List<NestedInteger> nestedList) {
        depthR(nestedList, 0);
        depthSumR(nestedList, 0);
        return res;
    }

    private void depthR(List<NestedInteger> nestedList, int depth) {
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                maxDepth = Math.max(maxDepth, depth);
            } else {
                depthR(n.getList(), depth + 1);
            }
        }
    }

    private int depthR2(List<NestedInteger> nestedList) {
        int depth = 1;
        for (NestedInteger n : nestedList) {
            if (!n.isInteger()) {
                depth = Math.max(depth, 1 + depthR2(n.getList()));
            }
        }
        return depth;
    }

    private void depthSumR(List<NestedInteger> nestedList, int depth) {
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                res += (maxDepth - depth + 1) * n.getInteger();
            } else {
                depthSumR(n.getList(), depth + 1);
            }
        }
    }

    // Approach 1: Single Pass Breadth-first Search
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int depthSumInverse3s(List<NestedInteger> nestedList) {
        int maxDepth = 0;
        int depth = 1;
        int sumInteger = 0;
        int sumDepthInteger = 0;

        Queue<NestedInteger> q = new LinkedList<>();
        q.addAll(nestedList);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                NestedInteger n = q.poll();
                if (n.isInteger()) {
                    sumInteger += n.getInteger();
                    sumDepthInteger += n.getInteger() * depth;
                } else {
                    q.addAll(n.getList());
                }
            }
            depth++;
        }

        return depth * sumInteger - sumDepthInteger;
    }

    // Approach 1: Single Pass Depth-first Search
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    int sumOfElements = 0;
    int sumOfProducts = 0;

    public int depthSumInverse2(List<NestedInteger> nestedList) {
        depthSumR2(nestedList, 0);
        return (maxDepth + 1) * sumOfElements - sumOfProducts;
    }

    private void depthSumR2(List<NestedInteger> nestedList, int depth) {
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                maxDepth = Math.max(maxDepth, depth);
                sumOfElements += n.getInteger();
                sumOfProducts += depth * n.getInteger();
            } else {
                depthSumR(n.getList(), depth + 1);
            }
        }
    }
}