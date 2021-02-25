package me.algo.BaekJoon;

/* 스타트와 링크
 * 2021. 02. 24
 * https://www.acmicpc.net/problem/14889
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {
    static int N;
    static int[][] arr;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;
    private static void dfs(int index, int count){
        if(count == N/2){
            int start=0, link=0;
            for(int i=0; i<N-1; i++){
                for(int j=i+1; j<N; j++){
                    if(visit[i] && visit[j]){
                        start += (arr[i][j]+arr[j][i]);
                    }else if(!visit[i] && !visit[j]){
                        link += (arr[i][j]+arr[j][i]);
                    }
                }
            }
            min = Math.min(min,Math.abs(start-link));
            if(min==0){
                System.out.println(min);
                System.exit(0);
            }
            return;
        }

        for(int i=index; i<N; i++){
            if(!visit[i]){
                visit[i]=true;
                dfs(i+1,count+1);
                visit[i]=false;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.println(min);
    }
}
