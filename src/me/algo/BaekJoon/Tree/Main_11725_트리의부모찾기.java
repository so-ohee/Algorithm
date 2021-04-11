package me.algo.BaekJoon.Tree;

/* 트리의 부모 찾기
 * 2021. 04. 11
 * https://www.acmicpc.net/problem/11725
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_11725_트리의부모찾기 {
    static List<Integer>[] list;
    static int[] parents;
    static boolean[] check;

    private static void dfs(int index){
       if(check[index]) return;
       check[index] = true;

       for(int i : list[index]){
           if(!check[i]){
               parents[i] = index;
               dfs(i);
           }
       }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];
        parents = new int[N+1];
        check = new boolean[N+1];

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=1; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for(int i=1; i<=N; i++){
            if(!check[i]) dfs(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=N; i++){
            sb.append(parents[i]).append("\n");
        }
        System.out.println(sb);
    }
}
