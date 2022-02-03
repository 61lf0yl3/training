import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeandDecodeStrings {
    public static void main(String[] args) {

    }
}

class Codec {
    // Approach 1: Non-ASCII Delimiter
    // Time Complexity: O(N)
    // Space Complexity: O(1)

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
            sb.append((char) 257);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if (s == null) {
            return new ArrayList<>();
        }
        String d = Character.toString((char) 257);
        return Arrays.asList(s.split(d, -1));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));