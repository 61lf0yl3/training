public class ReverseBits {
    //Approach 1: Bit by Bit
    // you need treat n as an unsigned value
    //Time Complexity:O(1)
    //Space Complexity: O(1) 
    public int reverseBits(int n) {
        int power = 31;
        int res = 0;
        while (power >= 0) {
            res += (n&1)<<power;
            n = n >>= 1;
            power-=1;
        }
        return res;
    }
}