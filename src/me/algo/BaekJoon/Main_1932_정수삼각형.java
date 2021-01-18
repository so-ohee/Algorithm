package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 정수 삼각형
 * 2021. 01. 18
 * https://www.acmicpc.net/problem/1932
 */


public class Main_1932_정수삼각형 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= n-(n-i); j++) {
                if(j==0) arr[i][j] += arr[i-1][j];
                else if(j==n-(n-i)) arr[i][j] += arr[i-1][j-1];
                else arr[i][j] += Math.max(arr[i-1][j-1],arr[i-1][j]);

                if(i==n-1 && max<arr[i][j]){
                    max = arr[i][j];
                }
            }
        }
        System.out.println(max);
    }
}
