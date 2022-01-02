import java.util.ArrayList;

class BuildingsWithanOceanView {
    // Approach 1: Iterative
    // Time complexity : O(N)
    // Space complexity : O(N)
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
}