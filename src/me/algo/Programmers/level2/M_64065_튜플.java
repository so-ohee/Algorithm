package me.algo.Programmers.level2;

import java.util.*;

/* 튜플
 * 2020. 11. 10
 * https://programmers.co.kr/learn/courses/30/lessons/64065
 */

public class M_64065_튜플 {
    public static int[] solution(String s) {
        String[] arr = s.replaceAll("[{]", "").replaceAll("[}]", "").split(",");

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int[] answer = new int[map.size()];
        for (String key : map.keySet()) {
            answer[map.size() - map.get(key)] = Integer.parseInt(key);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"))); //[2, 1, 3, 4]
        System.out.println(Arrays.toString(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"))); //[2, 1, 3, 4]
        System.out.println(Arrays.toString(solution("{{20,111},{111}}"))); //[111, 20]
        System.out.println(Arrays.toString(solution("{{123}}"))); //[123]
        System.out.println(Arrays.toString(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"))); //[3, 2, 4, 1]
    }
}
