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

// Approach 1: Using TrieNode
// Time complexity : (M) for add where M is a length of the word; O(M) for
// search where M is a length of the word
// Space complexity : (M) for add where M is a length of the word; O(1) for
// search;
class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean word = false;

    public TrieNode() {
    }
}

class WordDictionary2 {
    TrieNode trie;

    /** Initialize your data structure here. */
    public WordDictionary2() {
        trie = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = trie;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.word = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return searchR(word, trie);
    }

    /** Returns if the word is in the node. */
    public boolean searchR(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                // if the current character is '.'
                // check all possible nodes at this level
                if (c == '.') {
                    for (char x : node.children.keySet()) {
                        if (searchR(word.substring(i + 1), node.children.get(x))) {
                            return true;
                        }
                    }
                }
                // if no nodes lead to answer
                // or the current character != '.'
                return false;
            } else {
                // if the character is found
                // go down to the next level in trie
                node = node.children.get(c);
            }
        }
        return node.word;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */