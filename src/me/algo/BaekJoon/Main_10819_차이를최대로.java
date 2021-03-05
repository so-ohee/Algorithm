package me.algo.BaekJoon;

/* 차이를 최대로
 * 2021. 03. 05
 * https://www.acmicpc.net/problem/10819
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10819_차이를최대로 {
    static int N;
    static int[] arr;
    static int[] answer;
    static boolean[] visit;
    static int max = Integer.MIN_VALUE;
    private static void dfs(int count){
        if(count==N){
            int temp = 0;
            for(int i=0; i<N-1; i++){
                temp += Math.abs(answer[i]-answer[i+1]);
            }
            max = Math.max(max,temp);
            return;
        }
        for(int i=0; i<N; i++){
            if(!visit[i]){
                visit[i] = true;
                answer[count] = arr[i];
                dfs(count+1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        answer = new int[N];
        visit = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(max);
    }
}
