class PowerOfTwo {

    // Approach 2: Bitwise operators : Turn off the Rightmost 1-bit
    //Time complexity : O(1)
    //Space complexity : O(1)
    public boolean isPowerOfTwo2(int n) {
        if (n == 0) {
            return false;
        }
        long x = (long) n;

        // we are doing AND with n-1 because bitshifting does not work all the time like like (001010 == 10 >> 000101 == 5)
        return (x&(x-1)) == 0;
    }

    // Approach 1: Bitwise operators : Turn off the Rightmost 1-bit
    //Time complexity : O(1)
    //Space complexity : O(1)
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (-x)) == x;
      }
}