package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 회의실 배정
 * 2021. 01. 20
 * https://www.acmicpc.net/problem/1931
 */

public class Main_1931_회의실배정 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time,(int[] o1, int[] o2)-> o1[1]==o2[1] ? o1[0]-o2[0] : o1[1]-o2[1]);

        int earliest = 0;
        int count =0;
        for(int i=0; i<N; i++){
            if(earliest <= time[i][0]){
                earliest = time[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
