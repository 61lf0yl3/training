public class NumberOf1Bits {

    //Approach #1 (Loop and Flip) 
    //Time complexity is O(1)
    //Space complexity is O(1)
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        int mask = 1;
        for (int i=0; i<32; i++) {
            if ((n&mask) != 0) {
                res++;
            }
            mask<<=1;
            System.out.println(mask);
        }
        return n;    
    }
    //Approach #2 (Bit Manipulation Trick) faster that prev
    //Time complexity is O(1)
    //Space complexity is O(1)
    public int hammingWeight2(int n) {
        int res = 0;
        while (n!=0) {
            res++;
            n=n&(n-1);
        }
        return res;    
    }
}