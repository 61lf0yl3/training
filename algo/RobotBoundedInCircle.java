class RobotBoundedInCircle {

    // 1041. Robot Bounded In Circle

    // Approach 1: One Pass
    // Time complexity : O(N)
    // Space complexity : O(1)
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int degree = 0;
        for (int i = 0; i < 4; i++) {
            for (char move : instructions.toCharArray()) {
                if (move == 'G') {
                    if (degree == 0) {
                        y++;
                    } else if (degree == 90) {
                        x++;
                    } else if (degree == 180) {
                        y--;
                    } else {
                        x--;
                    }
                } else {
                    if (move == 'L') {
                        degree += 270;
                    } else if (move == 'R') {
                        degree += 90;
                    }
                    degree %= 360;
                }
            }
        }
        return x == 0 && y == 0;
    }
}