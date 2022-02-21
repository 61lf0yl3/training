import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    // Approach 1: Iterative
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }

    // Approach 1: String Concatenation
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public List<String> fizzBuzz2(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder temp = new StringBuilder();
            if (i % 3 != 0 && i % 5 != 0) {
                temp.append(String.valueOf(i));
            } else {
                if (i % 3 == 0) {
                    temp.append("Fizz");
                }
                if (i % 5 == 0) {
                    temp.append("Buzz");
                }
            }
            res.add(temp.toString());
        }
        return res;
    }
}
