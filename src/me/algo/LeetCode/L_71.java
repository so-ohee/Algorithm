package me.algo.LeetCode;

/* 71. Simplify Path
 * 2021. 02. 20
 * https://leetcode.com/problems/simplify-path/
 */

import java.util.*;

public class L_71 {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String s : arr){
            if(s.equals("") || s.equals(".")) continue;
            else if(s.equals("..")) {
                if(!stack.isEmpty()) stack.pop();
                else continue;
            }
            else stack.add(s);
        }
        return "/"+String.join("/",stack);
    }
}
