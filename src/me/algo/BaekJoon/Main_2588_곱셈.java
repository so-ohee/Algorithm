package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 곱셈
 * 2020. 11. 26
 * https://www.acmicpc.net/problem/2588
 */

public class Main_2588_곱셈 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String b = br.readLine();
        for(int i=b.length()-1; i>-1; i--){
            System.out.println(a*Integer.parseInt(String.valueOf(b.charAt(i))));
        }
        System.out.println(a*Integer.parseInt(b));
    }
}
