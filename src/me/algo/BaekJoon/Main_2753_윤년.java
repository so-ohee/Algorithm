package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 윤년
 * 2020. 11. 26
 * https://www.acmicpc.net/problem/2753
 */

public class Main_2753_윤년 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());
        if((year%4==0&&year%100!=0) || year%400==0)
            System.out.println(1);
        else System.out.println(0);
    }
}
