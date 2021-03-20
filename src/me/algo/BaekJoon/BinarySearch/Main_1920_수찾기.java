package me.algo.BaekJoon.BinarySearch;

/* 수 찾기
 * 2021. 03. 21
 * https://www.acmicpc.net/problem/1920
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1920_수찾기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer,Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            map.put(Integer.parseInt(st.nextToken()),0);
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            if(map.containsKey(Integer.parseInt(st.nextToken())))
                sb.append(1+"\n");
            else
                sb.append(0+"\n");
        }
        System.out.println(sb);
    }
}
