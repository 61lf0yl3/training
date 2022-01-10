import java.util.Comparator;
import java.util.Arrays;
import java.util.PriorityQueue;

class MaximumNumberofEventsThatCanBeAttended {

    public int maxEvents(int[][] events) {
        int n = events.length;
        if (n == 1) {
            return 1;
        }

        SortEvents sortComparator = new SortEvents();
        Arrays.sort(events, sortComparator);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        int i = 0;
        int min = sortComparator.getMin();
        int max = sortComparator.getMax();

        for (int d = min; d <= max; d++) {
            while (i < n && events[i][0] == d)
                pq.add(events[i++][1]);
            while (!pq.isEmpty() && pq.peek() < d)
                pq.poll();
            if (!pq.isEmpty()) {
                res++;
                pq.poll();
            }
        }
        return res;
    }

}

class SortEvents implements Comparator<int[]> {
    int max;
    int min;

    public SortEvents() {
        min = Integer.MAX_VALUE;
        max = 0;
    }

    public int compare(int[] a, int[] b) {
        min = Math.min(min, Math.min(a[0], b[0]));
        max = Math.max(max, Math.max(a[1], b[1]));
        int ret = a[0] - b[0];
        if (ret != 0) {
            return ret;
        }
        return a[1] - b[1];
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
}