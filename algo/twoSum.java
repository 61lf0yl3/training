class twoSum {
    //O(n^2)
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i=0; i < numbers.length; i++) {
            for (int j=i+1; j<numbers.length; j++) {
                if (numbers[i]+numbers[j]==target) {
                    res[0] = i+1;
                    res[1] = j+1;
                }
            }
        }
        return res;
    }
    // O(n)
    public int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];
        int low = 0;
        int high = numbers.length-1;
        while (low < high) {
            int sum = numbers[low]+numbers[high];
            if (sum==target) {
                res[0]=low+1;
                res[1]=high+1;
                return res;
            } else if (sum > target) {
                high--; 
            } else {
                low++;
            }
        }
        return res;
    }
}