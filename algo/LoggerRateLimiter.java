import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter {
    public static void main(String[] args) {

    }
}

// Approach 1: Using HashMap
// Time Complexity: O(1)
// Space Complexity: O(N)
class Logger {
    Map<String, Integer> m;

    public Logger() {
        m = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (m.containsKey(message)) {
            if (timestamp - 10 < m.get(message)) {
                return false;
            }
        }
        m.put(message, timestamp);
        return true;
    }
}
