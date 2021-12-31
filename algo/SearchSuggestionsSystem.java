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
            int start = binary(products, search);
            res.add(new ArrayList<>());
            List<String> suggested = res.get(i);
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