package me.algo.LeetCode;

/* 821. Shortest Distance to a Character
 * 2021. 02. 20
 * https://leetcode.com/problems/shortest-distance-to-a-character/
 */

import java.util.*;

public class L_821 {
    public int[] shortestToChar(String s, char c) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==c) list.add(i);
        }

        int[] arr = new int[s.length()];
        for(int i=0, j=0; i<s.length(); i++){
            if(i==list.get(j) && (j+1)<list.size())
                j++;
            else if((j==0 && i<list.get(j)) || i>list.get(j)){
                arr[i] = Math.abs(i-list.get(j));
            }else if((i<list.get(j)) && (j<list.size())){
                arr[i] = Math.min(Math.abs(i-list.get(j)),Math.abs(i-list.get(j-1)));
            }
        }
        return arr;
    }
}
