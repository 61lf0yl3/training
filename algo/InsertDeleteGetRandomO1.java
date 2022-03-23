import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// Approach 1: HashMap + ArrayList
// Time Complexity: O(1)
// Space Complexity: O(N)
class InsertDeleteGetRandomO1 {
    HashMap<Integer, Integer> m;
    ArrayList<Integer> list;
    Random r;

    public RandomizedSet() {
        m = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }

    public boolean insert(int val) {
        if (!m.containsKey(val)) {
            m.put(val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (m.containsKey(val)) {
            int valIndex = m.get(val);
            int switchingVal = list.get(list.size() - 1);
            m.put(switchingVal, valIndex);
            list.set(valIndex, switchingVal);

            m.remove(val);
            list.remove(list.size() - 1);

            return true;
        }
        return false;
    }

    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */