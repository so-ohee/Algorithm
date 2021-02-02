package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/* 신나는 함수 실행
 * 2021. 01. 13
 * 2021. 02. 02
 * https://www.acmicpc.net/problem/9184
 */

public class Main_9184_신나는함수실행 {
    static int[][][] dp = new int[21][21][21];
    private static int w(int a, int b, int c){
        if(a<=0 || b<=0 || c<=0) return 1;
        if(a>20 || b>20 || c>20) return dp[20][20][20]=w(20,20,20);
        if(dp[a][b][c]!=0) return dp[a][b][c];
        if(a<b && b<c) return dp[a][b][c]=w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
        return dp[a][b][c]=w(a-1,b,c)+w(a-1,b-1,c)+w(a-1, b, c-1)-w(a-1, b-1, c-1);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int a, b, c;
        while (true){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(a==-1 && b==-1 && c==-1) break;
            bw.write("w("+a+", "+b+", "+c+") = "+w(a,b,c)+"\n");
        }
        bw.close();
    }
}