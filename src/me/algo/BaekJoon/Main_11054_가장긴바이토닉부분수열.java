package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 가장 긴 바이토닉 부분 수열
 * 2021. 02. 04
 * https://www.acmicpc.net/problem/11054
 */

public class Main_11054_가장긴바이토닉부분수열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] leftArray = new int[n];
        leftArray[0] = 1;
        for(int i=1; i<n; i++){
            leftArray[i]=1;
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i] && leftArray[i]<=leftArray[j])
                    leftArray[i]++;
            }
        }

        int[] rightArray = new int[n];
        rightArray[n-1]=1;
        for(int i=n-2; i>-1; i--){
            rightArray[i]=1;
            for(int j=n-1; j>i; j--){
                if(arr[j]<arr[i] && rightArray[i]<=rightArray[j])
                    rightArray[i]++;
            }
        }

        int max = 0;
        for(int i=0; i<n; i++){
            arr[i] = leftArray[i]+rightArray[i];
            if(max<arr[i]) max = arr[i];
        }
        System.out.println(max-1);
    }
}
