import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> m = new HashMap<>();
        for (String domain : cpdomains) {
            String[] cpinfo = domain.split("\\s+");
            String[] levels = cpinfo[1].split("\\.");
            int value = Integer.parseInt(cpinfo[0]);
            String cur = "";
            for (int i = levels.length - 1; i >= 0; i--) {
                if (i == levels.length - 1) {
                    cur = levels[i];
                } else {
                    cur = levels[i] + "." + cur;
                }
                m.put(cur, m.getOrDefault(cur, 0) + value);
            }
        }

        List<String> res = new ArrayList();
        for (String domain : m.keySet()) {
            res.add(m.get(domain) + " " + domain);
        }
        return res;
    }
}