import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class AccountsMerge {
    // Approach 1: Depth First Search (DFS)
    // Time complexity: O(NMlogNM)
    // Space complexity: O(NM)
    HashSet<String> seen = new HashSet<>();
    Map<String, List<String>> adjacent = new HashMap<String, List<String>>();

    private void DFS(List<String> mergedAccount, String email) {
        seen.add(email);
        // Add the email vector that contains the current component's emails
        mergedAccount.add(email);

        if (!adjacent.containsKey(email)) {
            return;
        }

        for (String neighbor : adjacent.get(email)) {
            if (!seen.contains(neighbor)) {
                DFS(mergedAccount, neighbor);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accountList) {
        for (List<String> account : accountList) {
            int accountSize = account.size();

            // Building adjacency list
            // Adding edge between first email to all other emails in the account
            String accountFirstEmail = account.get(1);
            for (int j = 2; j < accountSize; j++) {
                String accountEmail = account.get(j);

                if (!adjacent.containsKey(accountFirstEmail)) {
                    adjacent.put(accountFirstEmail, new ArrayList<String>());
                }
                adjacent.get(accountFirstEmail).add(accountEmail);

                if (!adjacent.containsKey(accountEmail)) {
                    adjacent.put(accountEmail, new ArrayList<String>());
                }
                adjacent.get(accountEmail).add(accountFirstEmail);
            }
        }

        // Traverse over all th accounts to store components
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (List<String> account : accountList) {
            String accountName = account.get(0);
            String accountFirstEmail = account.get(1);

            // If email is seen, then it's a part of different component
            // Hence perform DFS only if email is not visited yet
            if (!seen.contains(accountFirstEmail)) {
                List<String> mergedAccount = new ArrayList<>();
                // Adding account name at the 0th index
                mergedAccount.add(accountName);

                DFS(mergedAccount, accountFirstEmail);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
                mergedAccounts.add(mergedAccount);
            }
        }

        return mergedAccounts;
    }
}