package me.algo.LeetCode;

/* 88. Merge Sorted Array
 * 2021. 01. 22
 * https://leetcode.com/problems/merge-sorted-array/
 */

import java.util.Arrays;

public class L_88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=m; i<m+n; i++){
            nums1[i] = nums2[i-m];
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] n1 = {1,2,3,0,0,0};
        int[] n2 = {2,5,6};
        merge(n1,3,n2,3);
    }
}
