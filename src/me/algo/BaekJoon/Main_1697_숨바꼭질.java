package me.algo.BaekJoon;

/* 숨바꼭질
 * 2021. 03. 10
 * https://www.acmicpc.net/problem/1697
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {
    static int N,K;
    static int[] visit = new int[100001];
    private static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        while (!queue.isEmpty()){
            N = queue.poll();

            if(N==K) break;
            if(N+1 <100001  && visit[N+1]==0){
                queue.offer(N+1);
                visit[N+1] = visit[N]+1;
            }
            if(N-1 >= 0 && visit[N-1]==0){
                queue.offer(N-1);
                visit[N-1] = visit[N]+1;
            }
            if(N*2 < 100001 && visit[N*2]==0){
                queue.offer(N*2);
                visit[N*2] = visit[N]+1;
            }
        }

        System.out.println(visit[K]);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();
    }
}
