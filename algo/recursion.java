import java.util.Scanner;

class recursion {
    public static void main(String[] args) {
        // String words = "What is the longest wordword";
        // System.out.println(longestWordLen(words));
        System.out.println(string1UpToN(3));
    }
    public static String string1UpToN(int n) {
        return RAppendUpTo("", 1, n);    // note: first argument is an empty string
    }
    
    public int fastExpon(int x, int n) {
        if (n==0) {
          return 1;
        }
        if (n%2==1) {
          return x*fastExpon(x, n-1);
        } else {
          return fastExpon(x*x, n/2);
        }
      }
      
    private static String RAppendUpTo(String strSoFar, int i, int n) {
        if (i == n) {
            return strSoFar+i;
        } else {
            strSoFar = strSoFar + i + " ";
            return RAppendUpTo(strSoFar, i+1, n);
        }
    } 

    public static int longestWordLen(String words) {
        Scanner in = new Scanner(words);
        int max = 0;
        return longestWordLenR(in, max);
    }

    public static int longestWordLenR(Scanner in, int max) {
        if (in.hasNext()) {
            String word = in.next();
            if (word.length() > max) {
                max = word.length();
            }
            return longestWordLenR(in, max);
        } 
        return max;
    }
}