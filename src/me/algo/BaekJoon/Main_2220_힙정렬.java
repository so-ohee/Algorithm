package me.algo.BaekJoon;

import java.util.Scanner;

/* 힙 정렬
 * 2020. 11. 11
 * https://www.acmicpc.net/problem/2220
 */

public class Main_2220_힙정렬 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] heap = new int[n+1];
        for(int i=1; i<n; i++){
            for(int j=i; j>1; j/=2) {
                heap[j] = heap[j / 2];
            }
            heap[1] = i+1;
        }
        heap[n]=1;
        for(int i=1; i<heap.length; i++)
            System.out.print(heap[i]+" ");
    }
}
