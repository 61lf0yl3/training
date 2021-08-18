
class s17md1 {
    public static void main(String[] args) {
        int[] vals = {1,2,1,2,1};
        System.out.println(more1sThan2s(vals));
    }

    public static boolean more1sThan2s(int[] vals) { int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < vals.length; i++) {
            if (vals[i] == 1){ 
                count1++;
                count2 = 0;
            } else if (vals[i] == 2) {
            count2++;
            count1 = 0; }
            }
        return count1 > count2; 
    }
}