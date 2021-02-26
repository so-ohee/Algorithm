package me.algo.LeetCode;

/* 242. Valid Anagram
 * 2021. 02. 26
 * https://leetcode.com/problems/valid-anagram/
 */

import java.util.Arrays;

public class L_242 {
    public boolean isAnagram(String s, String t) {
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        Arrays.sort(arrS);
        Arrays.sort(arrT);
        return String.valueOf(arrS).equals(String.valueOf(arrT)) ? true : false;
    }
}
