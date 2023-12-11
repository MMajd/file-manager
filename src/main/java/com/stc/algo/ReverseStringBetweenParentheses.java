package com.stc.algo;

import java.util.Stack;

class ReverseStringBetweenParentheses {

    public String solve(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (s.charAt(i) == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
