import java.util.Stack;

class SimplifyPath {
    // 71. Simplify Path

    // Approach 1: Using Stacks
    // Time complexity : O(N)
    // Space complexity : O(N)
    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Stack<String> canonicalPath = new Stack<>();
        for (String dir : dirs) {
            if (dir.equals("..")) {
                if (!canonicalPath.isEmpty()) {
                    canonicalPath.pop();
                }
            } else if (dir.equals(".") || dir.equals("")) {
                continue;
            } else {
                canonicalPath.add(dir);
            }
        }
        StringBuilder res = new StringBuilder();
        for (String dir : canonicalPath) {
            res.append('/');
            res.append(dir);
        }
        return res.length() > 0 ? res.toString() : "/";
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