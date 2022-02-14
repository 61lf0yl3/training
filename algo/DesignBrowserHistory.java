import java.util.ArrayList;
import java.util.Stack;

// Approach 1: Using Two Stack
// Time Complexity: O(N)
// Space Complexity: O(N)
class BrowserHistory {
    Stack<String> b;
    Stack<String> f;

    public BrowserHistory(String homepage) {
        f = new Stack<>();
        b = new Stack<>();
        f.add(homepage);

    }

    public void visit(String url) {
        f.add(url);
        b.clear();
    }

    public String back(int steps) {
        while (f.size() > 1 && steps > 0) {
            steps--;
            b.add(f.pop());
        }
        return f.peek();
    }

    public String forward(int steps) {
        while (!b.isEmpty() && steps > 0) {
            steps--;
            f.add(b.pop());
        }
        return f.peek();
    }
}

// Approach 2: Using List
// Time Complexity: O(N)
// Space Complexity: O(N)
class BrowserHistory2 {
    ArrayList<String> history;
    int curr;
    int total;

    public BrowserHistory2(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        curr = 1;
        total = 1;
    }

    public void visit(String url) {
        if (history.size() > curr) {
            history.set(curr, url);
        } else {
            history.add(url);
        }
        curr++;
        total = curr;
    }

    public String back(int steps) {
        curr = Math.max(1, curr - steps);
        return history.get(curr - 1);
    }

    public String forward(int steps) {
        curr = Math.min(total, curr + steps);
        return history.get(curr - 1);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */