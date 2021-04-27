package me.algo.BaekJoon.DynamicProgramming;

/* 행렬 곱셈 순서
 * 2021. 04. 27
 * https://www.acmicpc.net/problem/11049
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11049_행렬곱셈순서 {
    static int N;
    static int[][] arr;
    private static int solution(){
        int[][] dp = new int[N][N];

        for(int i=N-2; i>=0; i--){
            for(int j=i+1; j<N; j++){
                if(j==(i+1)) dp[i][j] = arr[i][0]*arr[i][1]*arr[j][1];
                else dp[i][j] = Integer.MAX_VALUE;

                for(int k=i; k<j; k++){
                    dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+(arr[i][0]*arr[k][1]*arr[j][1]));
                }
            }
        }
        return dp[0][N-1];
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution());
    }
}
