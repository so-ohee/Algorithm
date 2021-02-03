package me.algo.BaekJoon;

/* 1로 만들기
 * 2021. 02. 03
 * https://www.acmicpc.net/problem/1463
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1463_1로만들기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+1;
            if(i%2==0) dp[i] = Math.min(dp[i],dp[i/2]+1);
            if(i%3==0) dp[i] = Math.min(dp[i],dp[i/3]+1);
        }
        System.out.println(dp[n]);
    }
}
