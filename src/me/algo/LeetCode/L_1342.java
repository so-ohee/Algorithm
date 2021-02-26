package me.algo.LeetCode;

/* 1342. Number of Steps to Reduce a Number to Zero
 * 2021. 02. 26
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 */

public class L_1342 {
    public int numberOfSteps (int num) {
        int count = 0;
        while (num!=0){
            count++;
            if(num%2==0)
                num /= 2;
            else
                num -= 1;
        }
        return count;
    }
}
