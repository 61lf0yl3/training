import java.util.Arrays;
import java.util.Comparator;

class ReorderDatainLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new SortLogs());
        return logs;
    }
}

// Approach 1: Using Comparator
// Time complexity : O(MNlogN) Let N be the number of logs in the list and M be
// the maximum length of a single log.
// Space complexity : O(MlogN)
class SortLogs implements Comparator<String> {
    public int compare(String a, String b) {
        String[] aArr = a.split(" ", 2);
        String[] bArr = b.split(" ", 2);

        boolean aDigit = Character.isDigit(aArr[1].charAt(0));
        boolean bDigit = Character.isDigit(bArr[1].charAt(0));

        if (!aDigit && !bDigit) {
            int compare = aArr[1].compareTo(bArr[1]);
            if (compare != 0) {
                return compare;
            }
            return aArr[0].compareTo(bArr[0]);
        } else if (!aDigit && bDigit) {
            return -1;
        } else if (aDigit && !bDigit) {
            return 1;
        }
        return 0;
    }
}