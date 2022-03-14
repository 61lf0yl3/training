import java.util.Arrays;

class CountUniqueCharactersofAllSubstringsofaGivenString {
    // Approach 1:
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int uniqueLetterString(String s) {
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);

        int[] secLastSeen = new int[26];
        Arrays.fill(secLastSeen, -1);

        int count = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'A';

            int p = lastSeen[index];
            int q = secLastSeen[index];

            count += i - p - p + q;
            res += count;
            secLastSeen[index] = lastSeen[index];
            lastSeen[index] = i;
        }
        return res;
    }
}