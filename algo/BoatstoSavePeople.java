import java.util.Arrays;

class BoatstoSavePeople {

    // Approach 1: Greedy
    // Time Complexity: O(NlogN)
    // Space Complexity: O(logN)
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int low = 0;
        int high = people.length - 1;
        int res = 0;
        while (low <= high) {
            res++;
            if (people[low] + people[high] <= limit) {
                low++;
            }
            high--;
        }
        return res;
    }
}