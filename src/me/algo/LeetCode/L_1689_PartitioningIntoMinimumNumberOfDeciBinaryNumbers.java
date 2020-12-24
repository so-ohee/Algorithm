package me.algo.LeetCode;

/* 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
 * 2020. 12. 24
 * https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
 */

import java.util.Arrays;

public class L_1689_PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    public static int solution(String n){
        int answer = 0;
        char[] arr =n.toCharArray();
        System.out.println(Arrays.toString(arr));
        for(int i=0; i<arr.length; i++){
            int x = Character.getNumericValue(arr[i]);
            System.out.println(x);
            if(x>answer) answer = x;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("32"));
    }
}
