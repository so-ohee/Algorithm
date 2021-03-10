package me.algo.BaekJoon;

/* 토마토
 * 2021. 03. 10
 * https://www.acmicpc.net/problem/7569
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569_토마토 {
    static int N,M,H;
    static int[][][] arr;
    static int[] dx = {0,-1,0,1,0,0};
    static int[] dy = {-1,0,1,0,0,0};
    static int[] dh = {0,0,0,0,-1,1};
    static Queue<int[]> queue = new LinkedList<>();
    private static void bfs(){
        while (!queue.isEmpty()){
            int[] temp = queue.poll();

            for(int i=0; i<6; i++){
                int nh = temp[0]+dh[i];
                int nx = temp[1]+dx[i];
                int ny = temp[2]+dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<M && nh>=0 && nh<H){
                    if(arr[nh][nx][ny]==0){
                        queue.offer(new int[]{nh, nx, ny});
                        arr[nh][nx][ny] = arr[temp[0]][temp[1]][temp[2]]+1;
                    }
                }
            }
        }

        int max=0;
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(arr[i][j][k]==0){
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max,arr[i][j][k]);
                }
            }
        }
        System.out.println(max-1);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];
        for(int i=0; i<H; i++){
            for(int j=0; j<N; j++){
                String[] s = br.readLine().split(" ");
                for(int k=0; k<M; k++){
                    arr[i][j][k] = Integer.parseInt(s[k]);
                    if(arr[i][j][k]==1)
                        queue.offer(new int[]{i,j,k});
                }
            }
        }
        bfs();
    }
}
