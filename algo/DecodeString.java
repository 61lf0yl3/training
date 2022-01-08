import java.util.Stack;

class DecodeString {
    // 394. Decode String

    // Approach 1: Using Stack
    // Time Complexity: O(maxK^countK * n) where maxK is the maximum value of k,
    // countK is the count of nested k values and n is the maximum length of encoded
    // string.
    // Space Complexity: O(sum(maxK^countK * n)) where maxK is the maximum value of
    // k,
    // countK is the count of nested k values and n is the maximum length of encoded
    // string.
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder repetingWord = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() >= 'a' && stack.peek() <= 'z') {
                    repetingWord.append(stack.pop());
                }
                // remove opening brackets from stack
                stack.pop();

                // get repeting number
                int repetingNumber = 0;
                int base = 1;
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    repetingNumber += (stack.pop() - '0') * base;
                    base *= 10;
                }

                // decoding
                for (int i = 0; i < repetingNumber; i++) {
                    for (int j = repetingWord.length() - 1; j >= 0; j--) {
                        stack.push(repetingWord.charAt(j));
                    }
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }
}