package me.algo.BaekJoon;

/* N과 M (2)
 * 2021. 02. 22
 * https://www.acmicpc.net/problem/15650
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650_N과M_2 {
    static int N,M;
    static int arr[] = new int[9];
    static boolean visit[] = new boolean[9];
    static StringBuilder sb = new StringBuilder();

    private static void dfs(int count, int index){
        if(count==M){
            for(int i=0; i<M; i++)
                sb.append(arr[i]).append(' ');
            sb.append('\n');
            return;
        }
        for(int i=index; i<=N; i++){
            if(!visit[i]){
                visit[i]=true;
                arr[count]=i;
                dfs(count+1,i+1);
                visit[i]=false;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(0,1);
        System.out.println(sb);
    }
}
