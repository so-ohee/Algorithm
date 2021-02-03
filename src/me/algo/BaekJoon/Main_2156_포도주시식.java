package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 포도주 시식
 * 2021. 02. 03
 * https://www.acmicpc.net/problem/2156
 */

public class Main_2156_포도주시식 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n+1];
        dp[1] = arr[1];
        for(int i=2; i<=n; i++){
            if(i==2) dp[2] = dp[1]+arr[2];
            else {
                dp[i] = Math.max(dp[i-2]+arr[i],dp[i-3]+arr[i-1]+arr[i]);
                dp[i] = Math.max(dp[i],dp[i-1]);
            }
        }
        System.out.println(dp[n]);
    }
}
