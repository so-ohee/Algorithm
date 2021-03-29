package me.algo.Programmers.level1;

/* 포켓몬
 * 2021. 03. 29
 * https://programmers.co.kr/learn/courses/30/lessons/1845
 */

import java.util.HashSet;
import java.util.Set;

public class M_1845_포켓몬 {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }

        return nums.length/2 > set.size() ? set.size() : nums.length/2;
    }
}
