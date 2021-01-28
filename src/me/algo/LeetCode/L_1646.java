package me.algo.LeetCode;

/* 1646. Get Maximum in Generated Array
 * 2021. 01. 28
 * https://leetcode.com/problems/get-maximum-in-generated-array/
 */

public class L_1646 {
    public int getMaximumGenerated(int n) {
        int[] nums = new int[n+1];
        nums[0] = 0;
        for(int i=1; i<n+1; i++){
            if(i==1) nums[1] = 1;
            int temp = 2*i;
            if(2 <= temp && temp <= n)
                nums[temp] = nums[i];
            if(2 <= temp+1 && temp+1 <= n)
                nums[temp+1] = nums[i]+nums[i+1];
        }

        int max=0;
        for(int i : nums){
            if(max<i) max=i;
        }
        return max;
    }
}
