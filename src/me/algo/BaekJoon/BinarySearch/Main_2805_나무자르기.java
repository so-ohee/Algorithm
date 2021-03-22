package me.algo.BaekJoon.BinarySearch;

/* 나무 자르기
 * 2021. 03. 22
 * https://www.acmicpc.net/problem/2805
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805_나무자르기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int max = arr[N-1];
        int min = 0;
        int mid = 0;
        while (max >= min){
            mid = (max+min)/2;

            long sum = 0;
            for(int i=0; i<N; i++){
                if(arr[i] > mid)
                    sum += arr[i] - mid;
            }
            if(sum >= M)
                min = mid+1;
            else
                max = mid-1;
        }
        System.out.println(max);
    }
}