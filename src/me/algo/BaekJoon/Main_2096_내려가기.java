package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/* 내려가기
 * 2021. 01. 06
 * https://www.acmicpc.net/problem/2096
 */

public class Main_2096_내려가기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] max = new int[3];
        int[] min = new int[3];

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(i==0){
                max[0]=min[0]=a;
                max[1]=min[1]=b;
                max[2]=min[2]=c;
            }else{
                //최댓값
                int max0=max[0], max2=max[2];
                max[0] = Math.max(max[0],max[1])+a;
                max[2] = Math.max(max[1],max[2])+c;
                max[1] = Math.max(Math.max(max0,max[1]),max2)+b;


                //최솟값
                int min0=min[0], min2=min[2];
                min[0] = Math.min(min[0],min[1])+a;
                min[2] = Math.min(min[1],min[2])+c;
                min[1] = Math.min(Math.min(min0,min[1]),min2)+b;
            }
        }
        bw.write(Math.max(Math.max(max[0],max[1]),max[2])+" ");
        bw.write(Math.min(Math.min(min[0],min[1]),min[2])+"\n");
        bw.close();
    }
}
