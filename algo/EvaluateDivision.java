import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class EvaluateDivision {
    // Approach 1: Path Search in Graph
    // Time Complexity: O(N*M)
    // Space Complexity: O(N)
    HashMap<String, HashMap<String, Double>> graph;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph = new HashMap<>();

        // Step 1). build the graph from the equations
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String numerator = equation.get(0);
            String denominator = equation.get(1);
            double value = values[i];
            if (!graph.containsKey(numerator)) {
                graph.put(numerator, new HashMap<String, Double>());
            }
            graph.get(numerator).put(denominator, value);

            if (!graph.containsKey(denominator)) {
                graph.put(denominator, new HashMap<String, Double>());
            }
            graph.get(denominator).put(numerator, 1 / value);
        }

        // Step 2). Evaluate each query via bactracking (DFS)
        // by verifying if there exists a path from dividend to divisor
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String numerator = query.get(0);
            String denominator = query.get(1);

            if (!graph.containsKey(numerator) || !graph.containsKey(denominator)) {
                res[i] = -1.0;
            } else if (numerator.equals(denominator)) {
                res[i] = 1.0;
            } else {
                res[i] = dfs(new HashSet<String>(), numerator, denominator, 1);
            }

        }
        return res;
    }

    private double dfs(HashSet<String> seen, String numerator, String denominator, double value) {
        HashMap<String, Double> neighbors = graph.get(numerator);
        if (neighbors.containsKey(denominator)) {
            return value * neighbors.get(denominator);
        }

        // mark the visit
        seen.add(numerator);
        double ret = -1.0;

        for (String neighbor : neighbors.keySet()) {
            if (!seen.contains(neighbor)) {
                ret = dfs(seen, neighbor, denominator, value * neighbors.get(neighbor));
                if (ret != -1.0) {
                    break;
                }
            }
        }

        // unmark the visit, for the next backtracking
        seen.remove(numerator);
        return ret;
    }
}