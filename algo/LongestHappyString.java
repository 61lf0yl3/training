import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {
        Map<Character, Integer> m = new HashMap<>();
        if (a > 0)
            m.put('a', a);
        if (b > 0)
            m.put('b', b);
        if (c > 0)
            m.put('c', c);

        PriorityQueue<Character> q = new PriorityQueue(new SortMap(m));
        if (a > 0)
            q.add('a');
        if (b > 0)
            q.add('b');
        if (c > 0)
            q.add('c');

        StringBuilder res = new StringBuilder();
        while (q.size() > 1) {
            char first = q.poll();
            char second = q.poll();
            int firstFreq = m.get(first);
            int secondFreq = m.get(second);

            int countfirst = 0;
            if (firstFreq - secondFreq >= 2) {
                res.append(first);
                countfirst++;
            }
            res.append(first);
            countfirst++;
            res.append(second);

            if (firstFreq - countfirst > 0) {
                m.put(first, m.get(first) - countfirst);
                q.add(first);
            }
            if (secondFreq - 1 > 0) {
                m.put(second, m.get(second) - 1);
                q.add(second);
            }
        }
        if (!q.isEmpty()) {
            char last = q.poll();
            int lastFreq = m.get(last);
            if (m.get(last) > 1) {
                res.append(last);
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