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
