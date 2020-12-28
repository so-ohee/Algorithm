package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/* 듣보잡
 * 2020. 12. 28
 * https://www.acmicpc.net/problem/1764
 */

public class Main_1764_듣보잡 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //듣도 못한 사람 수
        int M = Integer.parseInt(st.nextToken()); //보도 못한 사람 수

        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>();
        for(int i=0; i<M; i++){
            String name = br.readLine();
            if(set.contains(name))
                list.add(name);
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(String i : list){
            bw.write(i+"\n");
        }
        bw.close();
    }
}
