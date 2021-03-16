package me.algo.BaekJoon.DynamicProgramming;

/* 파일 합치기
 * 2021. 03. 16
 * https://www.acmicpc.net/problem/11066
 * 참조 : https://m.blog.naver.com/tjdwns0920/221135677693
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11066_파일합치기 {
    static int K;
    static int[] arr;
    static int[] sum;
    static StringBuilder sb = new StringBuilder();

    private static int sum(int s, int e){
        if(s==0) return sum[e];
        else return sum[e]-sum[s-1];
    }
    private static void solution(){
        sum = new int[K]; //sum 저장
        int[][] dp = new int[K][K]; //i~j까지 최소합

        //i요소 까지 총합
        sum[0] = arr[0];
        for(int i=1; i<K; i++){
            sum[i] += sum[i-1]+arr[i];
        }

        //인접한 값 저장
        for(int i=0; i<K-1; i++){
            dp[i][i+1] = arr[i]+arr[i+1];
        }

        for(int gap=2; gap<K; gap++){
            for(int i=0; i+gap<K; i++){
                int j = i+gap;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<j; k++){
                    dp[i][j] = Math.min(dp[i][k]+dp[k+1][j]+sum(i,j),dp[i][j]);
                }
            }
        }

        sb.append(dp[0][K-1]).append("\n");
    }
//    private static void solution() {
//        int[][] dp = new int[K][K];
//
//        for(int i=K-1; i>=0; i--){
//            int sum = arr[i];
//            for(int j=i+1; j<K; j++){
//                sum += arr[j];
//                dp[i][j] = Integer.MAX_VALUE;
//                for(int k=i; k<j; k++){
//                    dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k+1][j]);
//                }
//                dp[i][j] += sum;
//            }
//        }
//
//        System.out.println(dp[0][K-1]);
//    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            K = Integer.parseInt(br.readLine());
            arr = new int[K];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<K; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            solution();
        }
        System.out.println(sb);
    }
}
