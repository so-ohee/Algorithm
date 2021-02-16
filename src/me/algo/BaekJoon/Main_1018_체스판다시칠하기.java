package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 체스판 다시 칠하기
 * 2021. 02. 16
 * https://www.acmicpc.net/problem/1018
 */

public class Main_1018_체스판다시칠하기 {
    static String[] board = new String[50];
    static String[] wArr = {"WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW",
            "WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW"};
    static String[] bArr = {"BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB",
            "BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB"};

    private static int check(int y,int x, String[] arr){
        int count = 0;
        for(int i=y; i<y+8; i++){
            for(int j=x; j<x+8; j++){
                if(board[i].charAt(j)!=arr[i-y].charAt(j-x)) count++;
            }
        }
        return count;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            board[i] = br.readLine();
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0; i+7<N; i++){
            for(int j=0; j+7<M; j++){
                answer = Math.min(answer,Math.min(check(i,j,wArr),check(i,j,bArr)));
            }
        }
        System.out.println(answer);
    }
}