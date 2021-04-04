package me.algo.BaekJoon.Implementation;

/* 배수와 약수
 * 2021. 04. 05
 * https://www.acmicpc.net/problem/5086
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_5086_배수와약수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if(A==0 && B==0) break;
            if(B%A==0) bw.write("factor\n");
            else if(A%B==0) bw.write( "multiple\n");
            else bw.write("neither\n");
        }
        bw.close();
    }
}
