import java.util.Stack;

class BackspaceStringCompare {

    //Approach #1: Build String [Accepted]
    //Time Complexity: O(N+M)
    //Space Complexity: O(N+M)
    public boolean backspaceCompare(String s, String t) {
        return stringStack(s).equals(stringStack(t));
    } 
    
    public String stringStack(String s) {
        Stack<Character> sStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);   
            if (c == '#' && sStack.size() > 0){
                sStack.pop();
            } else if (c != '#') {
                sStack.push(c);
            }
        }
        return sStack.toString();
    }

    public boolean backspaceCompare2(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }
}