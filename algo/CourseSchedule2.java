import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    // Approach 2: Using Node Indegree
    // Time Complexity: O(V+E)
    // Space Complexity: O(V+E)
    public int[] findOrde1(int numCourses, int[][] prerequisites) {
        boolean isAcyclic = true;
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] topologicalOrder = new int[numCourses];

        // Create the adjacency list representation of the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            if (!adjList.containsKey(src)) {
                adjList.put(src, new ArrayList());
            }
            adjList.get(src).add(dest);

            // Record in-degree of each vertex
            indegree[dest]++;
        }

        // Add all vertices with 0 in-degree to the queue
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int i = 0;
        // Process until the Q becomes empty
        while (!q.isEmpty()) {
            int node = q.poll();
            topologicalOrder[i++] = node;

            // Reduce the in-degree of each neighbor by 1
            if (adjList.containsKey(node)) {
                for (Integer neighbor : adjList.get(node)) {
                    indegree[neighbor]--;

                    // If in-degree of a neighbor becomes 0, add it to the Q
                    if (indegree[neighbor] == 0) {
                        q.add(neighbor);
                    }
                }
            }
        }

        if (i == numCourses) {
            return topologicalOrder;
        }
        return new int[0];
    }

    // Approach 1: Using Depth First Search
    // Time Complexity: O(V+E)
    // Space Complexity: O(V+E)
    static int NOT_PROCESSED = 1;
    static int PROCESSING = 2;
    static int PROCESSED = 3;

    boolean isAcyclic = true;
    Map<Integer, Integer> proccessStage = new HashMap<>();
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    List<Integer> topologicalOrder = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // By default all vertces are WHITE
        for (int i = 0; i < numCourses; i++) {
            if (!proccessStage.containsKey(i)) {
                proccessStage.put(i, NOT_PROCESSED);
            }
        }

        // Create the adjacency list representation of the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            if (!adjList.containsKey(src)) {
                adjList.put(src, new ArrayList<>());
            }
            adjList.get(src).add(dest);
        }

        // If the node is unprocessed, then call dfs on it.
        for (int i = 0; i < numCourses; i++) {
            if (proccessStage.get(i) == NOT_PROCESSED) {
                dfs(i);
            }
        }

        int[] res;
        if (isAcyclic) {
            res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = topologicalOrder.get(numCourses - i - 1);
            }
        } else {
            res = new int[0];
        }
        return res;
    }

    private void dfs(int node) {
        // Don't recurse further if we found a cycle already
        if (!isAcyclic) {
            return;
        }

        // Start the recursion
        proccessStage.put(node, PROCESSING);

        // Traverse on neighboring vertices
        for (Integer neighbor : adjList.getOrDefault(node, new ArrayList<Integer>())) {
            if (proccessStage.get(neighbor) == NOT_PROCESSED) {
                dfs(neighbor);
            } else if (proccessStage.get(neighbor) == PROCESSING) {
                // An edge to a GRAY vertex represents a cycle
                isAcyclic = false;
            }
        }

        // Recursion ends. We mark it as black
        proccessStage.put(node, PROCESSED);
        topologicalOrder.add(node);
    }

}
