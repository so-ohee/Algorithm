package me.algo.BaekJoon;

/* N과 M (1)
 * 2021. 02. 22
 * https://www.acmicpc.net/problem/15649
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15649_N과M_1 {
    static int N,M;
    static int[] arr = new int[9];
    static boolean[] visit = new boolean[9];
    static StringBuilder sb = new StringBuilder();

    private static void dfs(int count){
        if(count==M){
            for(int i=0; i<M; i++)
                sb.append(arr[i]).append(' ');
            sb.append('\n');
            return;
        }
        for(int i=1; i<=N; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[count] = i;
                dfs(count+1);
                visit[i] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(0);
        System.out.println(sb);
    }
}
