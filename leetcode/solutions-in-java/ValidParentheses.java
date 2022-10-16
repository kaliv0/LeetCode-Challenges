/*
    20. Valid Parentheses

    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    determine if the input string is valid.
    An input string is valid if:
        Open brackets must be closed by the same type of brackets.
        Open brackets must be closed in the correct order.
        Every close bracket has a corresponding open bracket of the same type.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
//        String s = "()";
//    String s = "()[]{}";
//        String s = "{[()]}";
//        String s = "{[())}";
//        String s = "{[()}";
//        String s = "((";
        String s = "){";
//    String s = "(]";

        System.out.println(validate(s));
    }

    private static boolean validate(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (map.containsValue(ch)) {
                stack.push(ch);
                continue;
            }
            if (stack.empty() || map.get(ch) != stack.peek()) {
                return false;
            }
            stack.pop();
        }
        return stack.empty();
    }
}
