package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/* 분해합
 * 2021. 02. 16
 * https://www.acmicpc.net/problem/2231
 */

public class Main_2231_분해합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int size = String.valueOf(N).length();
        int answer = 0;
        for(int i = N-(size*9); i<=N; i++){
            int sum = i;
            char[] arr = String.valueOf(i).toCharArray();
            for(char j : arr){
                sum += Character.getNumericValue(j);
            }
            if(sum==N) {
                answer = sum;
                break;
            }
        }
        System.out.println(answer);
    }
}
