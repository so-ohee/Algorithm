package me.algo.BaekJoon.BinarySearch;

/* 가장 긴 증가하는 부분 수열2
 * 2021. 03. 23
 * https://www.acmicpc.net/problem/12015
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_12015_가장긴증가하는부분수열2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(st.nextToken()));
        while (N-- > 1){
            int n = Integer.parseInt(st.nextToken());
            boolean change = false;
            for(int j=0; j<list.size(); j++){
                if(list.get(j)<n) continue;
                list.set(j,n);
                change = true;
                break;
            }
            if(!change) list.add(n);
        }
        System.out.println(list.size());
    }
}
