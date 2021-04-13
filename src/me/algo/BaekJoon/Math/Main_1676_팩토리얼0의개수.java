package me.algo.BaekJoon.Math;

/* 팩토리얼 0의 개수
 * 2021. 04. 13
 * https://www.acmicpc.net/problem/1676
 * 참고 : https://ksj14.tistory.com/entry/BackJoon1676-%ED%8C%A9%ED%86%A0%EB%A6%AC%EC%96%BC-0%EC%9D%98-%EA%B0%9C%EC%88%98
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1676_팩토리얼0의개수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=5; i<=n; i*=5) {
            count += n / i;
        }
        System.out.println(count);
    }
}
