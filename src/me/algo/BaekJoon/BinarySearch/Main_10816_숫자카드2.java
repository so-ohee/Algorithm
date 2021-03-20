package me.algo.BaekJoon.BinarySearch;

/* 숫자 카드 2
 * 2021. 03. 21
 * https://www.acmicpc.net/problem/10816
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_10816_숫자카드2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer,Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            int n = Integer.parseInt(st.nextToken());
            map.put(n,map.getOrDefault(n,0)+1);
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int m = Integer.parseInt(st.nextToken());
            if(map.containsKey(m))
                sb.append(map.get(m)+" ");
            else
                sb.append("0 ");
        }
        System.out.println(sb);
    }
}
