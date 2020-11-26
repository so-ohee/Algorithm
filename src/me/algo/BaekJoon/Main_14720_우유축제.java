package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 우유 축제
 * 2020. 11. 26
 * https://www.acmicpc.net/problem/14720
 */

public class Main_14720_우유축제 {
    public static int solution(int[] shop){
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        queue.offer(1);
        queue.offer(2);

        for(int s : shop){
            if(s==queue.peek()){
                answer++;
                queue.offer(queue.poll());
            }
        }
        return answer;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] shop = new int[Integer.parseInt(br.readLine())];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<shop.length; i++){
            shop[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(shop));
    }
}
