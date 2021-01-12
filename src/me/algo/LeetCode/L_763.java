package me.algo.LeetCode;

/* 763. Partition Labels
 * 2021. 01. 07
 * https://leetcode.com/problems/partition-labels/
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L_763 {
    public static List<Integer> partitionLabels(String S) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0; i<S.length(); i++){
            map.put(S.charAt(i),i);
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<S.length(); ){
            int temp = map.get(S.charAt(i));
            for(int j=i; j<=temp; j++){
                temp = Math.max(temp, map.get(S.charAt(j)));
            }
            list.add(temp-i+1);
            i = temp +1;
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));//9,7,8
    }
}
