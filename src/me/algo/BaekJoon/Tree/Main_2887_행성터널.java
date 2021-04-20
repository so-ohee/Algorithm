package me.algo.BaekJoon.Tree;

/* 행성 터널
 * 2021. 04. 21
 * https://www.acmicpc.net/problem/2887
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2887_행성터널 {
    static class Point{
        int n,x,y,z;
        Point(int n, int x, int y, int z){
            this.n = n;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    static class Edge implements Comparable<Edge>{
        int x,y,w;
        Edge(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o) {
            return w-o.w;
        }
    }

    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        parent = new int[N];
        for(int i=0; i<N; i++){
            parent[i] = i;
        }

        Point[] points = new Point[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            points[i] = new Point(i,x,y,z);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        Arrays.sort(points,(o1,o2)->o1.x-o2.x);
        for(int i=0; i<N-1; i++){
            pq.add(new Edge(points[i].n,points[i+1].n,Math.abs(points[i].x-points[i+1].x)));
        }

        Arrays.sort(points,(o1,o2)->o1.y-o2.y);
        for(int i=0; i<N-1; i++){
            pq.add(new Edge(points[i].n,points[i+1].n,Math.abs(points[i].y-points[i+1].y)));
        }

        Arrays.sort(points,(o1,o2)->o1.z-o2.z);
        for(int i=0; i<N-1; i++){
            pq.add(new Edge(points[i].n,points[i+1].n,Math.abs(points[i].z-points[i+1].z)));
        }

        int answer = 0, count = 0;
        while (!pq.isEmpty()){
            Edge e = pq.poll();

            if(find(e.x)==find(e.y)) continue;

            union(e.x,e.y);
            answer+=e.w;
            count++;
            
            if(count == N-1) break;
        }
        System.out.println(answer);
    }
    private static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    private static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x!=y) parent[y] = x;
    }
}
