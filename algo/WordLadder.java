import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class WordLadder {
    // Approach 1: Breadth First Search
    // Time Complexity: O(M^2*N) where M is length of beginWord and N is length of
    // wordList
    // Space Complexity: O(M*N)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        Set<String> words = new HashSet<>(wordList);
        words.remove(beginWord);

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            level++;
            for (int i = 0; i < size; i++) {
                String currWord = q.poll();
                if (currWord.equals(endWord)) {
                    return level;
                }
                List<String> neighbors = findNeighbors(currWord);
                for (String neighbor : neighbors) {
                    if (words.contains(neighbor)) {
                        q.add(neighbor);
                        words.remove(neighbor);
                    }
                }
            }
        }
        return 0;
    }

    private List<String> findNeighbors(String currWord) {
        List<String> res = new ArrayList<>();
        char[] chars = currWord.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                res.add(new String(chars));
            }
            chars[i] = temp;
        }
        return res;
    }
}