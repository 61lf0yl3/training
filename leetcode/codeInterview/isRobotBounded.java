class IsRobotBounded {
    public boolean isRobotBounded(String instructions) {
        int[] position = new int[]{0,0};
        int degree = 0;  // north = 0; east = 1; south = 2; west = 3
        for (int i=0; i<instructions.length(); i++) {
            if (instructions.charAt(i) == 'G' ) {
                if (degree == 0) {
                    position[1]++;
                } else if (degree == 1) {
                    position[0]++;
                } else if (degree == 2) {
                    position[1]--;
                } else if (degree == 3) {
                    position[0]--;
                }
            } else if (instructions.charAt(i) == 'L') {
                degree+=3;
                degree = degree % 4;
            } else if (instructions.charAt(i) == 'R') {
                degree++;
                degree = degree % 4;
            }
        }
        if ((position[0] == 0 && position[1] == 0) || (degree != 0)) {
            return true;
        }
        return false;
    }
}