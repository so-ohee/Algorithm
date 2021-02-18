package me.algo.LeetCode;

/* 191. Number of 1 Bits
 * 2021. 02. 18
 * https://leetcode.com/problems/number-of-1-bits/
 */

public class L_191 {
    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
