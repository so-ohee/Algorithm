package me.algo.BaekJoon;

/* 동전 0
 * 2021. 01. 20
 * https://www.acmicpc.net/problem/11047
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11047_동전0 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count=0;
        for(int i=N-1; i>-1; i--){
            if (K>=arr[i]){
                count += K/arr[i];
                K %= arr[i];
            }
        }
        System.out.println(count);
    }
}
