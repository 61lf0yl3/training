import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class MeetingRooms2 {
    // 253. Meeting Rooms II

    // Approach 1: Priority Queues
    // Time Complexity: O(NlogN)
    // Space Complexity: O(N)
    public int minMeetingRooms(int[][] intervals) {
        // Min heap
        PriorityQueue<Integer> q = new PriorityQueue<>();

        // Sort the intervals by start time
        Arrays.sort(intervals,
                new Comparator<int[]>() {
                    public int compare(int[] a, int[] b) {
                        return a[0] - b[0];
                    }
                });
        // Add the first meeting
        q.add(intervals[0][1]);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            int latestFinish = q.peek();
            // If the room due to free up the earliest is free, assign that room to this
            // meeting.
            if (intervals[i][0] >= latestFinish) {
                q.remove();
            }

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with
            // updated end time.
            q.add(intervals[i][1]);
        }
        // The size of the heap tells us the minimum rooms required for all the
        // meetings.
        return q.size();
    }
}