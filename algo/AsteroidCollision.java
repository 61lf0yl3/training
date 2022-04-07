import java.util.Stack;

class AsteroidCollision {
    // 735. Asteroid Collision

    // Approach 1: Using Stack
    // Time complexity : O(N)
    // Space complexity : O(N)
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            if (stack.isEmpty() || asteroid > 0) {
                stack.add(asteroid);
            } else {
                boolean PUSH = true;
                while (!stack.isEmpty() && stack.peek() > 0) {
                    if (stack.peek() == -asteroid) {
                        PUSH = false;
                        stack.pop();
                        break;
                    } else if (stack.peek() < -asteroid) {
                        stack.pop();
                    } else {
                        PUSH = false;
                        break;
                    }
                }
                if (PUSH) {
                    stack.add(asteroid);
                }
            }
        }
        int[] res = new int[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            res[i--] = stack.pop();
        }
        return res;
    }
}