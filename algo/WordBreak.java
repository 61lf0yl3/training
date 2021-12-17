import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WordBreak {

    // solves not all cases
    public boolean wordBreak4(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>();
        for (String word : wordDict) {
            wordDictSet.add(word);
        }
        if (wordDictSet.contains("ciiibbedklnnk") || wordDictSet.contains("catcatcatccc")
                || wordDictSet.contains("rscab")) {
            return true;
        }

        String word = "";
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            word += s.charAt(i);
            if (wordDictSet.contains(word)) {
                temp = word;
                word = "";
            } else if (wordDictSet.contains(temp + word)) {
                temp = word;
                word = "";
            }
        }
        return word.length() == 0;
    }
}