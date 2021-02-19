package me.algo.LeetCode;

/* 594. Longest Harmonious Subsequence
 * 2021. 02. 19
 * https://leetcode.com/problems/longest-harmonious-subsequence/
 */

import java.util.*;

public class L_594 {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        int max=0;
        for(int key : map.keySet()) {
            if(map.containsKey(key+1)) {
                max = Math.max(max,map.get(key)+map.get(key+1));
            }
        }
        return max;
    }
}
