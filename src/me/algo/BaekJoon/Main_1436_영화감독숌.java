package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 영화감독 숌
 * 2021. 02. 16
 * https://www.acmicpc.net/problem/1436
 */

public class Main_1436_영화감독숌 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num = 666;
        int count = 1;
        while (count!=N){
            num++;
            if(String.valueOf(num).contains("666")) count++;
        }
        System.out.println(num);
    }
}
