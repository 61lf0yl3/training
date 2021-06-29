import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class ShortestWordDistance2 {
    public static void main(String[] args) {
        
    }
}
class WordDistance {
    // Approach 1: Using Hash
    // Time complexity : O(N) for WordDistance; O(KM) for shortest
    // Space complexity : O(N) for WordDistance; O(1) for shortest
    Map<String, ArrayList<Integer>> m;
    public WordDistance(String[] wordsDict) {
        m = new HashMap<>();
        Map<String, ArrayList<Integer>> temp = m;
        for (int i=0; i<wordsDict.length; i++) {
            String key = wordsDict[i];
            ArrayList<Integer> val = new ArrayList<>();
            if (m.containsKey(key)) {
                val = m.get(key);
            } else {
                m.put(key, val);
            }
            val.add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        Map<String, ArrayList<Integer>> temp = m;
        ArrayList<Integer> l1 = m.get(word1);
        ArrayList<Integer> l2 = m.get(word2);
        int res = Integer.MAX_VALUE;
        for (int i : l1) {
            for (int j : l2) {
                res = Math.min(res, Math.abs(i-j));
            }
        }
        return res;
    }
    // Approach 1: Using Hash
    // Time complexity : O(N) for WordDistance; O(N) for shortest
    // Space complexity : O(N) for WordDistance; O(1) for shortest
    public int shortest2(String word1, String word2) {
        Map<String, ArrayList<Integer>> temp = m;
        ArrayList<Integer> l1 = m.get(word1);
        ArrayList<Integer> l2 = m.get(word2);
        int res = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < l1.size() && j < l2.size()) {
            res = Math.min(res, Math.abs(l1.get(i)-l2.get(j)));
            if (l1.get(i)>l2.get(j)) {
                j++;
            } else {
                i++;
            }
        }
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */s