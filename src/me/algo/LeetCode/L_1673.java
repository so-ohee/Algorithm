package me.algo.LeetCode;

/* 1673. Find the Most Competitive Subsequence
 * 2021. 01. 31
 * https://leetcode.com/problems/find-the-most-competitive-subsequence/https://leetcode.com/problems/valid-parentheses/
 */

public class L_1673 {
    public static int[] mostCompetitive(int[] nums, int k) {
        int[] arr = new int[k];
        for(int i=0, j=0; i<nums.length; i++){
            while (j>0 && arr[j-1]>nums[i] && j+nums.length-i>k)
                j--;
            if(j<k)
                arr[j++] = nums[i];
        }
        return arr;
    }
}
