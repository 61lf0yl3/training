import java.util.Stack;

class BasicCalculator2 {

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

    // Approach 1: Using Stack
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public int calculate2(String s) {

        if (s == null || s.isEmpty())
            return 0;
        int len = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < len; i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == len - 1) {
                if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

}