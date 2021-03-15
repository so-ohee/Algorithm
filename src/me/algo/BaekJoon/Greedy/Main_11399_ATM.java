package me.algo.BaekJoon.Greedy;

/* ATM
 * 2021. 03. 15
 * https://www.acmicpc.net/problem/11399
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11399_ATM {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int answer = arr[0];
        for(int i=1; i<N; i++){
            arr[i] += arr[i-1];
            answer += arr[i];
        }

        System.out.println(answer);
    }
}
