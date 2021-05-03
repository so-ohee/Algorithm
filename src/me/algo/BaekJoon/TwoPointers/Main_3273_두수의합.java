package me.algo.BaekJoon.TwoPointers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 두수의 합
 * 2021. 05. 03
 * 2021. 01. 10
 * https://www.acmicpc.net/problem/3273
 */

public class Main_3273_두수의합 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int x = Integer.parseInt(br.readLine());

        int count = 0, left=0, right=n-1;
        while (left<right){
            int sum = arr[left]+arr[right];
            if(sum==x) {
                count++;
                left++;
                right--;
            }else if(sum>x)
                right--;
            else
                left++;
        }
        System.out.println(count);
    }
}
