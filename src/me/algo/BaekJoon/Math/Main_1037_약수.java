package me.algo.BaekJoon.Math;

/* 약수
 * 2021. 04. 05
 * https://www.acmicpc.net/problem/1037
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1037_약수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[num];
        for(int i=0; i<num; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(arr[0]*arr[num-1]);
    }
}
