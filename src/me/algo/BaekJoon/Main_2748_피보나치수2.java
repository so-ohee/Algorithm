package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 피보나치 수 2
 * 2020. 11. 20
 * https://www.acmicpc.net/problem/2748
 */

public class Main_2748_피보나치수2 {
    static long d[] = new long[91];
    public static long fibonacci(int n){
        if(n==0) return 0;
        else if(n==1) return 1;

        if(d[n]!=0) return d[n];
        return d[n] = fibonacci(n-1)+fibonacci(n-2);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(fibonacci(n));
    }
}
