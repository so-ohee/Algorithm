package me.algo.BaekJoon.Math;

/* 최대공약수와 최소공배수
 * 2021. 04. 05
 * https://www.acmicpc.net/problem/2609
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2609_최대공약수와최소공배수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int min = gcd(A,B);
        System.out.println(min);
        System.out.println(A*B/min);
    }
    private static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
