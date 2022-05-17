import java.util.Arrays;

class ThreeSumWithMultiplicity {
    public int threeSumMulti(int[] arr, int target) {
        int MOD = 1000000007;
        int res = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            int k = arr.length - 1;
            int target2 = target - arr[i];
            while (j < k) {
                if (arr[j] + arr[k] > target2) {
                    k--;
                } else if (arr[j] + arr[k] < target2) {
                    j++;
                } else if (arr[j] != arr[k]) {
                    int duplicatsLeft = 1;
                    while (j + 1 < k && arr[j] == arr[j + 1]) {
                        duplicatsLeft++;
                        j++;
                    }
                    int duplicatsRight = 1;
                    while (j < k - 1 && arr[k] == arr[k - 1]) {
                        duplicatsRight++;
                        k--;
                    }
                    res += duplicatsLeft * duplicatsRight;
                    res %= MOD;
                    j++;
                    k--;
                } else {
                    // M = k-j+1
                    // We count with (M-1)*M/2
                    res += (k - j) * (k - j + 1) / 2;
                    res %= MOD;
                    break;
                }
            }
        }
        return res;
    }
}