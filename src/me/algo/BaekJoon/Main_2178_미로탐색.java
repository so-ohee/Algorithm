package me.algo.BaekJoon;

/* 미로 탐색
 * 2021. 03. 09
 * https://www.acmicpc.net/problem/2178
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {
    static int N,M;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};

    private static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});

        while (!queue.isEmpty()){
            int[] temp = queue.poll();
            visit[x][y] = true;

            for(int i=0; i<4; i++){
                int nx = temp[0]+dx[i];
                int ny = temp[1]+dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<M){
                    if (!visit[nx][ny] && arr[nx][ny]!=0){
                        queue.offer(new int[]{nx,ny});
                        visit[nx][ny] = true;
                        arr[nx][ny] = arr[temp[0]][temp[1]]+1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = s.charAt(j)-'0';
            }
        }

        visit = new boolean[N][M];
        bfs(0,0);
        System.out.println(arr[N-1][M-1]);
    }
}
