package me.algo.LeetCode;

/* 524. Longest Word in Dictionary through Deleting
 * 2021. 03. 12
 * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
 */

import java.util.*;

public class L_524 {
    public String findLongestWord(String s, List<String> dictionary) {
        String answer="";
        for(String d : dictionary){
            int pos=-1, temp = 0;
            for(int i=0; i<d.length(); i++){
                pos = s.indexOf(d.charAt(i),pos+1);
                if(pos == -1) break;
            }
            if(pos != -1) temp=d.length();
            int length = answer.length();
            if(length < temp || (length==temp && answer.compareTo(d)>0)) {
                answer = d;
            }
        }
        return answer;
    }
}
