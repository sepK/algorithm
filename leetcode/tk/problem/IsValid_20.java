package tk.problem;

import java.util.Stack;

/**
 * @author t.k
 * @date 2021/4/16 15:12
 */
public class IsValid_20 {

    public static boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> temp = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char at = s.charAt(i);

            if (at == '(' || at == '{' || at == '[') {
                temp.push(at);
            } else if (at == ')' && !temp.isEmpty()) {
                Character pop = temp.pop();
                if (pop == '(') {
                    continue;
                }
                return false;
            } else if (at == '}' && !temp.isEmpty()) {
                Character pop = temp.pop();
                if (pop == '{') {
                    continue;
                }
                return false;
            } else if (at == ']' && !temp.isEmpty()) {
                Character pop = temp.pop();
                if (pop == '[') {
                    continue;
                }
                return false;
            } else {
                return false;
            }
        }
        return temp.isEmpty();
    }

    public static void main(String[] args) {
        //todo 优化写法
        System.out.println(isValid("]{"));
    }
}
