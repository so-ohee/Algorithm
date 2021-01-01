package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2108_통계학 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Map<Integer,Integer> map = new LinkedHashMap<>();
        double avg = 0;
        int max = 0;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            avg += arr[i];
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            if(max<map.get(arr[i])) max = map.get(arr[i]);
        }
        Arrays.sort(arr);

        //산술 평균
        System.out.println(Math.round(avg/N));
        //중앙값
        System.out.println(arr[N/2]);
        //최빈값
        List<Integer> list =new ArrayList<>();
        for(Integer key : map.keySet()){
            if(map.get(key)==max){
                list.add(key);
            }
        }
        if(list.size()==1)
            System.out.println(list.get(0));
        else {
            Collections.sort(list);
            System.out.println(list.get(1));
        }
        //범위
        System.out.println(arr[arr.length-1]-arr[0]);
    }
}
