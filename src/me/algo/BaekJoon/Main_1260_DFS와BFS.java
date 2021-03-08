package me.algo.BaekJoon;

/* DFS와 BFS
 * 2021. 03. 08
 * https://www.acmicpc.net/problem/1260
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {
    static int N, M, V;
    static int[][] arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    private static void dfs(int index){
        visit[index] = true;
        sb.append(index).append(" ");
        for(int i=1; i<=N; i++){
            if(!visit[i] && arr[index][i] == 1)
                dfs(i);
        }
    }

    private static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        visit[V] = true;
        while (!queue.isEmpty()){
            int temp = queue.poll();
            sb.append(temp).append(" ");

            for(int i=1; i<=N; i++){
                if(!visit[i] && arr[temp][i] == 1){
                    queue.offer(i);
                    visit[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //정점의 개수
        M = Integer.parseInt(st.nextToken()); //간선의 개수
        V = Integer.parseInt(st.nextToken()); //정점의 번호

        arr = new int[N+1][N+1];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }

        visit = new boolean[N+1];
        dfs(V);
        sb.append("\n");
        Arrays.fill(visit, false);
        bfs();

        System.out.println(sb);
    }
}
