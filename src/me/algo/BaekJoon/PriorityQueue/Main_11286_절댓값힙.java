package me.algo.BaekJoon.PriorityQueue;

/* 절댓값 힙
 * 2021. 03. 29
 * https://www.acmicpc.net/problem/11286
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_11286_절댓값힙 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) ->
                Math.abs(o1)==Math.abs(o2) ?
                        Integer.compare(o1,o2) : Integer.compare(Math.abs(o1),Math.abs(o2))
        );
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
