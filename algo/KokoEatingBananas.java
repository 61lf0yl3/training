class KokoEatingBananas {
    // Approach 2: Brute Force
    // Time Complexity: O(N*M)
    // Space Complexity: O(1)
    public int minEatingSpeed2(int[] piles, int h) {
        int max = 0;
        int min = 1;
        for (int num : piles) {
            max = Math.max(num, max);
        }

        for (int speed = min; speed < max; speed++) {
            int currH = 0;
            for (int pile : piles) {
                currH += Math.ceil((double) pile / speed);
                if (currH > h) {
                    break;
                }
            }
            if (currH <= h) {
                return speed;
            }
        }
        return max;
    }
}