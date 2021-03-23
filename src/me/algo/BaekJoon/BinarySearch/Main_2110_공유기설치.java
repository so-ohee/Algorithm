package me.algo.BaekJoon.BinarySearch;

/* 공유기 설치
 * 2021. 03. 23
 * https://www.acmicpc.net/problem/2110
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2110_공유기설치 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int max = arr[N-1]-arr[0];
        int min = 1;
        while (max >= min){
            int mid = (max+min)/2;
            int start = arr[0];
            int count = 1;

            for(int i=1; i<N; i++){
                int distance = arr[i] - start;
                if(distance >= mid){
                    count++;
                    start = arr[i];
                }
            }
            if(count >= C)
                min = mid + 1;
            else
                max = mid - 1;
        }
        System.out.println(max);
    }
}
