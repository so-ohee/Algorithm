package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/* x보다 작은 수
 * 2020. 11. 26
 * https://www.acmicpc.net/problem/10871
 */

public class Main_10871_x보다작은수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            int a = Integer.parseInt(st.nextToken());
            if(a<x)
                sb.append(a+" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
