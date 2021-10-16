class Solution {
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
}