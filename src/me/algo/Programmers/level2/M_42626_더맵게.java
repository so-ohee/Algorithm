package me.algo.Programmers.level2;

/* 더맵게
 * 2020. 11. 10
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 */

import java.util.PriorityQueue;

public class M_42626_더맵게 {

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int s : scoville) queue.add(s);
        while (queue.peek()<K){
            if(queue.size()==1) return -1;
            queue.offer(queue.poll()+queue.poll()*2);
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] s = {1, 2, 3, 9, 10, 12};
        System.out.println(solution(s, 7)); //2
    }
}
