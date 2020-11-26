package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* A/B
 * 2020. 11. 26
 * https://www.acmicpc.net/problem/1008
 */

public class Main_1008_A나누기B {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println(Double.parseDouble(st.nextToken())/Double.parseDouble(st.nextToken()));
    }
}
