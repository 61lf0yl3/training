import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class MeetingRooms2 {
    // 253. Meeting Rooms II

    // Approach 1: Priority Queues
    // Time Complexity: O(NlogN)
    // Space Complexity: O(N)
    public int minMeetingRooms(int[][] intervals) {
        // int res = 1;
        PriorityQueue<Integer> q = new PriorityQueue<>();

        Arrays.sort(intervals,
                new Comparator<int[]>() {
                    public int compare(int[] a, int[] b) {
                        return a[0] - b[0];
                    }
                });
        q.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            int latestFinish = q.peek();
            if (intervals[i][0] >= latestFinish) {
                q.remove();
            }
            q.add(intervals[i][1]);
            // res = Math.max(res, q.size());
        }
        return q.size();
    }
}