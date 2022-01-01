import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SearchSuggestionsSystem {

    // Approach 1: Binary Search
    // Time complexity : O(NlogM + MlogN)s
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