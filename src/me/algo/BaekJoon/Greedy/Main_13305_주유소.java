package me.algo.BaekJoon.Greedy;

/* 주유소
 * 2021. 03. 15
 * https://www.acmicpc.net/problem/13305
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13305_주유소 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] distance = new long[n-1];
        for(int i=0; i<n-1; i++){
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        long[] oil = new long[n-1];
        for(int i=0; i<n-1; i++){
            oil[i]=Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        long min = oil[0];
        for(int i=0; i<n-1; i++){
            if(oil[i]<min)
                min = oil[i];

            answer += (min*distance[i]);
        }
        System.out.println(answer);
    }
}