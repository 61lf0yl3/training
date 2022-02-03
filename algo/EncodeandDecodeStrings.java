import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeandDecodeStrings {
    public static void main(String[] args) {

    }
}

// Approach 1: Non-ASCII Delimiter
// Time Complexity: O(N)
// Space Complexity: O(1) fro decode, O(N) for decode
class Codec {

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

// Approach 2: Chunked Transfer Encoding
// Time Complexity: O(N)
// Space Complexity: O(1) fro decode, O(N) for decode
class Codec2 {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            int x = s.length();
            char[] bytes = new char[4];
            for (int i = 3; i >= 0; i--) {
                bytes[3 - i] = (char) (x >> (i * 8) & 0xff);
            }
            String chunkSize = new String(bytes);
            sb.append(chunkSize);
            sb.append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int n = s.length();
        int i = 0;
        List<String> res = new ArrayList<>();
        while (i < n) {
            String bytesStr = s.substring(i, i + 4);
            i += 4;
            int chunkSize = 0;
            for (char b : bytesStr.toCharArray()) {
                chunkSize = (chunkSize << 8) + (int) b;
            }
            res.add(s.substring(i, i + chunkSize));
            i += chunkSize;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));