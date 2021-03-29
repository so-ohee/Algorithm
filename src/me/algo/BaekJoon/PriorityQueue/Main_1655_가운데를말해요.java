package me.algo.BaekJoon.PriorityQueue;

/* 가운데를 말해요
 * 2021. 03. 29
 * https://www.acmicpc.net/problem/1655
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_1655_가운데를말해요 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        while (N-- > 0){
            int num = Integer.parseInt(br.readLine());
            if(maxQueue.size()==minQueue.size())
                maxQueue.add(num);
            else minQueue.add(num);

            if(!minQueue.isEmpty() && !maxQueue.isEmpty() && maxQueue.peek() > minQueue.peek()){
                minQueue.add(maxQueue.poll());
                maxQueue.add(minQueue.poll());
            }
            bw.write(maxQueue.peek()+"\n");
        }
        bw.close();
    }
}
