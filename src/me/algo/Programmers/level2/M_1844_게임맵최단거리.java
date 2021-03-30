package me.algo.Programmers.level2;

/* 게임 맵 최단거리
 * 2021. 03. 30
 * https://programmers.co.kr/learn/courses/30/lessons/1844
 */

import java.util.LinkedList;
import java.util.Queue;

public class M_1844_게임맵최단거리 {
    static int N, M;
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    private static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});

        while (!queue.isEmpty()){
            int[] temp = queue.poll();
            visit[x][y] = true;

            for(int i=0; i<4; i++){
                int nx = temp[0]+dx[i];
                int ny = temp[1]+dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<M){
                    if(!visit[nx][ny] && arr[nx][ny]!=0){
                        queue.offer(new int[]{nx,ny});
                        visit[nx][ny] = true;
                        arr[nx][ny] = arr[temp[0]][temp[1]]+1;
                    }
                }
            }
        }
    }
    public static int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        arr = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++)
                arr[i][j] = maps[i][j];
        }
        visit = new boolean[N][M];

        bfs(0,0);

        return arr[N-1][M-1]==maps[N-1][M-1]? -1 : arr[N-1][M-1];
    }

    public static void main(String[] args) {
        int[][] m = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        System.out.println(solution(m));
        int[][] m2 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};
        System.out.println(solution(m2));
    }
}
