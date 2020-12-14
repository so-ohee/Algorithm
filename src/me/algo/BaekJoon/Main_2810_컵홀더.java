package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 컵홀더
 * 2020. 12. 14
 * https://www.acmicpc.net/problem/2810
 */

public class Main_2810_컵홀더 {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int count = 1;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='L') i++;
            count++;
        }
        if(count>n) System.out.println(n);
        else System.out.println(count);
    }
}
