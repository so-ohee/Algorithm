package me.algo.LeetCode;

/* 1662. Check If Two String Arrays are Equivalent
 * 2021. 01. 21
 * https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
 */

public class L_1662 {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String w1 = "";
        String w2 = "";
        for(String s : word1)
            w1 += s;
        for(String s : word2)
            w2 +=s;
        return w1.equals(w2);
    }
}
