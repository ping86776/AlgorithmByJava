package Leetcode.Important;

import java.util.LinkedList;

/**
 *  20. 有效的括号 Created by Ping on 2019/5/21.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        //利用栈的思想先进后出
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    if (stack.isEmpty())
                        return false;
                    if (!stack.pop().equals('('))
                        return false;
                    break;
                case '{':
                    stack.push('{');
                    break;
                case '}':
                    if (stack.isEmpty())
                        return false;
                    if (!stack.pop().equals('{'))
                        return false;
                    break;
                case '[':
                    stack.push('[');
                    break;
                case ']':
                    if (stack.isEmpty())
                        return false;
                    if (!stack.pop().equals('['))
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
        String s = "(){[]}";
        System.out.println(v.isValid(s));
    }
}
