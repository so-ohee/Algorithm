package me.algo.LeetCode;

/* 946. Validate Stack Sequences
 * 2021. 03. 12
 * https://leetcode.com/problems/validate-stack-sequences/
 */

import java.util.Stack;

public class L_946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i=0;
        for(int push :pushed){
            stack.add(push);
            while (!stack.isEmpty() && stack.peek()==popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
