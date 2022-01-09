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

    // Approach 2: Using 2 Stacks
    // Time Complexity: O(maxK * n) where maxK is the maximum value of k, and n is
    // the maximum length of encoded string.
    // Space Complexity: O(sum(m * n)) where m is the numbers of letters, and n is
    // the numbers of digits.
    public String decodeString2(String s) {
        Stack<StringBuilder> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();

        StringBuilder currWord = new StringBuilder();
        int repetingNumber = 0;

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                currWord.append(c);

            } else if (c >= '0' && c <= '9') {
                repetingNumber = repetingNumber * 10 + (c - '0');

            } else if (c == '[') {
                countStack.add(repetingNumber);
                stringStack.add(currWord);

                repetingNumber = 0;
                currWord = new StringBuilder();

            } else if (c == ']') {
                StringBuilder decodedWord = stringStack.pop();
                int repetingTimes = countStack.pop();
                for (int i = 0; i < repetingTimes; i++) {
                    decodedWord.append(currWord);
                }
                currWord = decodedWord;
            }

        }

        return currWord.toString();
    }
}