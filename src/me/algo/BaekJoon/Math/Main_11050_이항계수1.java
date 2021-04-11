package me.algo.BaekJoon.Math;

/* 이항 계수 1
 * 2021. 04. 12
 * https://www.acmicpc.net/problem/11050
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11050_이항계수1 {
    private static int factorial(int N) {
        if (N <= 1)	return 1;
        return N * factorial(N - 1);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(factorial(N) / (factorial(N - K) * factorial(K)));
    }
}
