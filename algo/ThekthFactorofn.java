import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class ThekthFactorofn {
    // Approach 1: Brute Force
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int kthFactor(int n, int k) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                k--;
                if (k == 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    // Approach 2: Iterative Using Heap
    // Time Complexity: O(sqrt(N)*logK)
    // Space Complexity: O(min(N, K))
    public int kthFactor2(int n, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                heap.add(i);
                if (heap.size() > k) {
                    heap.poll();
                }
                if (i * i != n) {
                    heap.add(n / i);
                }
                if (heap.size() > k) {
                    heap.poll();
                }
            }
        }
        if (heap.size() < k) {
            return -1;
        }
        return heap.peek();
    }

    // Approach 3: Iterative Using Math
    // Time Complexity: O(sqrt(N))
    // Space Complexity: O(min(sqrt(N), K))
    public int kthFactor3(int n, int k) {
        ArrayList<Integer> divisors = new ArrayList<>();
        int sqrtN = 1;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                k--;
                if (k == 0) {
                    return i;
                }
            }
            sqrtN = i;
        }
        // If n is a perfect square
        // we have to skip the duplicate
        // in the divisor list
        if (sqrtN * sqrtN == n) {
            k++;
        }
        int nDiv = divisors.size();
        if (k <= nDiv) {
            return n / divisors.get(nDiv - k);
        }
        return -1;
    }
}