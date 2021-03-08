package me.algo.BaekJoon;

/* 단지번호붙이기
 * 2021. 03. 08
 * https://www.acmicpc.net/problem/2667
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_2667_단지번호붙이기 {
    static int N, count;
    static int[][] arr;
    static boolean[][] visit;
    static int[] arrX = {0,-1,0,1};
    static int[] arrY = {-1,0,1,0};
    static List<Integer> list = new ArrayList<>();

    private static void dfs(int x, int y){
        visit[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x+arrX[i];
            int ny = y+arrY[i];

            if(nx>=0 && ny>=0 && nx<N && ny<N){
                if(arr[nx][ny]==1 && !visit[nx][ny]) {
                    dfs(nx, ny);
                    count++;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = s.charAt(j)-'0';
            }
        }

        visit = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j] == 1 && !visit[i][j]){
                    count = 1;
                    dfs(i,j);
                    list.add(count);
                }
            }
        }


        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for(Integer i : list){
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
