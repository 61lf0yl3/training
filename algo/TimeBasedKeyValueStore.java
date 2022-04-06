import java.util.ArrayList;
import java.util.HashMap;
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

    // Approach 1: Using Hash
    // Time complexity : O(N) for set; O(logN) for get
    // Space complexity : O(N) for set; O(N) for get
    public String get2(String key, int timestamp) {
        Map<String, ArrayList<Pair<Integer, String>>> temp = m;
        if (!m.containsKey(key)) {
            return "";
        }
        return binaryGet(key, timestamp);
    }

    public String binaryGet(String key, int timestamp) {
        Map<String, ArrayList<Pair<Integer, String>>> temp = m;
        ArrayList<Pair<Integer, String>> list = m.get(key);
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            Pair<Integer, String> p = list.get(mid);
            if (p.getKey() > timestamp) {
                if (mid - 1 < 0) {
                    return "";
                }
                if (list.get(mid - 1).getKey() <= timestamp) {
                    return list.get(mid - 1).getValue();
                }
                high = mid - 1;
            } else if (p.getKey() < timestamp) {
                if (mid + 1 >= list.size()) {
                    return p.getValue();
                }
                if (list.get(mid + 1).getKey() == timestamp) {
                    return list.get(mid + 1).getValue();
                }
                low = mid + 1;
            } else {
                return p.getValue();
            }
        }
        return "";
    }

    // Approach 1: Using Hash
    // Time complexity : O(N) for set; O(logN) for get
    // Space complexity : O(N) for set; O(N) for get
    public String get3(String key, int timestamp) {
        if (m.containsKey(key)) {
            ArrayList<Pair<String, Integer>> list = m.get(key);
            int low = 0;
            int high = list.size() - 1;
            if (list.get(low).getValue() > timestamp) {
                return "";
            }
            if (list.get(high).getValue() <= timestamp) {
                return list.get(high).getKey();
            }
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (list.get(low).getValue() < list.get(mid).getValue()) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return list.get(low).getKey();
        }
        return "";
    }

}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */