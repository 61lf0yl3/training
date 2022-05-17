import java.util.Arrays;

// Approach 1: Tree Pointer based on Two Pointer
// Time Complexity: O(N^2)
// Space Complexity: O(1)
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

    public int threeSumMulti(int[] A, int target) {
        int MOD = 1_000_000_007;
        long[] count = new long[101];
        for (int x : A)
            count[x]++;

        long ans = 0;

        // All different
        for (int x = 0; x <= 100; ++x)
            for (int y = x + 1; y <= 100; ++y) {
                int z = target - x - y;
                if (y < z && z <= 100) {
                    ans += count[x] * count[y] * count[z];
                    ans %= MOD;
                }
            }

        // x == y != z
        for (int x = 0; x <= 100; ++x) {
            int z = target - 2 * x;
            if (x < z && z <= 100) {
                ans += count[x] * (count[x] - 1) / 2 * count[z];
                ans %= MOD;
            }
        }

        // x != y == z
        for (int x = 0; x <= 100; ++x) {
            if (target % 2 == x % 2) {
                int y = (target - x) / 2;
                if (x < y && y <= 100) {
                    ans += count[x] * count[y] * (count[y] - 1) / 2;
                    ans %= MOD;
                }
            }
        }

        // x == y == z
        if (target % 3 == 0) {
            int x = target / 3;
            if (0 <= x && x <= 100) {
                ans += count[x] * (count[x] - 1) * (count[x] - 2) / 6;
                ans %= MOD;
            }
        }

        return (int) ans;
    }
}