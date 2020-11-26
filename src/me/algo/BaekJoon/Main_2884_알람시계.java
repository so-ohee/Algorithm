package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.StringTokenizer;

/* 알람 시계
 * 2020. 11. 26
 * https://www.acmicpc.net/problem/2884
 */

public class Main_2884_알람시계 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LocalTime time = LocalTime.of(H,M);
        time = time.minusMinutes(45);

        System.out.println(time.getHour()+" "+time.getMinute());
    }
}
