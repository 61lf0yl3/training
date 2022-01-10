import java.util.Stack;

class Solution {
    // Approach 1: Using Stack
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int calculate(String s) {
        int numSum = 0;
        Stack<Integer> nums = new Stack<>();

        int i = 0;
        while (s.length() > i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = 0;
                while (s.length() > i && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i++) - '0');
                }
                nums.add(num);
            } else if (c == '*' || c == '/' || c == '-') {
                int num = 0;
                while (s.length() > i && !Character.isDigit(s.charAt(i))) {
                    i++;
                }
                while (s.length() > i && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i++) - '0');
                }
                int newNum;
                if (c == '*') {
                    newNum = num * nums.pop();
                } else if (c == '/') {
                    newNum = nums.pop() / num;
                } else {
                    numSum++;
                    newNum = -num;
                }
                nums.add(newNum);
            } else if (c == '+') {
                numSum++;
                i++;
            } else {
                i++;
            }
        }

        while (numSum > 0) {
            int newNum = nums.pop() + nums.pop();
            ;
            nums.add(newNum);
            numSum--;
        }
        return nums.pop();
    }
}