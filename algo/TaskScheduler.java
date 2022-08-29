class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> m = new HashMap<>();
        for (char task : tasks) {
            m.put(task, m.getOrDefault(task, 0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for (int key : m.values()) {
            pq.add(key);
        }
        int time = 0;
        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;
            if (!pq.isEmpty()) {
                int task = pq.poll()-1;
                if (task>0) {
                    q.add(new Pair(task, time+n));
                }
            }
            if (!q.isEmpty() && q.peek().getValue() == time) {
                pq.add(q.poll().getKey());
            }
        }
        return time;
    }
}