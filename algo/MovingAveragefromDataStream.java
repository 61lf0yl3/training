import java.util.Queue;
import java.util.LinkedList;

class MovingAverage {
    private int size;
    private int sum;
    private Queue<Integer> last;

    public MovingAverage(int size) {
        this.size = size;
        sum = 0;
        size = 0;
        last = new LinkedList<>();
    }

    public double next(int val) {
        if (size <= last.size()) {
            sum -= last.poll();
        }
        sum += val;
        last.add(val);
        return sum * 1.0 / last.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */