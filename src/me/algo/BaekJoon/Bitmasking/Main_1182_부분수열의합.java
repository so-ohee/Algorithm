package me.algo.BaekJoon.Bitmasking;

/* 부분수열의 합
 * 2021. 04. 02
 * https://www.acmicpc.net/problem/1182
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182_부분수열의합 {
    static int N, S;
    static int[] arr;
    private static boolean dfs(int set){
        int sum = 0;
        for(int i=0; i<N; i++){
            if((set & (1<<i)) != 0){
                sum += arr[i];
            }
        }
        if(sum == S) return true;
        else return false;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr= new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for(int set = 1; set < (1<<N); set++){
            if(dfs(set)) answer++;
        }
        System.out.println(answer);
    }
}
