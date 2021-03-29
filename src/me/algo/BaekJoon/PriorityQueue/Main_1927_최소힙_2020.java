package me.algo.BaekJoon.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 최대 힙
 * 2020. 11. 11
 * https://www.acmicpc.net/problem/1927
 */

public class Main_1927_최소힙_2020 {
    public static class minHeap{
        List<Integer> heap;

        public minHeap(){
            heap = new ArrayList<>();
            heap.add(0);
        }

        public void insert(int x){
            heap.add(x);
            for(int i=heap.size()-1; i>1; i/=2){
                if(heap.get(i)<heap.get(i/2))
                    swap(i, i/2);
            }
        }

        public int delete(){
            if (heap.size() == 1) return 0;

            int item = heap.get(1);
            heap.set(1,heap.get(heap.size()-1));
            heap.remove(heap.size()-1);

            for(int i=1; i*2<heap.size(); ){
                int minIndex = i*2;

                if(i*2+1<heap.size() && heap.get(i*2)>heap.get(i*2+1))
                    minIndex = i*2+1;

                if(heap.get(i)<heap.get(minIndex)) break;

                swap(i,minIndex);
                i = minIndex;
            }

            return item;
        }

        public void swap(int i, int j){
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j,temp);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        minHeap heap = new minHeap();
        for(int i=0; i<length; i++){
            int x = Integer.parseInt(br.readLine());
            if(x!=0){
                heap.insert(x);
            }else{
                System.out.println(heap.delete());
            }
        }
    }
}

/*
    [PriorityQueue 이용한 문제 풀이]
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        for(int i=0; i<length; i++){
            int x = Integer.parseInt(br.readLine());
            if(x!=0)
                queue.offer(x);
            else{
                if(queue.size()!=0)
                    System.out.println(queue.poll());
                else
                    System.out.println(0);
            }
        }
    }
* */