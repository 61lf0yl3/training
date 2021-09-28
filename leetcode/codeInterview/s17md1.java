
class s17md1 {
    public static void main(String[] args) {
        int[] vals = {};
        //System.out.println(more1sThan2s(vals));
        System.out.println(hasDouble5or8(vals));
    }

    public static boolean hasDouble5or8(int[] nums) {
        boolean hasDouble5 = false;
        boolean hasDouble8 = false;
        boolean res = false;

        for (int i=0;i< nums.length -1; i++) {
            if (nums[i] == 5 && nums[i]==nums[i+1]) {
                hasDouble5 = true;
                res = true;
            } 
            if (nums[i] == 8 && nums[i]==nums[i+1]) {
                hasDouble8 = true;
                res = true;
            }
        }
        if (hasDouble5 == hasDouble8) {
            res = false;
        } 
        return res;
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