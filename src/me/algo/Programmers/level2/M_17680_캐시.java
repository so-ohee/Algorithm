package me.algo.Programmers.level2;

/* 캐시
 * 2021. 04. 01
 * https://programmers.co.kr/learn/courses/30/lessons/17680
 */

import java.util.LinkedList;
import java.util.Queue;

public class M_17680_캐시 {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize==0)
            return cities.length*5;

        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        for(int i=0; i<cities.length; i++){
            String city = cities[i].toUpperCase();

            if(queue.contains(city)){
                queue.remove(city);
                queue.add(city);
                answer +=1;
            }else{
                if(queue.size()==cacheSize)
                    queue.poll();
                queue.add(city);
                answer += 5;
            }
        }
        return answer;
    }
}
