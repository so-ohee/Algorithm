package me.algo.BaekJoon;

/* 파도반 수열
 * 2021. 01. 18
 * https://www.acmicpc.net/problem/9461
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_9461_파도반수열 {
    static long[] dp = new long[101];
    private static long solution(int n){
        if(dp[n]!=0) return dp[n];
        return dp[n]=solution(n-2)+solution(n-3);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp[1]=dp[2]=dp[3]=1;
        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(solution(n));
        }
    }
}
