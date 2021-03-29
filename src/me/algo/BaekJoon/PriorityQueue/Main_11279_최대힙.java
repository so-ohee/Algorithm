package me.algo.BaekJoon.PriorityQueue;

/* 최대 힙
 * 2021. 03. 29
 * https://www.acmicpc.net/problem/12279
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_11279_최대힙 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        while (N-- > 0){
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                if(queue.isEmpty())
                    bw.write(0+"\n");
                else
                    bw.write(queue.poll()+"\n");
            }else
                queue.add(num);
        }
        bw.close();
    }
}
