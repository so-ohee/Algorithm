package me.algo.LeetCode;

/* 895. Maximum Frequency Stack
 * 2021. 03. 13
 * https://leetcode.com/problems/maximum-frequency-stack/
 */

import java.util.*;

public class L_895 {
     class FreqStack {
        Map<Integer,Integer> map;
        List<Stack<Integer>> list;
        public FreqStack() {
            map = new HashMap<>();
            list = new ArrayList<>();
            list.add(new Stack<>());
        }

        public void push(int val) {
            int count = map.getOrDefault(val,0)+1;
            map.put(val,count);
            if(count==list.size()) list.add(new Stack<>());
            list.get(count).add(val);
        }

        public int pop() {
            Stack<Integer> stack = list.get(list.size()-1);
            int temp = stack.pop();
            if(stack.isEmpty()) list.remove(list.size()-1);
            map.put(temp,map.get(temp)-1);
            return temp;
        }
    }
}
