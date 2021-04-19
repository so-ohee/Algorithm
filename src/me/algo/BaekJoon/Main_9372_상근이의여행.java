package me.algo.BaekJoon;

/* 상근이의 여행
 * 2021. 04. 19
 * https://www.acmicpc.net/problem/9372
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9372_상근이의여행 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            while (M-- > 0) {
                br.readLine();
            }
            sb.append(N-1).append("\n");
        }
        System.out.println(sb);
    }
}
