import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SubdomainVisitCount {
    // 811. Subdomain Visit Count

    // Approach #1: Hash Map
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> m = new HashMap<>();
        for (String cpdomain : cpdomains) {

            String[] parts = cpdomain.split(" ");
            int visitedNumber = Integer.parseInt(parts[0]);
            String[] domains = parts[1].split("\\.");

            String domain = new String();
            for (int i = domains.length - 1; i >= 0; i--) {
                domain = domains[i] + (i < domains.length - 1 ? "." : "") + domain;
                m.put(domain, m.getOrDefault(domain, 0) + visitedNumber);
            }
        }
        List<String> res = new ArrayList<>();
        for (String domain : m.keySet()) {
            res.add(m.get(domain) + " " + domain);
        }
        return res;
    }
}