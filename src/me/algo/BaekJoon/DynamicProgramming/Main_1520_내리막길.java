package me.algo.BaekJoon.DynamicProgramming;

/* 내리막길
 * 2021. 03. 17
 * https://www.acmicpc.net/problem/1520
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1520_내리막길 {
    static int N,M;
    static int[][] arr;
    static int[][] dp;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    private static int dfs(int x, int y){
        if(x==N-1 && y==M-1) return 1;
        if(dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;

        for(int i=0; i<4; i++){
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if(nx>=0 && nx<N && ny>=0 && ny<M){
                if(arr[x][y] > arr[nx][ny])
                    dp[x][y] += dfs(nx,ny);
            }
        }
        return dp[x][y];
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        dp = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0,0));
    }
}
