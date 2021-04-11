package me.algo.BaekJoon.Math;

/* 링
 * 2021. 04. 12
 * https://www.acmicpc.net/problem/3036
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3036_링 {
    private static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N-1];
        int first = Integer.parseInt(st.nextToken());
        for(int i=0; i<N-1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N-1; i++){
            int n = gcd(first,arr[i]);
            sb.append(first/n).append("/").append(arr[i]/n)
                    .append("\n");
        }
        System.out.println(sb);
    }
}
