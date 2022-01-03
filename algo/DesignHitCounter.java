import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class DesignHitCounter {
    public static void main(String[] args) {

    }
}

// Approach 1: Using Queue
// Time complexity : O(1)
// Space complexity : O(1)
class HitCounter {
    private Queue<Integer> q;

    /** Initialize your data structure here. */
    public HitCounter() {
        q = new LinkedList<>();
    }

    /**
     * Record a hit.
     * 
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        q.add(timestamp);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     * 
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        while (!q.isEmpty()) {
            int diff = timestamp - q.peek();
            if (diff >= 300) {
                q.remove();
            } else {
                break;
            }
        }
        return q.size();
    }
}

// Approach 2: Using Deque with Pair
// Time complexity : O(1)
// Space complexity : O(1)
class HitCounter2 {
    private int total;
    private Deque<Pair<Integer, Integer>> q;

    /** Initialize your data structure here. */
    public HitCounter2() {
        total = 0;
        q = new LinkedList<Pair<Integer, Integer>>();
    }

    /**
     * Record a hit.
     * 
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        if (q.isEmpty() || q.getLast().getKey() != timestamp) {
            // Insert the new timestamp with count = 1
            q.add(new Pair(timestamp, 1));
        } else {
            // Update the count of latest timestamp by incrementing the count by 1

            // Obtain the current count of the latest timestamp
            int val = q.getLast().getValue();
            // Remove the last pair of (timestamp, count) from the deque
            q.removeLast();
            // Insert a new pair of (timestamp, updated count) in the deque
            q.add(new Pair(timestamp, val + 1));
        }
        // Increment total
        total++;
    }

    /**
     * Return the number of hits in the past 5 minutes.
     * 
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        while (!q.isEmpty()) {
            int diff = timestamp - q.peek().getKey();
            if (diff >= 300) {
                // Decrement total by the count of the oldest timestamp
                total -= q.peek().getValue();
                q.remove();
            } else {
                break;
            }
        }
        return total;
    }
}