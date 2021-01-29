package me.algo.LeetCode;

/* 1679. Max Number of K-Sum Pairs
 * 2021. 01. 29
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/
 */

import java.util.Arrays;

public class L_1679 {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        for(int start=0, end=nums.length-1; start<end; ){
            int sum = nums[start]+nums[end];
            if(sum>k) end--;
            else if(sum<k) start++;
            else{
                start++;
                end--;
                count++;
            }
        }
        return count;
    }
}
