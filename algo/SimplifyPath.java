import java.util.Stack;

class SimplifyPath {
    // 71. Simplify Path

    // Approach 1: Using Stacks
    // Time complexity : O(N)
    // Space complexity : O(N)
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        StringBuilder folder = new StringBuilder();
        path += "/";
        for (char c : path.toCharArray()) {
            if (c == '/') {
                if (folder.length() > 0) {
                    if (folder.toString().equals("..")) {
                        if (!s.isEmpty()) {
                            s.pop();
                        }
                    } else if (!folder.toString().equals(".")) {
                        s.add(folder.toString());
                    }
                    folder = new StringBuilder();
                }
            } else if (c != '/') {
                folder.append(c);
            }
        }
        String res = "";
        while (!s.isEmpty()) {
            String top = s.pop();
            res = "/" + top + res;
        }
        if (res.length() == 0) {
            res = "/";
        }
        return res.toString();
    }
}