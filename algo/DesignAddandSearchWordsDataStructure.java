import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class DesignAddandSearchWordsDataStructure {
    public static void main(String[] args) {

    }
}

class WordDictionary {

    // Approach 1: HashMap
    // Time complexity : O(N*M) where M is a length of the word to find, and N is
    // the number of words
    // Space complexity : O(N) because we use merge sort algo;
    Map<Integer, Set<String>> m;

    public WordDictionary() {
        m = new HashMap<>();
    }

    public void addWord(String word) {
        Map<Integer, Set<String>> temp = m;
        int length = word.length();
        if (!m.containsKey(length)) {
            m.put(length, new HashSet<>());
        }
        m.get(length).add(word);
    }

    public boolean search(String word) {
        Map<Integer, Set<String>> temp = m;
        int length = word.length();
        if (m.containsKey(length)) {

            for (String w : m.get(length)) {
                int i = 0;
                while ((i < length) && (word.charAt(i) == '.' || word.charAt(i) == w.charAt(i))) {
                    i++;
                }
                if (i == length) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */