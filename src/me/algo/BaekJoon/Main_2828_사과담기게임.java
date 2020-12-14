package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 사과 담기 게임
 * 2020. 12. 14
 * https://www.acmicpc.net/problem/2828
 */

public class Main_2828_사과담기게임 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());

        int answer = 0;
        int[] now = {1,m};
        for(int i=0; i<j; i++) {
            int position = Integer.parseInt(br.readLine());
            if(now[1] < position) {
                answer += position - now[1];
                now[0] += position - now[1];
                now[1] += position - now[1];
            }else if(now[0] > position) {
                answer += now[0] - position;
                now[1] -= now[0] - position;
                now[0] -= now[0] - position;
            }
        }
        System.out.println(answer);
    }
}