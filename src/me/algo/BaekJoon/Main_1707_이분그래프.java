package me.algo.BaekJoon;

/* 이분 그래프
 * 2021. 03. 11
 * https://www.acmicpc.net/problem/1707
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1707_이분그래프 {
    static ArrayList<Integer>[] list;
    static int[] check;
    private static boolean bfs(int x){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        check[x] = 1;
        while (!queue.isEmpty()){
            int temp = queue.poll();
            for(Integer i : list[temp]){
                if(check[temp]==check[i]) {
                    return false;
                }
                if(check[i]==0){
                    check[i]=check[temp]*-1;
                    queue.add(i);
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        String[] s;
        while (K-- > 0){
            s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);

            list = new ArrayList[V+1];

            for(int i=1; i<=V; i++){
                list[i] = new ArrayList<>();
            }
            for(int j=0; j<E; j++){
                s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);

                list[a].add(b);
                list[b].add(a);
            }

            check = new int[V+1];
            String answer = "YES";
            for(int i=1; i<=V; i++){
                if(check[i]==0)
                    if(!bfs(i)) {
                        answer = "NO";
                        break;
                    }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
