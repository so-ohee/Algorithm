package me.algo.BaekJoon;

/* RGB거리
 * 2021. 01. 18
 * https://www.acmicpc.net/problem/1149
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_RGB거리 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[3];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            if(i==0){
                arr[0] = Integer.parseInt(st.nextToken());
                arr[1] = Integer.parseInt(st.nextToken());
                arr[2] = Integer.parseInt(st.nextToken());
            }else{
                int a=arr[0], b=arr[1];
                arr[0] = Math.min(b,arr[2])+Integer.parseInt(st.nextToken());
                arr[1] = Math.min(a,arr[2])+Integer.parseInt(st.nextToken());
                arr[2] = Math.min(a,b)+Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(Math.min(arr[0],Math.min(arr[1],arr[2])));
    }
}
