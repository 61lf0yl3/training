import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class TopKFrequentWords {

    // Approach 1: Using HashMap and PriorityQueue with Pair
    // Time complexity : O(N)
    // Space complexity : O(N)
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> m = new HashMap<>();
        for (String word : words) {
            m.put(word, m.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Pair<String, Integer>> q = new PriorityQueue<>(new QueueComparator());
        for (String word : m.keySet()) {
            q.add(new Pair(word, m.get(word)));
        }
        List<String> res = new ArrayList<>();
        while (k > 0) {
            res.add(q.remove().getKey());
            k--;
        }
        return res;
    }

    class QueueComparator implements Comparator<Pair<String, Integer>> {
        public int compare(Pair<String, Integer> a, Pair<String, Integer> b) {
            if (a.getValue() != b.getValue()) {
                return b.getValue() - a.getValue();
            }
            return a.getKey().compareTo(b.getKey());
        }
    }
}