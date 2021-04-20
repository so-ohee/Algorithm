package me.algo.BaekJoon.Tree;

/* 우주신과의 교감
 * 2021. 04. 21
 * https://www.acmicpc.net/problem/1774
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1774_우주신과의교감 {
    static class Point{
        int n,x,y;
        Point(int n, int x, int y){
            this.n=n;
            this.x=x;
            this.y=y;
        }
    }
    static class Edge implements Comparable<Edge>{
        int x, y;
        double w;
        Edge(int x, int y, double w){
            this.x=x;
            this.y=y;
            this.w=w;

        }
        @Override
        public int compareTo(Edge o) {
            return w < o.w ? -1 : 1;
        }
    }

    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }

        Point[] points = new Point[N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points[i] = new Point(i,x,y);
        }


        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a,b);
        }

        for(int i=1; i<N; i++){
            for(int j=i+1; j<=N; j++){
                pq.add(new Edge(points[i].n,points[j].n,distance(points[i],points[j])));
            }
        }

        double answer = 0;
        int count = 0;
        while (!pq.isEmpty()){
            Edge e = pq.poll();

            if(find(e.x)==find(e.y)) continue;

            union(e.x,e.y);
            answer += e.w;
            count++;

            if(count==N-1) break;
        }
        System.out.println(String.format("%.2f",answer));
    }
    private static int find(int x){
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    private static void union(int x,int y){
        x = find(x);
        y = find(y);
        if(x!=y) parent[y] = x;
    }
    private static double distance(Point a, Point b){
        return Math.sqrt(Math.pow(a.x-b.x,2)+Math.pow(a.y-b.y,2));
    }
}
