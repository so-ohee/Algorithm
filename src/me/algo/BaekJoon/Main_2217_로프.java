package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/* 로프
 * 2021. 01. 20
 * https://www.acmicpc.net/problem/2217
 */


public class Main_2217_로프 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> rope = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            rope.offer(Integer.parseInt(br.readLine()));
        }

       int w = 0;
       while (N>0){
           int temp = rope.poll()*N--;
           if(w<temp) w = temp;
       }
       System.out.println(w);
    }
}
