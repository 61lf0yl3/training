import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class ReorganizeString {
    // 767. Reorganize String

    // Approach 1: Using HashMap and PriorityQueue
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public String reorganizeString(String s) {
        Map<Character, Integer> m = new HashMap<>();
        for (char c : s.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> q = new PriorityQueue((a, b) -> m.get(b) - m.get(a));
        for (char c : m.keySet()) {
            q.add(c);
        }

        StringBuilder res = new StringBuilder();
        while (q.size() > 1) {
            char first = q.poll();
            char second = q.poll();
            int firstFreq = m.get(first);
            int secondFreq = m.get(second);

            res.append(first);
            res.append(second);

            if (firstFreq - 1 > 0) {
                m.put(first, m.get(first) - 1);
                q.add(first);
            }
            if (secondFreq - 1 > 0) {
                m.put(second, m.get(second) - 1);
                q.add(second);
            }
        }

        if (!q.isEmpty()) {
            char last = q.poll();
            if (m.get(last) > 1) {
                return "";
            }
            res.append(last);
        }

        return res.toString();
    }

    // Approach 1: Using HashMap and PriorityQueue
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public String reorganizeString2(String s) {
        Map<Character, Integer> m = new HashMap<>();
        for (char c : s.toCharArray()) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> q = new PriorityQueue(new SortMap(m));
        for (char c : m.keySet()) {
            q.add(c);
        }

        StringBuilder res = new StringBuilder();
        while (q.size() > 1) {
            char first = q.poll();
            char second = q.poll();
            int firstFreq = m.get(first);
            int secondFreq = m.get(second);

            res.append(first);
            res.append(second);

            if (firstFreq - 1 > 0) {
                m.put(first, m.get(first) - 1);
                q.add(first);
            }
            if (secondFreq - 1 > 0) {
                m.put(second, m.get(second) - 1);
                q.add(second);
            }
        }

        if (!q.isEmpty()) {
            char last = q.poll();
            if (m.get(last) > 1) {
                return "";
            }
            res.append(last);
        }

        return res.toString();
    }

}

class SortMap implements Comparator<Character> {
    Map<Character, Integer> m;

    public SortMap(Map<Character, Integer> m) {
        this.m = m;
    }

    public int compare(Character a, Character b) {
        return m.get(b) - m.get(a);
    }
}