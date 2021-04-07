package me.algo.BaekJoon.Dijkstra;

/* 최단경로
 * 2021. 04. 07
 * https://www.acmicpc.net/problem/1753
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1753_최단경로 {
    static class Node implements Comparable<Node>{
        int end;
        int weight;

        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    static List<Node>[] list;
    static int[] dist;

    private static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        dist[start] = 0;

        boolean[] check = new boolean[list.length];

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if(check[cur.end]) continue;
            check[cur.end] = true;

            for(Node next : list[cur.end]){
                if(dist[next.end] >= dist[cur.end]+next.weight){
                    dist[next.end] = dist[cur.end]+next.weight;
                    pq.add(new Node(next.end,dist[next.end]));
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        list = new ArrayList[V+1];
        for(int i=1; i<=V; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v,w));
        }

        dist = new int[V+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=V; i++){
            if(dist[i] != Integer.MAX_VALUE)
                sb.append(dist[i]).append("\n");
            else
                sb.append("INF\n");
        }
        System.out.println(sb);
    }
}
