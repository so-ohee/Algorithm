package me.algo.BaekJoon;

/* 계단 오르기
 * 2021. 01. 19
 * https://www.acmicpc.net/problem/2579
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2579_계단오르기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[300];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[300];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0]+arr[1],arr[1]);
        dp[2] = Math.max(arr[0]+arr[2], arr[1]+arr[2]);
        for(int i=3; i<n; i++){
            dp[i]=Math.max(dp[i-2]+arr[i],dp[i-3]+arr[i]+arr[i-1]);
        }
        System.out.println(dp[n-1]);
    }
}
