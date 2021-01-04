package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 수들의 합 2
 * 2021. 01. 04
 * https://www.acmicpc.net/problem/2003
 */

public class Main_2003_수들의합2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0, sum = arr[0];
        for (int left=0,right=0; right < N;) {
            if(sum > M) sum-=arr[left++];
            else if(sum < M){
                right++;
                if(right<N) sum+=arr[right];
            }else {
                count++;
                right++;
                if(right<N) sum+=arr[right];
            }
        }
        System.out.println(count);
    }
}
