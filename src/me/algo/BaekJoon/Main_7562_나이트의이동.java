package me.algo.BaekJoon;

/* 나이트의 이동
 * 2021. 03. 11
 * https://www.acmicpc.net/problem/7562
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562_나이트의이동 {
    static int I;
    static int[] now = new int[2];
    static int[] goal = new int[2];
    static int[] dx = {-1,-2,-2,-1,1,2,2,1};
    static int[] dy = {-2,-1,1,2,2,1,-1,-2};
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    private static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(now);

        while (!queue.isEmpty()){
            int[] temp = queue.poll();
            if(Arrays.equals(temp,goal))
                sb.append(arr[temp[0]][temp[1]]).append("\n");

            for(int i=0; i<8; i++){
                int nx = temp[0]+dx[i];
                int ny = temp[1]+dy[i];

                if(nx>=0 && nx<I && ny>=0 && ny<I){
                    if(arr[nx][ny]==0){
                        queue.offer(new int[]{nx,ny});
                        arr[nx][ny] = arr[temp[0]][temp[1]]+1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        String[] s;
        for(int i=0; i<T; i++){
            I = Integer.parseInt(br.readLine());
            arr = new int[I][I];

            s = br.readLine().split(" ");
            now[0] = Integer.parseInt(s[0]);
            now[1] = Integer.parseInt(s[1]);

            s = br.readLine().split(" ");
            goal[0] = Integer.parseInt(s[0]);
            goal[1] = Integer.parseInt(s[1]);

            if(Arrays.equals(now,goal))
                sb.append(0).append("\n");
            else
                bfs();
        }
        System.out.println(sb);
    }
}