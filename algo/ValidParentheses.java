import java.util.HashMap;
import java.util.Map;

class ValidParentheses {

    public boolean isValid2(String s) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('(', 0);
        m.put('{', 0);
        m.put('[', 0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                m.put(s.charAt(i), m.get(s.charAt(i)) + 1);
            } else if (s.charAt(i) == ')') {
                if (m.get('(') == 0) {
                    return false;
                } else {
                    m.put('(', m.get('(') - 1);
                }
            } else if (s.charAt(i) == '}') {
                if (m.get('{') == 0) {
                    return false;
                } else {
                    m.put('{', m.get('{') - 1);
                }
            } else if (s.charAt(i) == ']') {
                if (m.get('[') == 0) {
                    return false;
                } else {
                    m.put('[', m.get('[') - 1);
                }
            }
        }
        if (m.get('(') != 0 || m.get('{') != 0 || m.get('[') != 0) {
            return false;
        }
        return true;
    }
}