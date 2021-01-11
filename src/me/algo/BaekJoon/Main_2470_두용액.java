package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 두 용액
 * 2021. 01. 11
 * https://www.acmicpc.net/problem/2470
 */

public class Main_2470_두용액 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(o1,o2)->Math.abs(o1)-Math.abs(o2));
        int min = Integer.MAX_VALUE;
        int s=0, r=0;
        for(int i=0; i<n-1; i++){
            int temp = Math.abs(arr[i]+arr[i+1]);
            if(temp<min){
                min = temp;
                s=Math.min(arr[i],arr[i+1]);
                r=Math.max(arr[i],arr[i+1]);
            }
        }
        System.out.println(s+" "+r);
    }
}
