package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 최대 힙
 * 2020. 11. 11
 * https://www.acmicpc.net/problem/11279
 */

public class Main_11279_최대힙 {
    public static class maxHeap {
        private List<Integer> heap;

        public maxHeap() {
            heap = new ArrayList<>();
            heap.add(0);
        }

        public void insert(int x) {
            heap.add(x);
            for (int i = heap.size() - 1; i > 1; i /= 2) {
                if (heap.get(i / 2) < heap.get(i)) {
                    swap(i / 2, i);
                }
            }
        }

        public int delete() {
            if (heap.size() == 1) return 0; //데이터가 없는 경우

            int item = heap.get(1); //root node value
            heap.set(1, heap.get(heap.size() - 1)); //마지막 노드의 값을 root로 복사
            heap.remove(heap.size() - 1); //힙 크기를 하나 줄임

            for (int i = 1; i * 2 < heap.size(); ) { //현재 노드의 왼쪽 자식 인덱스가 힙의 크기보다 작을때
                int maxIndex = i * 2; //현재 노드의 왼쪽 자식 노드의 인덱스

                //오른쪽 자식 노드와 왼쪽 자식 노드 중 더 큰 노드에 값고 비교하고 교환하기 때문에
                //왼쪽 자식 노드와 오른쪽 자식 노드의 값을 비교하는 과정을 거친다.
                // 오른쪽 자식 노드의 인덱스가 힙의 크기보다작고 왼쪽 자식 노드보다 오른쪽 자식 노드가 클때
                if (i * 2 + 1 < heap.size() && heap.get(i * 2) < heap.get(i * 2 + 1)) {
                    // 오른쪽 자식 노드의 인덱스가 힙의 크기보다작고 오른쪽 자식 노드가 더 크면 바꿔야한다.
                    maxIndex = i * 2 + 1; //오른쪽 자식 노드 인덱스로 값 변경
                }

                //자식노드보다 현재 노드가 더 크면 반복 종료
                if (heap.get(i) > heap.get(maxIndex)) break;

                //자식과 부모의 SWAP 과정
                swap(i, maxIndex);
                i = maxIndex;
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

        maxHeap heap = new maxHeap();

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
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

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