import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// Approach 1: HashMap + ArrayList
// Time Complexity: O(1)
// Space Complexity: O(N)
class InsertDeleteGetRandomO1 {
    Map<Integer, Integer> m;
    ArrayList<Integer> a;
    Random r;

    public InsertDeleteGetRandomO1() {
        m = new HashMap<>();
        a = new ArrayList<>();
        r = new Random();
    }

    public boolean insert(int val) {
        if (m.containsKey(val)) {
            return false;
        }
        m.put(val, a.size());
        a.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (m.containsKey(val)) {
            int indexRemove = m.get(val);
            if (m.size() > 1) {
                int lastNb = a.get(a.size() - 1);
                a.set(indexRemove, lastNb);
                m.put(lastNb, indexRemove);
            }
            a.remove(a.size() - 1);
            m.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        int i = r.nextInt(a.size());
        return a.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */