package me.algo.BaekJoon.DynamicProgramming;

/* 동전 1
 * 2021. 03. 16
 * https://www.acmicpc.net/problem/2293
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2293_동전1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K+1];
        dp[0]=1;
        for(int i=0; i<N; i++){
            int coin = Integer.parseInt(br.readLine());
            for(int j=coin; j<=K; j++){
                dp[j] += dp[j-coin];
            }
        }
        System.out.println(dp[K]);
    }
}
