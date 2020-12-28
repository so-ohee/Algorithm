package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/* 단어 정렬
 * 2020. 12. 28
 * https://www.acmicpc.net/problem/1181
 */

public class Main_1181_단어정렬 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>(set);
        Collections.sort(list, new Comparator<String>() {
           @Override
            public int compare(String o1, String o2){
                if(o1.length()==o2.length()){
                   return o1.compareTo(o2);
                }else{
                    return o1.length()-o2.length();
                }
            }
        });

        for(String i : list){
            bw.write(i+"\n");
        }
        bw.close();
    }
}
