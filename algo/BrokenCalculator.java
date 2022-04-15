class BrokenCalculator {
    // Approach 1: Work Backwards
    // Time complexity : O(logT)
    // Space complexity : O(1)
    public int brokenCalc(int startValue, int target) {
        int res = 0;
        while (target > startValue) {
            res++;
            if (target % 2 == 1) {
                target++;
            } else {
                target /= 2;
            }
        }
        return res + startValue - target;
    }
}