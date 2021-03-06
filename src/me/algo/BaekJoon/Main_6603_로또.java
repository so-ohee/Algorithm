package me.algo.BaekJoon;

/* 로또
 * 2021. 03. 06
 * https://www.acmicpc.net/problem/6603
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603_로또 {
    static int K;
    static int N = 6;
    static int[] arr;
    static int[] answer = new int[N];
    static StringBuilder sb = new StringBuilder();
    private static void dfs(int count, int index){
        if(count==N){
            for(int a:answer)
                sb.append(a).append(" ");
            sb.append("\n");
            return;
        }
        for(int i=index; i<K; i++){
            answer[count] = arr[i];
            dfs(count+1, i+1);
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true){
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if(K==0) break;
            arr = new int[K];
            for(int i=0; i<K; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0,0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
