package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 사분면 고르기
 * 2020. 11. 26
 * https://www.acmicpc.net/problem/14681
 */

public class Main_14681_사분면고르기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        if(x>0){
            if(y>0) System.out.println(1);
            else System.out.println(4);
        }else{
            if(y>0) System.out.println(2);
            else System.out.println(3);
        }
    }
}
