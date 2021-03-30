package me.algo.BaekJoon.DivideandConquer;

/* 색종이 만들기
 * 2021. 03. 30
 * https://www.acmicpc.net/problem/2630
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2630_색종이만들기 {
    static int[][] arr;
    static int[] answer = new int[2];
    private static boolean check(int x, int y, int size){
        for(int i=x; i<x+size; i++){
            for(int j=y; j<y+size; j++){
                if(arr[x][y] != arr[i][j])
                    return false;
            }
        }
        return true;
    }
    private static void dfs(int x, int y, int size){
        if(check(x, y, size)){
            answer[arr[x][y]]++;
            return;
        }

        dfs(x,y,size/2);
        dfs(x,y+size/2,size/2);
        dfs(x+size/2,y,size/2);
        dfs(x+size/2,y+size/2,size/2);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i=0; i<N; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        dfs(0,0,N);
        System.out.println(answer[0]+"\n"+answer[1]);
    }
}
