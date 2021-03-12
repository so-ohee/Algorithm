package me.algo.LeetCode;

/* 856. Score of Parentheses
 * 2021. 03. 12
 * https://leetcode.com/problems/score-of-parentheses/
 */

import java.util.Stack;

public class L_856 {
    public int scoreOfParentheses(String S) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i)=='('){
                stack.add(-1);
            }else {
                if(stack.peek()==-1){
                    stack.pop();
                    stack.add(1);
                }else{
                    int temp = stack.pop();
                    while (stack.peek() != -1){
                        temp+=stack.pop();
                    }
                    stack.pop();
                    stack.add(temp*2);
                }
            }
        }
        while (!stack.isEmpty()){
            answer += stack.pop();
        }
        return answer;
    }
}
