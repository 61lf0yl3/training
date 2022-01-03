import java.util.Stack;

class AsteroidCollision {
    // 735. Asteroid Collision

    // Approach 1: Using Stack
    // Time complexity : O(N)
    // Space complexity : O(N)
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for (int a : asteroids) {
            if (s.isEmpty() || a > 0) {
                s.add(a);
            } else {
                boolean insertA = true;
                while (!s.isEmpty() && s.peek() > 0) {
                    if (s.peek() == -a) {
                        insertA = false;
                        s.pop();
                        break;
                    } else if (s.peek() < -a) {
                        s.pop();
                    } else {
                        insertA = false;
                        break;
                    }
                }
                if (insertA) {
                    s.add(a);
                }
            }
        }

        int[] res = new int[s.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = s.pop();
        }
        return res;
    }
}