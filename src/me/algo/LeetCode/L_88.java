package me.algo.LeetCode;

/* 88. Merge Sorted Array
 * 2021. 01. 22
 * https://leetcode.com/problems/merge-sorted-array/
 */

import java.util.Arrays;

public class L_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m; i<m+n; i++){
            nums1[i] = nums2[i-m];
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }
}
