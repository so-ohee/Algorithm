package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 전깃줄
 * 2021. 02. 05
 * https://www.acmicpc.net/problem/2565
 */

public class Main_2565_전깃줄 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][2];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(int[] o1, int[] o2)->o1[0]-o2[0]);

        int[] dp = new int[n+1];
        int max = 0;
        for(int i=1; i<=n; i++){
            dp[i] = 1;
            for(int j=1; j<i; j++){
                if(arr[j][1] < arr[i][1])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
            max = Math.max(max,dp[i]);
        }
        System.out.println(n-max);
    }
}
