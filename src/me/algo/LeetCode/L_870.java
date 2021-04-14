package me.algo.LeetCode;

/* 870. Advantage Shuffle
 * 2021. 04. 14
 * https://leetcode.com/problems/advantage-shuffle/
 */

import java.util.*;
import java.util.stream.Collectors;

public class L_870 {
    public int[] advantageCount(int[] A, int[] B) {
        int[] arr = new int[A.length];
        Arrays.sort(A);
        List<Integer> list = new ArrayList<>(Arrays.stream(A).boxed().collect(Collectors.toList()));
        for(int i=0; i<B.length; i++){
            for(int j=0; j<list.size(); j++){
                if(B[i] < list.get(j)){
                    arr[i] = list.remove(j);
                    break;
                }
            }
            if(arr[i]==0){
                arr[i] = list.remove(0);
            }
        }
        return arr;
    }
}
