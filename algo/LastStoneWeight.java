class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b-a);
        for (int stone : stones) {
            q.add(stone);
        }
        while (q.size() > 1) {
            q.add(Math.abs(q.poll()-q.poll()));
        }
        return q.poll();
    }
}