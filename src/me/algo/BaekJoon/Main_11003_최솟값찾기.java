package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/* 최솟값 찾기
 * 2021. 01. 06
 * https://www.acmicpc.net/problem/11003
 */

public class Main_11003_최솟값찾기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());

            //범위 인덱스 내에서 최솟값 인덱스를 넣기 위한 작업
            //현재 A[i]보다 큰 것은 처분
            while (!deque.isEmpty()&&arr[deque.getLast()]>arr[i])
                deque.removeLast();

            //범위를 벗어나는 인덱스 제거(최솟값부터 제거)
            if(!deque.isEmpty() && deque.getFirst()<=i-L)
                deque.removeFirst();

            deque.add(i);
            bw.write(arr[deque.getFirst()]+" ");
        }
        bw.close();
    }
}
