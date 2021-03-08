package me.algo.BaekJoon;

/* 바이러스
 * 2021. 03. 08
 * https://www.acmicpc.net/problem/2606
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {
    static int N, M;
    static int[][] arr;
    static boolean[] visit;
    static int count = -1;
    private static void dfs(int v){
        visit[v] = true;
        count++;
        for (int i=1; i<=N; i++){
            if(!visit[i] && arr[v][i] ==1)
                dfs(i);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }

        visit = new boolean[N+1];
        dfs(1);
        System.out.println(count);
    }
}
