package me.algo.BaekJoon;

/* 연산자 끼워넣기 (2)
 * 2021. 03. 01
 * https://www.acmicpc.net/problem/15658
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15658_연산자끼워넣기2 {
    static int N;
    static int[] arr;
    static int[] operator = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    private static void dfs(int num, int index){
        if(index==N){
            max = Math.max(max,num);
            min = Math.min(min,num);
            return;
        }
        for(int i=0; i<4; i++){
            if(operator[i]!=0){
                operator[i]--;
                switch (i){
                    case 0:
                        dfs(num+arr[index],index+1);
                        break;
                    case 1:
                        dfs(num-arr[index],index+1);
                        break;
                    case 2:
                        dfs(num*arr[index],index+1);
                        break;
                    case 3:
                        dfs(num/arr[index],index+1);
                        break;
                }
                operator[i]++;
            }

        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }
        dfs(arr[0],1);
        System.out.println(max+"\n"+min);
    }
}
