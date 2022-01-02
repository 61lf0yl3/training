import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new CompareLogs());
        return logs;
    }
}

// Approach 1: Using Comparator
// Time complexity : O(MNlogN) Let N be the number of logs in the list and M be
// the maximum length of a single log.
// Space complexity : O(MlogN)
class CompareLogs implements Comparator<String> {
    public int compare(String a, String b) {
        String[] log1 = a.split(" ", 2);
        String[] log2 = b.split(" ", 2);

        boolean isDigit1 = Character.isDigit(log1[1].charAt(0));
        boolean isDigit2 = Character.isDigit(log2[1].charAt(0));

        // both string
        if (!isDigit1 && !isDigit2) {
            int compareByIdentifier = log1[1].compareTo(log2[1]);
            if (compareByIdentifier != 0) {
                return compareByIdentifier;
            }
            return log1[0].compareTo(log2[0]);
        } else if (!isDigit1 && isDigit2) {
            return -1;
        } else if (isDigit1 && !isDigit2) {
            return 1;
        } else {
            return 0;
        }
    }
}