package me.algo.BaekJoon.TwoPointers;

/* 부분합
 * 2021. 05. 04
 * https://www.acmicpc.net/problem/1860
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1806_부분합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int left=0, right=0, sum = 0;
        while (true){
            if(sum>=S){
                sum-=arr[left++];
                min = Math.min(min,(right-left+1));
            } else if(right==N) break;
            else sum += arr[right++];
        }
        System.out.println(min==Integer.MAX_VALUE ? 0 : min);
    }
}
