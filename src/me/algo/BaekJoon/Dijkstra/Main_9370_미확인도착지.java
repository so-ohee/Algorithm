package me.algo.BaekJoon.Dijkstra;

/* 미확인 도착지
 * 2021. 04. 07
 * https://www.acmicpc.net/problem/9370
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_9370_미확인도착지 {
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
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            list = new ArrayList[n+1];
            for(int i=1; i<=n; i++){
                list[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                if((a==g && b==h) || (a==h && b==g)){
                    list[a].add(new Node(b,d*2-1));
                    list[b].add(new Node(a,d*2-1));
                }else{
                    list[a].add(new Node(b,d*2));
                    list[b].add(new Node(a,d*2));
                }
            }

            List<Integer> candidate = new ArrayList<>();
            for(int i=0; i<t; i++){
                candidate.add(Integer.parseInt(br.readLine()));
            }

            dijkstra(s);

            Collections.sort(candidate);
            for(int i : candidate){
                if(dist[i]%2==1)
                    sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));

        dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE/2*2);
        dist[start] = 0;

        boolean[] check = new boolean[n+1];

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if(check[cur.end]) continue;
            check[cur.end] = true;

            for(Node next : list[cur.end]){
                if(!check[next.end] && dist[next.end]>dist[cur.end]+next.weight){
                    dist[next.end] = dist[cur.end]+next.weight;
                    pq.add(new Node(next.end,dist[next.end]));
                }
            }
        }
    }
}
