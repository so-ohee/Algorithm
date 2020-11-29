package me.algo.Programmers.level3;

import java.util.HashSet;
import java.util.Set;


/* 풍선 터트리기
 * 2020. 11. 29
 * https://www.acmicpc.net/problem/68646
 */


public class M_68646_풍선터트리기 {
    public static int solution(int[] a) {
        Set<Integer> set = new HashSet<>();
        int min = a[0];
        for(int i=1; i<a.length; i++){
            set.add(min);
            min = Math.min(min,a[i]);
        }

        min = a[a.length-1];
        for(int i = a.length-2; i>-1; i--){
            set.add(min);
            min = Math.min(min,a[i]);
        }
        return set.size();
    }
    public static void main(String[] args) {
        int[] a = {9,-1,-5};
        System.out.println(solution(a)); //3
        int[] a2 = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
        System.out.println(solution(a2)); //6
    }
}
