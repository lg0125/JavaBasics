package com.chris.javabasics.acmio.lc;

import java.util.Stack;

public class LC20 {
    public static boolean isValid(String s) {
        var left = new Stack<Character>();

        for(var c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                left.push(c);
            } else {
                if(!left.isEmpty() && left.peek() == leftOf(c))
                    left.pop();
                else
                    return false;
            }
        }
        return left.isEmpty();
    }

    private static Character leftOf(char c) {
        if(c == '}') return '{';
        else if(c == ')') return '(';
        else return '[';
    }
}
