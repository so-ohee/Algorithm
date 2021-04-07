package me.algo.BaekJoon.Dijkstra;

/* 특정한 최단 경로
 * 2021. 04. 07
 * https://www.acmicpc.net/problem/1504
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1504_특정한최단경로 {
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
    static int N;
    static final int INF = 200000001;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        while (E-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        System.out.println(solution(1,v1,v2,N));
    }
    private static int solution(int start, int v1, int v2, int end){
        int dist1 = dijkstra(start,v1) + dijkstra(v1,v2) + dijkstra(v2,end);
        int dist2 = dijkstra(start,v2) + dijkstra(v2,v1) + dijkstra(v1,end);

        return (dist1>=INF && dist2>=INF) ? -1 : Math.min(dist1,dist2);
    }
    private static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));

        int[] dist = new int[N+1];
        Arrays.fill(dist,INF);
        dist[start] = 0;

        boolean[] check = new boolean[N+1];

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if(check[cur.end]) continue;
            check[cur.end] = true;

            for(Node next : list[cur.end]){
                if(dist[next.end] > dist[cur.end]+next.weight){
                    dist[next.end] = dist[cur.end]+next.weight;
                    pq.add(new Node(next.end,dist[next.end]));
                }
            }
        }
        return dist[end];
    }
}