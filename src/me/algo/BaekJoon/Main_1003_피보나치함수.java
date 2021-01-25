package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* 피보나치 함수
 * 2021. 01. 28
 * https://www.acmicpc.net/problem/1003
 */

public class Main_1003_피보나치함수 {
    static int[] dp = new int[41];
    private static int fibonacci(int n){
        if(n<0) return 1;
        else if(n==0 || n==1) return n;
        else if(dp[n] != 0) return dp[n];
        return dp[n] = fibonacci(n-1)+fibonacci(n-2);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            sb.append(fibonacci(N-1)).append(" ").append(fibonacci(N)).append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.close();
    }
}
