package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 연속합
 * 2021. 02. 05
 * https://www.acmicpc.net/problem/1912
 */

public class Main_1912_연속합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(i!=0 && arr[i-1]>0 && arr[i]+arr[i-1]>0){
                arr[i] += arr[i-1];
            }
            if(max < arr[i]) max= arr[i];
        }
        System.out.println(max);
    }
}
