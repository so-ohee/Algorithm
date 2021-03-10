package me.algo.BaekJoon;

/* 토마토
 * 2021. 03. 10
 * https://www.acmicpc.net/problem/7576
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {
    static int N,M;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};
    static int[][] arr;
    static Queue<int[]> queue = new LinkedList<>();

    private static void bfs(){
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (arr[nx][ny] == 0) {
                        queue.offer(new int[]{nx,ny});
                        arr[nx][ny] = arr[temp[0]][temp[1]]+1;
                    }
                }
            }
        }

        int max=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j]==0){
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max,arr[i][j]);
            }
        }
        System.out.println(max-1);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i=0; i<N; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(s[j]);
                if(arr[i][j] == 1){
                    queue.add(new int[]{i,j});
                }
            }
        }

        bfs();
    }
}