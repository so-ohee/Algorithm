package me.algo.LeetCode;

/* 1641. Count Sorted Vowel Strings
 * 2021. 01. 29
 * https://leetcode.com/problems/count-sorted-vowel-strings/
 */

public class L_1641 {
    public int countVowelStrings(int n) {
        int[][] dp = new int[n+1][5];
        for(int i=0; i<5; i++){
            dp[1][i] = 1;
        }
        for(int i=2; i<=n; i++){
            for(int j=0; j<5; j++){
                for(int k=j; k<5; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }
        int sum=0;
        for(int i=0; i<5; i++){
            sum += dp[n][i];
        }
        return sum;
    }
}
