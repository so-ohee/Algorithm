package me.algo.BaekJoon.Math;

/* 최소공배수
 * 2021. 04. 05
 * https://www.acmicpc.net/problem/1934
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1934_최소공배수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int min = gcd(A,B);
            sb.append(A*B/min).append("\n");
        }
        System.out.println(sb);
    }
    private static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
