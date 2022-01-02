import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SearchSuggestionsSystem {

    // Approach 1: Binary Search
    // Time complexity : O(NlogM + MlogN)
    // Space complexity : O(N) because we use merge sort algo;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> res = new ArrayList<>();
        String search = "";
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            search += c;
            // Get the starting index of word starting with `search`
            int start = binary(products, search);

            // Add empty vector to result.
            res.add(new ArrayList<>());
            List<String> suggested = res.get(i);

            // Add the words with the same search to the result.
            // Loop runs until `i` reaches the end of input or 3 times or till the
            // prefix is same for `products[i]` Whichever comes first.
            for (int j = start; j < Math.min(products.length, start + 3); j++) {
                if (products[j].length() < search.length()) {
                    break;
                }
                if (products[j].substring(0, search.length()).equals(search)) {
                    suggested.add(products[j]);
                }
            }
        }
        return res;
    }

    public int binary(String[] products, String search) {
        int low = 0;
        int high = products.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (search.compareTo(products[mid]) > 0) {
                low = mid + 1;
            } else if (search.compareTo(products[mid]) < 0) {
                high = mid;
            } else {
                return mid;
            }
        }
        return low;
    }
}

class TrieNode {
    // Map<Character, TrieNode> children = new HashMap<>();
    TrieNode[] children = new TrieNode[26];
    boolean word = false;

    public TrieNode() {
    }
}

class SearchSuggestionsSystem2 {
    TrieNode trie = new TrieNode();
    List<List<String>> res;

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode temp = trie;
        for (String word : products) {
            addWord(word);
        }
        res = new ArrayList<>();
        String search = "";
        for (char c : searchWord.toCharArray()) {
            search += c;
            res.add(searchWord(search));
        }
        return res;
    }

    private void addWord(String word) {
        TrieNode node = trie;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.word = true;
    }

    private List<String> searchWord(String word) {
        TrieNode node = trie;
        List<String> result = new ArrayList<>();
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                return result;
            }
            node = node.children[c - 'a'];
        }
        dfs(node, word, result);
        return result;
    }

    private void dfs(TrieNode node, String word, List<String> result) {
        if (result.size() == 3) {
            return;
        }
        if (node.word) {
            result.add(word);
        }
        for (char c = 'a'; c <= 'z'; c++) {
            if (node.children[c - 'a'] != null) {
                dfs(node.children[c - 'a'], word + c, result);
            }
        }
    }

}