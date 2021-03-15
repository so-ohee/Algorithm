package me.algo.BaekJoon;

/* 잃어버린 괄호
 * 2021. 03. 15
 * https://www.acmicpc.net/problem/1541
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1541_잃어버린괄호 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("-");

        int answer=0;
        for (int i=0; i<arr.length; i++){
            String[] temp = arr[i].split("\\+");
            int sum = 0;
            for (String j: temp){
                sum+=Integer.parseInt(j);
            }

            if(i==0) answer = sum;
            else answer -= sum;
        }

        System.out.println(answer);
    }
}
