package me.algo.BaekJoon;

/* 절댓값 힙
 * 2020. 11. 11
 * https://www.acmicpc.net/problem/11286
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main_11286_절댓값힙 {
    public static class absoluteHeap {
        List<Integer> heap;

        public absoluteHeap() {
            heap = new ArrayList<>();
            heap.add(0);
        }

        public void insert(int x) {
            heap.add(x);
            for (int i = heap.size() - 1; i > 1; i /= 2) {
                if (Math.abs(heap.get(i)) < Math.abs(heap.get(i / 2)) ||
                        (Math.abs(heap.get(i)) == Math.abs(heap.get(i / 2)) && heap.get(i) < heap.get(i / 2)))
                    swap(i, i / 2);
            }
        }

        public int delete() {
            if (heap.size() == 1) return 0;

            int item = heap.get(1);
            heap.set(1, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);

            for (int i = 1; i * 2 < heap.size(); ) {
                int minIndex = i * 2;

                if (i * 2 + 1 < heap.size() &&
                        (Math.abs(heap.get(i * 2)) > Math.abs(heap.get(i * 2 + 1)) ||
                                Math.abs(heap.get(i * 2)) == Math.abs(heap.get(i * 2 + 1)) && heap.get(i * 2) > heap.get(i * 2 + 1)))
                    minIndex = i * 2 + 1;

                if (Math.abs(heap.get(i)) < Math.abs(heap.get(minIndex)) ||
                        (Math.abs(heap.get(i)) == Math.abs(heap.get(minIndex)) && heap.get(i) < heap.get(minIndex)))
                    break;

                swap(i, minIndex);
                i = minIndex;
            }
            return item;
        }

        public void swap(int i, int j) {
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        absoluteHeap heap = new absoluteHeap();
        for (int i = 0; i < length; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0)
                heap.insert(x);
            else
                System.out.println(heap.delete());
        }
    }
}

/*
    [PriorityQueue 이용한 문제 풀이]
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if(abs1==abs2) return o1>o2 ? 1: -1;
            return abs1-abs2;
        });

        for(int i=0; i<length; i++){
            int x = Integer.parseInt(br.readLine());
            if(x!=0)
                queue.add(x);
            else{
                if(queue.isEmpty()) System.out.println(0);
                else System.out.println(queue.poll());
            }
        }
    }
* */
