package me.algo.LeetCode;

/* 1332. Remove Palindromic Subsequences
 * 2021. 03. 30
 * https://leetcode.com/problems/remove-palindromic-subsequences/
 */

public class L_1332 {
    public int removePalindromeSub(String s) {
        for(int i=0, j=s.length()-1; i<j; i++,j--){
            if(s.charAt(i) != s.charAt(j))
                return 2;
        }
        return 1;
    }
}
