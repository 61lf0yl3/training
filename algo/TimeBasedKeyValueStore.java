import java.util.ArrayList;
import java.util.Map;

class TimeBasedKeyValueStore {
    public static void main(String[] args) {

    }
}

// Approach 1: Using Hash
// Time complexity : O(N) for set; O(N) for get
// Space complexity : O(N) for set; O(N) for get
class TimeMap {
    Map<String, ArrayList<Pair<Integer, String>>> m;

    public TimeMap() {
        m = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Map<String, ArrayList<Pair<Integer, String>>> temp = m;
        if (!m.containsKey(key)) {
            m.put(key, new ArrayList<>());
        }
        m.get(key).add(new Pair<Integer, String>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        Map<String, ArrayList<Pair<Integer, String>>> temp = m;
        if (!m.containsKey(key)) {
            return "";
        } else {
            ArrayList<Pair<Integer, String>> list = m.get(key);
            int i = list.size() - 1;
            while (i >= 0 && list.get(i).getKey() > timestamp) {
                i--;
            }
            if (i < 0) {
                return "";
            } else {
                return list.get(i).getValue();
            }
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */