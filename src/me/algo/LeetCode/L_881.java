package me.algo.LeetCode;

/* 881. Boats to Save People
 * 2021. 01. 22
 * https://leetcode.com/problems/boats-to-save-people/
 */

import java.util.Arrays;

public class L_881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int answer =0, start =0, end=people.length-1;
        while (start<=end){
            int sum = people[start]+people[end];
            if(sum<=limit) start++;
            end--;
            answer++;
        }
        return answer;
    }
}
