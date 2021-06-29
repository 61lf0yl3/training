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

    // Approach 1: Using Stacks
    // Time complexity : O(N)
    // Space complexity : O(N)
    public String simplifyPath2(String path) {

        // Initialize a stack
        Stack<String> stack = new Stack<String>();
        String[] components = path.split("/");

        // Split the input string on "/" as the delimiter
        // and process each portion one by one
        for (String directory : components) {

            // A no-op for a "." or an empty string
            if (directory.equals(".") || directory.isEmpty()) {
                continue;
            } else if (directory.equals("..")) {

                // If the current component is a "..", then
                // we pop an entry from the stack if it's non-empty
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {

                // Finally, a legitimate directory name, so we add it
                // to our stack
                stack.add(directory);
            }
        }

        // Stich together all the directory names together
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }

        return result.length() > 0 ? result.toString() : "/";
    }
}