class SingleNumber {

    //Approach : Bit Manipulation
    //Time complexity : O(n)
    //Space complexity : O(1)
    /**
     * If we take XOR of zero and some bit, it will return that bit: a⊕0=a
     * If we take XOR of two same bits, it will return 0: a⊕a=0
     * a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
    */
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i=0;i<nums.length;i++) {
            a ^= nums[i];
        }
        return a;
    }
}