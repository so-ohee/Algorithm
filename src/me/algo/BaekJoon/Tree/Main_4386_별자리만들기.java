package me.algo.BaekJoon.Tree;

/* 별자리 만들기
 * 2021. 04. 19
 * https://www.acmicpc.net/problem/4386
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_4386_별자리만들기 {
    static class Point{
        int num;
        double x, y;
        Point(int num, double x, double y){
            this.num = num;
            this.x = x;
            this.y = y;
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
            return (int) (w-o.w);
        }
    }

    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int[] parent;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        Point[] points = new Point[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            points[i] = new Point(i,x,y);
        }

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                double w = Math.sqrt(Math.pow(points[i].x-points[j].x,2)+Math.pow(points[i].y-points[j].y,2));
                pq.add(new Edge(points[i].num,points[j].num,w));
            }
        }

        double answer = 0;
        int count = 0;
        while (!pq.isEmpty()){
            Edge e = pq.poll();

            if(find(e.x)==find(e.y)) continue;

            union(e.x, e.y);
            answer += e.w;
            count++;

            if(count==n-1) break;
        }
        System.out.println(String.format("%.2f",answer));
    }
    private static int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    private static void union(int x,int y){
        x = find(x);
        y = find(y);
        if(x!=y) parent[y] = x;
    }
}