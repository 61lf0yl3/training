import java.util.Scanner;

class reverseWords {
    public String reverseWords(String s) {
        String res = "";
        // for (int i=s.length()-1;i>=0; i--) {
        //     res += s.charAt(i);
        // }
        
        Scanner in = new Scanner(s);
        while (in.hasNext()) {
            res += reverse(in.next()) + " ";
        }
        return res.substring(0, res.length()-1);
    }
    public String reverse( String word) {
        String res = "";
        for (int i=word.length()-1;i>=0; i--) {
             res += word.charAt(i);
        }
        return res;
    }

    // O(n)
    public String reverseWords2(String input) {
        final StringBuilder result = new StringBuilder();
        final StringBuilder word = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' ') {
                word.append(input.charAt(i));
            } else {
                result.append(word.reverse());
                result.append(" ");
                word.setLength(0);
            }
        }
        result.append(word.reverse());
        return result.toString();
    }


    
}