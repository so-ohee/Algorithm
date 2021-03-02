package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* N과 M (5)
 * 2021. 03. 02
 * https://www.acmicpc.net/problem/15654
 */

public class Main_15654_N과M_5 {
    static int N, M;
    static int[] arr;
    static int[] answer;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    private static void dfs(int index){
        if(index==M){
            for(int i=0; i<M; i++){
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<N; i++){
            if(!visit[i]){
                visit[i] = true;
                answer[index] = arr[i];
                dfs(index+1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        answer = new int[M];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0);
        System.out.println(sb);
    }
}
