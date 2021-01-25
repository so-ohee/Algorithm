package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* RGB거리
 * 2021. 01. 25
 * https://www.acmicpc.net/problem/1149
 */
public class Main_1149_RGB거리 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[3];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            if(i==0){
                dp[0] = Integer.parseInt(st.nextToken());
                dp[1] = Integer.parseInt(st.nextToken());
                dp[2] = Integer.parseInt(st.nextToken());
            }else{
                int R=dp[0], G=dp[1];
                dp[0] = Math.min(G,dp[2])+Integer.parseInt(st.nextToken());
                dp[1] = Math.min(R,dp[2])+Integer.parseInt(st.nextToken());
                dp[2] = Math.min(R,G)+Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(Math.min(dp[0],Math.min(dp[1],dp[2])));
    }
}
