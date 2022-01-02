import java.util.ArrayList;
import java.util.List;

class BuildingsWithanOceanView {
    // Approach 1: Monotonic Stack Space Optimization
    // Time complexity : O(N)
    // Space complexity : O(1)
    public int[] findBuildings(int[] heights) {
        ArrayList<Integer> indices = new ArrayList<>();
        int prev = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > prev) {
                indices.add(i);
                prev = heights[i];
            }
        }
        int[] res = new int[indices.size()];
        for (int i = indices.size() - 1; i >= 0; i--) {
            res[(indices.size() - 1) - i] = indices.get(i);
        }
        return res;
    }

    // Approach 1: Linear Iteration
    // Time complexity : O(N)
    // Space complexity : O(N)
    public int[] findBuildings2(int[] heights) {
        int n = heights.length;
        List<Integer> list = new ArrayList<>();

        for (int current = 0; current < n; ++current) {
            // If the current building is taller,
            // it will block the shorter building's ocean view to its left.
            // So we pop all the shorter buildings that have been added before.
            while (!list.isEmpty() && heights[list.get(list.size() - 1)] <= heights[current]) {
                list.remove(list.size() - 1);
            }
            list.add(current);
        }

        // Push elements from list to answer array.
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}