import java.util.Queue;
import java.util.LinkedList;

class MovingAverage {
    // Approach 2: Iterative
    // Time Complexity: O(1)
    // Space Complexity: O(N)
    private int size;
    private int sum;
    private Queue<Integer> queue;

    public MovingAverage(int size) {
        this.size = size;
        sum = 0;
        queue = new LinkedList<>();
    }

    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.poll();
        }
        sum += val;
        queue.add(val);
        return sum / (double) queue.size();
    }

}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */