package me.algo.BaekJoon.DivideandConquer;

/* 쿼드트리
 * 2021. 03. 30
 * https://www.acmicpc.net/problem/1992
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1992_쿼드트리 {
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    private static boolean check(int x, int y, int size){
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(arr[x][y]!=arr[i][j])
                    return false;
            }
        }
        return true;
    }
    private static void dfs(int x, int y, int size){
        if(check(x,y,size)) {
            sb.append(arr[x][y]);
            return;
        }

        sb.append("(");
        dfs(x,y,size/2);
        dfs(x,y+size/2,size/2);
        dfs(x+size/2,y,size/2);
        dfs(x+size/2,y+size/2,size/2);
        sb.append(")");
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = s.charAt(j)-'0';
            }
        }

        dfs(0,0,N);
        System.out.println(sb);
    }
}
