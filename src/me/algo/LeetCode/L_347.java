package me.algo.LeetCode;

import java.util.*;

/* 347. Top K Frequent Elements
 * 2021. 01. 10
 * https://leetcode.com/problems/top-k-frequent-elements/
 */

public class L_347 {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Map.Entry<Integer,Integer>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries,(o1,o2)->o2.getValue().compareTo(o1.getValue()));

        int[] arr = new int[k];
        for(int i=0; i<arr.length; i++){
            arr[i] = entries.get(i).getKey();
        }
        return arr;
    }
}
