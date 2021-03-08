package me.algo.BaekJoon;

/* 유기농 배추
 * 2021. 03. 08
 * https://www.acmicpc.net/problem/1012
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {
    static int T,M,N,K,count;
    static int[][] arr;
    static boolean[][] visit;
    static int[] arrX = {0,-1,0,1};
    static int[] arrY = {-1,0,1,0};
    private static void dfs(int x, int y){
        visit[x][y]=true;
        for(int i=0; i<4; i++){
            int nx = x+arrX[i];
            int ny = y+arrY[i];

            if(nx>=0 && nx<N && ny>=0 && ny<M){
                if(arr[nx][ny]==1 && !visit[nx][ny])
                    dfs(nx,ny);
            }
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); //가로 길이
            N = Integer.parseInt(st.nextToken()); //세로 길이
            K = Integer.parseInt(st.nextToken()); //위치 개수

            arr = new int[N][M];
            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[b][a]=1;
            }

            visit = new boolean[N][M];
            count = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(arr[i][j]==1 && !visit[i][j]){
                        dfs(i,j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
