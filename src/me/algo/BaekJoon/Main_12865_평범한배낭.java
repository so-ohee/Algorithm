package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 평범한 배낭
 * 2021. 02. 04
 * https://www.acmicpc.net/problem/12865
 */

public class Main_12865_평범한배낭 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //물품의 수
        int k = Integer.parseInt(st.nextToken()); //버틸 수 있는 무게

        int[] w = new int[n+1];
        int[] v = new int[n+1];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            w[i+1] = Integer.parseInt(st.nextToken());
            v[i+1] = Integer.parseInt(st.nextToken());
        }


        int[] dp = new int[k+1];
        for(int i = 1; i < n+1; i++) {
            for(int j = k; j-w[i] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j-w[i]] + v[i]);
            }
        }
        System.out.println(dp[k]);

//        int[][] dp = new int[n+1][k+1];
//        for(int i=1; i<=n; i++){
//            for(int j=1; j<=k; j++){
//                if(w[i] > j)
//                    dp[i][j] = dp[i-1][j];
//                else
//                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
//            }
//        }
//        System.out.println(dp[n][k]);
    }
}
