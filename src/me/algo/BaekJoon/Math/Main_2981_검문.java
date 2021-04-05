package me.algo.BaekJoon.Math;

/* 검문
 * 2021. 04. 05
 * https://www.acmicpc.net/problem/2981
 */

/*
* 문제: arr[0]%M = arr[1]%M = arr[2]%M
* 풀이:
* arr[0]%M = arr[0]-(arr[0]/M)*M
* arr[1]%M = arr[1]-(arr[1]/M)*M
* arr[2]%M = arr[2]-(arr[2]/M)*M
*
* arr[0]-((arr[0]/M)*M) = arr[1]-((arr[1]/M)*M)
* arr[0]-arr[1] = ((arr[0]/M)-(arr[1]/M))*M
* (arr[0]-arr[1])/M = (arr[0]/M)-(arr[1]/M)
*
* 즉, (arr[0]-arr[1])/M = (arr[1]-arr[2])/M
* M은 (arr[0]-arr[1])와 (arr[1]-arr[2])의 공약수
* 따라서 최대공약수를 찾고, 최대공약수와 그의 약수를 구하면 됨.
* */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2981_검문 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int val = arr[1]-arr[0];
        for(int i=2; i<N; i++){
            val = gcd(val,(arr[i]-arr[i-1]));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<=val; i++) {
            if (val % i == 0)
                sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
    private static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
