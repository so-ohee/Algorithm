package me.algo.BaekJoon.Math;

/* 패션왕 신해빈
 * 2021. 04. 13
 * https://www.acmicpc.net/problem/9375
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_9375_패션왕신해빈 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            Map<String, Integer> map = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String kind = st.nextToken();

                map.put(kind, map.getOrDefault(kind,1)+1);
            }
            int answer = 1;
            for(int value : map.values())
                answer *= value;
            sb.append(answer-1).append("\n");
        }
        System.out.println(sb);
    }
}
