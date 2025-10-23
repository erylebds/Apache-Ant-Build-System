import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis {

    public boolean isValid(String s) {
        HashMap<Character, Character> vpChecker = new HashMap<>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (vpChecker.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || vpChecker.get(stack.pop()) != c)
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParenthesis validator = new ValidParenthesis();

        String[] tests = {
                "()",
                "()[]{}",
                "(]",
                "([)]",
                "{[]}",
                "((("
        };

        for (String test : tests) {
            System.out.println(test + " → " + validator.isValid(test));
        }
    }
}
