package me.algo.BaekJoon.Math;

/* 이항 계수 2
 * 2021. 04. 12
 * https://www.acmicpc.net/problem/11051
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11051_이항계수2 {
    static int[][] dp;
    private static int solution(int n, int k) {
        if (k==0 || n==k)	return dp[n][k] = 1;
        if(dp[n][k] !=0) return dp[n][k];
        return dp[n][k] = (solution(n-1,k)+solution(n-1,k-1))%10007;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[N+1][K+1];
        solution(N,K);
        System.out.println(dp[N][K]);
    }
}
