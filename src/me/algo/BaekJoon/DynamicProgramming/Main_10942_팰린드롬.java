package me.algo.BaekJoon.DynamicProgramming;

/* 팰린드롬?
 * 2021. 04. 28
 * https://www.acmicpc.net/problem/10942
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_10942_팰린드롬 {
    static int[] arr;
    static boolean[][] dp;
    private static boolean solution(int s, int e){
        if(s==e) return dp[s][s] = true;
        if(e-s==1) return dp[s][e] = arr[s]==arr[e];
        if(dp[s][e]) return true;
        if(arr[s]==arr[e]) return dp[s][e] = solution(s+1,e-1);
        return false;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        dp = new boolean[N+1][N+1];
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        while (M-- > 0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(solution(start,end))
                bw.write(1+"\n");
            else
                bw.write(0+"\n");
        }
        bw.close();
    }
}
