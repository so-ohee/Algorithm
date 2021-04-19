package me.algo.BaekJoon.Tree;

/* 최소 스패닝 트리
 * 2021. 04. 19
 * https://www.acmicpc.net/problem/1197
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1197_최소스패닝트리 {
    static class Kruskal implements Comparable<Kruskal>{
        int start;
        int end;
        int weight;

        public Kruskal(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Kruskal o) {
            return this.weight-o.weight;
        }
    }

    static PriorityQueue<Kruskal> pq = new PriorityQueue<>();
    static int[] parent;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        for(int i=1; i<=V; i++){
            parent[i] = i;
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.add(new Kruskal(a,b,c));
        }

        int result = 0, count = 0;
        for(int i=0; i<E; i++){
            Kruskal k = pq.poll();
            if(find(k.start) == find(k.end)) continue;

            union(k.start,k.end);
            result += k.weight;
            count++;

            if(count==V-1) break;
        }
        System.out.println(result);
    }

    private static int find(int v){
        if(v == parent[v]) return v;
        return parent[v] = find(parent[v]);
    }

    private static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b) parent[a] = b;
    }
}
