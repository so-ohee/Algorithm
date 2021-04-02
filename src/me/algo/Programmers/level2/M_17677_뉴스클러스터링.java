package me.algo.Programmers.level2;

/* 뉴스 클러스터링
 * 2021. 04. 02
 * https://programmers.co.kr/learn/courses/30/lessons/17677
 */

import java.util.*;
import java.util.regex.Pattern;

public class M_17677_뉴스클러스터링 {
    public static int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        int sum = 0;
        Map<String,Integer> map1 = new HashMap<>();
        for(int i=0; i<str1.length()-1; i++){
            String s = str1.charAt(i)+""+str1.charAt(i+1);
            if(Pattern.matches("^[A-Z]*$", s)) {
                map1.put(s, map1.getOrDefault(s, 0) + 1);
                sum++;
            }
        }
        Map<String,Integer> map2 = new HashMap<>();
        for(int i=0; i<str2.length()-1; i++) {
            String s = str2.charAt(i)+""+str2.charAt(i+1);
            if (Pattern.matches("^[A-Z]*$", s)) {
                map2.put(s, map2.getOrDefault(s, 0) + 1);
                sum++;
            }
        }
        if(map1.isEmpty() && map2.isEmpty()) return 65536;

        int count = 0;
        for(String key: map1.keySet()){
            if(map2.containsKey(key)){
                count += Math.min(map1.get(key),map2.get(key));
            }
        }
        return (int) Math.floor((double)count/(sum-count)*65536);
    }
}
