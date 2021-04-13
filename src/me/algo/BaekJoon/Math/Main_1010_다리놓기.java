package me.algo.BaekJoon.Math;

/* 다리 놓기
 * 2021. 04. 12
 * https://www.acmicpc.net/problem/1010
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1010_다리놓기 {
    static int[][] dp;
    private static int solution(int n, int m){
        if(m==0 || n==m) return dp[n][m] = 1;
        if(dp[n][m] != 0) return dp[n][m];
        return dp[n][m] = solution(n-1,m)+solution(n-1,m-1);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            dp = new int[M+1][N+1];
            solution(M,N);
            sb.append(dp[M][N]).append("\n");
        }
        System.out.println(sb);
    }
}
