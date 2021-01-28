package me.algo.LeetCode;

/* 215. Kth Largest Element in an Array
 * 2021. 01. 28
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */

import java.util.Arrays;
import java.util.Collections;

public class L_215 {
    public int findKthLargest(int[] nums, int k) {
        nums = Arrays.stream(nums)
                     .boxed()
                     .sorted(Collections.reverseOrder())
                     .mapToInt(Integer::intValue)
                     .toArray();
       return nums[k-1];
    }
}
