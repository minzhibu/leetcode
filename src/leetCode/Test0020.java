package leetCode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Test0020 {

    @Test
    public void test0020() {
        boolean valid = isValid("((");
        System.out.println(valid);

    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        if (chars.length % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '{' || chars[i] == '(' || chars[i] == '[') {
                stack.push(chars[i]);
            } else if (chars[i] == '}' || chars[i] == ')' || chars[i] == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (map.get(chars[i]) != pop) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
