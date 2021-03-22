package me.algo.BaekJoon.BinarySearch;

/* 랜선 자르기
 * 2021. 03. 22
 * https://www.acmicpc.net/problem/1654
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1654_랜선자르기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        for(int i=0; i<K; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long max = arr[K-1]; //mid를 구하는 과정 중에 min,max 모두 int 범위를 넘을 수 있음.
        long min = 1; //문제에서 랜선 길이는 자연수라 0으로 초기값으로 정하면 에러 발생.
        long mid = 0;

        while (max >= min){
            mid = (max+min)/2;

            long count = 0;
            for(int i =0; i<K; i++){
                count += arr[i]/mid;
            }
            if(count >= N)
                min = mid + 1;
            else
                max = mid - 1;
        }
        System.out.println(max);
    }
}