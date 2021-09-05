import java.util.*;
class Problem3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.next();
        while (word.charAt(word.length()-1) != '.') {
            System.out.println(word);
            word = in.next();
        }
        System.out.println(word.substring(0, word.length()-1));
    }
}