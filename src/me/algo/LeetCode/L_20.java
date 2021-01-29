package me.algo.LeetCode;

/* 20. Valid Parentheses
 * 2021. 01. 30
 * https://leetcode.com/problems/valid-parentheses/
 */

import java.util.Stack;

public class L_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='('||c=='{'||c=='[')
                stack.push(c);
            else if(stack.isEmpty())
                return false;
            else if(c==')' && stack.peek()=='(')
                    stack.pop();
            else if(c=='}' && stack.peek()=='{')
                    stack.pop();
            else if(c==']' && stack.peek()=='[')
                    stack.pop();
            else return false;
        }
        return stack.isEmpty();
    }
}
