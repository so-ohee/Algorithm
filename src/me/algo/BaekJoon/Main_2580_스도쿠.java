package me.algo.BaekJoon;

/* 스도쿠
 * 2021. 02. 23
 * https://www.acmicpc.net/problem/2580
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2580_스도쿠 {
    static int[][] arr = new int[9][9];
    private static void dfs(int row, int col){
        if(col==9) {
            dfs(row + 1, 0);
        }else if(row==9){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    sb.append(arr[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }else if(arr[row][col]==0){
            for(int i=1; i<=9; i++){
                if(Possibility(row,col,i)){
                    arr[row][col] = i;
                    dfs(row,col+1);
                    arr[row][col] = 0;
                }
            }
        }else {
            dfs(row, col + 1);
        }
    }
    private static boolean Possibility(int row, int col, int value){
        for(int i=0; i<9; i++){
            if(arr[row][i]==value)
                return false;
            if(arr[i][col]==value)
                return false;
        }

        int r = (row/3)*3;
        int c = (col/3)*3;
        for(int i=r; i<r+3; i++){
            for(int j=c; j<c+3; j++){
                if(arr[i][j]==value)
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=0; i<9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
    }
}
