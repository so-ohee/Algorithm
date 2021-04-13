package me.algo.BaekJoon.Math;

/* 조합 0의 개수
 * 2021. 04. 13
 * https://www.acmicpc.net/problem/2004
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2004_조합0의개수 {
    private static long solution(int num, int a){
        long count = 0;
        for(long i=a; i<=num; i*=a){
            count += num/i;
        }
        return count;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long five = solution(n,5)-solution((n-m),5)-solution(m,5);
        long two = solution(n,2)-solution((n-m),2)-solution(m,2);

        System.out.println(Math.min(five,two));
    }
}
