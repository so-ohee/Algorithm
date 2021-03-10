package me.algo.BaekJoon;

/* 벽 부수고 이동하기
 * 2021. 03. 10
 * https://www.acmicpc.net/problem/2206
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206_벽부수고이동하기 {
    static int N,M;
    static int[][] arr;
    static boolean[][][] visit; //벽이 부서진 상태일때, 아닐때 따로 확인
    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};

    public static class Point{
        int x,y; //위치
        int count; //이동 횟수
        int wall; //벽 부순 여부
        Point(int x, int y, int count, int wall){
            this.x=x;
            this.y=y;
            this.count=count;
            this.wall=wall;
        }
    }
    public static void bfs(){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0,0,1,0));

        while (!queue.isEmpty()){
            Point p = queue.poll();
            System.out.println(p.x+" "+p.y+" "+p.count+" "+p.wall);
            if(p.x==N-1 && p.y==M-1){
                System.out.println(p.count);
                return;
            }

            for(int i=0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(nx>=0 && nx<N && ny>=0 && ny<M){
                    if(arr[nx][ny]==1){
                        if(p.wall==0 && !visit[nx][ny][1]){
                            queue.offer(new Point(nx,ny,p.count+1,1));
                            visit[nx][ny][1]=true;
                        }
                    }else {
                        if(!visit[nx][ny][p.wall]){
                            queue.offer(new Point(nx,ny,p.count+1,p.wall));
                            visit[nx][ny][p.wall]=true;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로

        arr = new int[N][M];
        visit = new boolean[N][M][2];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = s.charAt(j)-'0';
            }
        }
        
        bfs();
    }
}