package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 신입 사원
 * 2021. 01. 21
 * https://www.acmicpc.net/problem/1946
 */

public class Main_1946_신입사원 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+1];
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }
            int count = 1;
            int interviewRank = arr[1];
            for(int j=2; j<=N; j++){
                if(arr[j]<interviewRank) {
                    count++;
                    interviewRank = arr[j];
                }
            }
            System.out.println(count);
        }
    }
//    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        int T = Integer.parseInt(br.readLine());
//        for(int i=0; i<T; i++){
//            int N = Integer.parseInt(br.readLine());
//            int[][] arr = new int[N][2];
//            for(int j=0; j<N; j++){
//               st = new StringTokenizer(br.readLine());
//               arr[j][0] = Integer.parseInt(st.nextToken());
//               arr[j][1] = Integer.parseInt(st.nextToken());
//            }
//            Arrays.sort(arr, (int[] o1, int[] o2)->o1[0]-o2[0]);
//            int count = 1;
//            int interviewRank = arr[0][1];
//            for(int j=1; j<N; j++){
//                if(arr[j][1]<interviewRank) {
//                    count++;
//                    interviewRank = arr[j][1];
//                }
//            }
//            System.out.println(count);
//        }
//    }
}
