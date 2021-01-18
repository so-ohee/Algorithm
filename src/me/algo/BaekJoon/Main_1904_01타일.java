package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 01타일
 * 2021. 01. 18
 * https://www.acmicpc.net/problem/1904
 */

public class Main_1904_01타일 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) System.out.println(1);
        else {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for(int i=3; i<=n; i++){
                dp[i] = (dp[i-2]+dp[i-1])%15746;
            }
            System.out.println(dp[n]);
        }
    }
}
