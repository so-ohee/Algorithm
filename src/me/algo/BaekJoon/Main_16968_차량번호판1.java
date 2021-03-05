package me.algo.BaekJoon;

/* 차량 번호판 1
 * 2021. 03. 05
 * https://www.acmicpc.net/problem/16968
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_16968_차량번호판1 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(i==0){
                if(arr[0].equals("d"))
                    count += 10;
                else
                    count += 26;
            }else if(arr[i].equals(arr[i-1])){
                if(arr[i].equals("d"))
                    count *= 9;
                else
                    count *= 25;
            }else{
                if(arr[i].equals("d"))
                    count *= 10;
                else
                    count *= 26;
            }
        }
        System.out.println(count);
    }
}
