package me.algo.BaekJoon.Math;

/* 부녀회장이 될테야
 * 2021. 04. 12
 * https://www.acmicpc.net/problem/2775
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2775_부녀회장이될테야 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[15][15];
        for(int i=0; i<15; i++){
            dp[i][1] = 1;
            dp[0][i] = i;
        }
        for(int i=1; i<15; i++){
            for(int j=2; j<15; j++){
                dp[i][j] = dp[i][j-1]+dp[i-1][j];
            }
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[k][n]).append("\n");
        }
        System.out.println(sb);
    }
}
