package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 한수
 * 2020. 12. 14
 * https://www.acmicpc.net/problem/1065
 */

public class Main_1065_한수 {
    public static int hansu(int n) {
        if (n < 100) return n;
        else {
            int answer = 0;
            if (n == 1000) n = 999;
            for (int i = 100; i <= n; i++) {
                int a = i % 10;
                int b = (i / 10) % 10;
                int c = (i / 100) % 10;

                if (a - b == b - c) answer++;
            }
            return answer + 99;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(hansu(Integer.parseInt(br.readLine())));
    }
}