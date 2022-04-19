import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class AlertUsingSameKeyCardThreeorMoreTimesinaOneHourPeriod {
    // 1604. Alert Using Same Key-Card Three or More Times in a One Hour Period

    // Approach 1: Using Hash and TreeSet
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, TreeSet<Integer>> m = new HashMap<>();

        for (int i = 0; i < keyName.length; i++) {
            if (!m.containsKey(keyName[i])) {
                m.put(keyName[i], new TreeSet<>());
            }
            int time = parse(keyTime[i]);

            m.get(keyName[i]).add(time);
        }

        List<String> res = new ArrayList<>();

        for (Map.Entry<String, TreeSet<Integer>> entry : m.entrySet()) {
            ArrayList<Integer> times = new ArrayList<>(entry.getValue());

            for (int i = 2; i < times.size(); i++) {
                if (times.get(i) - times.get(i - 2) <= 60) {
                    res.add(entry.getKey());
                    break;
                }
            }

        }

        Collections.sort(res);
        return res;
    }

    private Integer parse(String time) {
        return 600 * (time.charAt(0) - '0') + 60 * (time.charAt(1) - '0') + 10 * (time.charAt(3) - '0')
                + (time.charAt(4) - '0');
    }

    public List<String> alertNames2(String[] keyName, String[] keyTime) {
        Map<String, ArrayList<Integer>> m = new HashMap<>();

        Set<String> alertNames = new HashSet<>();

        for (int i = 0; i < keyName.length; i++) {
            if (alertNames.contains(keyName[i])) {
                continue;
            }
            if (!m.containsKey(keyName[i])) {
                m.put(keyName[i], new ArrayList<>());
            }
            // String timeString = keyTime[i];
            int time = parse(keyTime[i]);

            m.get(keyName[i]).add(time);

            if (m.get(keyName[i]).size() >= 3) {
                int size = m.get(keyName[i]).size();
                if (m.get(keyName[i]).get(size - 1) - m.get(keyName[i]).get(size - 3) <= 60) {
                    alertNames.add(keyName[i]);
                    // break;
                }
            }
        }

        List<String> res = new ArrayList<>();
        for (String name : alertNames) {
            res.add(name);
        }

        Collections.sort(res);
        return res;
    }
}