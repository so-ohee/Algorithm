package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* N-Queen
 * 2021. 02. 23
 * https://www.acmicpc.net/problem/9663
 */

public class Main_9663_NQueen {
    static int N;
    static int[] arr;
    static int count=0;

    private static void dfs(int col){
        if(col==N){
            count++;
            return;
        }
        for(int i=0; i<N; i++){
            arr[col] = i;
            if(Possibility(col)){
                dfs(col+1);
            }
        }
    }
    private static boolean Possibility(int col){
        for(int i=0; i<col; i++){
            if(arr[col]==arr[i])
                return false;
            else if(Math.abs(col-i)==Math.abs(arr[col]-arr[i]))
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        dfs(0);
        System.out.println(count);
    }
}
