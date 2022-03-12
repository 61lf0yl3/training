import java.util.Stack;

public class TrappingRainWater {
    // Approach 1: DP
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        for (int i = 0; i < n; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }

    // Approach 2: Two Pointer
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int trap2(int[] height) {
        int n = height.length;
        int res = 0;
        int left = 0;
        int leftMax = 0;

        int right = n - 1;
        int rightMax = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    res += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    res += rightMax - height[right];
                }
                right--;
            }
        }
        return res;
    }

    // Approach 3: Using Stack
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int trap3(int[] height) {
        int n = height.length;
        int res = 0;
        Stack<Integer> s = new Stack<>();
        s.add(height[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            s.add(Math.max(height[i], s.peek()));
        }
        int leftMax = 0;
        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, height[i]);
            res += Math.min(leftMax, s.pop()) - height[i];
        }
        return res;
    }

    // Approach 4: Brute Force
    // Time Complexity: O(N^2)
    // Space Complexity: O(1)
    public int trap4(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int j = i; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }

            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            res += Math.min(leftMax, rightMax) - height[i];
        }
        return res;
    }

}
