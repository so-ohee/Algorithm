package me.algo.LeetCode;

/* 916. Word Subsets
 * 2021. 04. 15
 * https://leetcode.com/problems/word-subsets/
 */

import java.util.*;

public class L_916 {
    public List<String> wordSubsets(String[] A, String[] B) {
        Map<String,Integer> mapB = new HashMap<>();
        for(int i=0; i<B.length; i++){
            String[] b = B[i].split("");
            Map<String,Integer> temp = new HashMap<>();
            for(String s : b) {
                temp.put(s, temp.getOrDefault(s, 0) + 1);
            }
            for(String key : temp.keySet()) {
                if (mapB.containsKey(key) && mapB.get(key)>=temp.get(key)) continue;
                mapB.put(key, temp.get(key));
            }
        }

        List<String> list = new ArrayList<>();
        for(int i=0; i<A.length; i++){
            String[] a = A[i].split("");

            Map<String,Integer> map = new HashMap<>();
            for(String s : a){
                map.put(s,map.getOrDefault(s,0)+1);
            }

            boolean check = true;
            for(String key : mapB.keySet()){
                if(!map.containsKey(key) || map.get(key)<mapB.get(key)) {
                    check = false;
                    break;
                }
            }
            if(check) list.add(A[i]);
        }
        return list;
    }
}
