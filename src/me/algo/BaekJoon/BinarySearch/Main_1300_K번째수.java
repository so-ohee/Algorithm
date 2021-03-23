package me.algo.BaekJoon.BinarySearch;

/* K번째 수
 * 2021. 03. 23
 * https://www.acmicpc.net/problem/1300
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1300_K번째수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long min = 1, max = K;
        long answer = 0;
        while (max>=min){
            long mid = (min+max)/2;
            long count = 0;
            for(int i=1; i<=N; i++){
                count += Math.min(mid/i,N);
            }

            if(count<K){
                min = mid + 1;
            }else {
                answer = mid;
                max = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
