package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 가장 긴 증가하는 부분 수열
 * 2021. 01. 28
 * https://www.acmicpc.net/problem/11053
 */

public class Main_11053_가장긴증가하는부분수열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = 1;
        for(int i=1; i<N; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i] && dp[i]<=dp[j])
                    dp[i]++;
            }
        }

        int max=0;
        for(int i : dp){
            max = Math.max(i,max);
        }
        System.out.println(max);
    }
}
