package me.algo.BaekJoon;

/* 쉬운 계단 수
 * 2021. 01. 26
 * https://www.acmicpc.net/problem/10844
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10844_쉬운계단수 {
    static final int mod = 1000000000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][10];
        for(int i=0; i<10; i++){
            dp[1][i] = 1;
        }
        for(int i=2; i<=N; i++){
            dp[i][0] = dp[i-1][1];
            for(int j=1; j<9; j++){
                dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1]) % mod;
            }
            dp[i][9] = dp[i-1][8] % mod;
        }
        long sum = 0;
        for(int i=1; i<10; i++){
            sum += dp[N][i];
        }
        System.out.println(sum % mod);
    }
}
