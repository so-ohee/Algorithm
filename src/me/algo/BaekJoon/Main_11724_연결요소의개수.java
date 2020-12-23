package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 연결 요소의 개수
 * 2020. 12. 23
 * https://www.acmicpc.net/problem/11724
 */

public class Main_11724_연결요소의개수 {
    static int[][] arr;
    static boolean[] visit;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //정점의 개수
        int M = Integer.parseInt(st.nextToken()); //간선의 개수

        arr = new int[N+1][N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u][v]=arr[v][u]=1;
        }

        int count =0;
        visit = new boolean[N+1];
        for(int i=1; i<arr.length; i++){
            if(!visit[i]){
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
    private static void dfs(int n){
        if(visit[n]) return;
        visit[n] = true;
        for(int i=1;i<arr.length;i++){
            if(arr[n][i]==1)
                dfs(i);
        }
    }
}
