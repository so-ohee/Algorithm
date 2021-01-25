package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 01타일
 * 2021. 01. 25
 * https://www.acmicpc.net/problem/1904
 * 메모리: 41908KB | 시간: 240ms
 */
//public class Main_1904_01타일 {
//    static int[] dp;
//    private static int solution(int N){
//        if(dp[N] != 0) return dp[N];
//        return dp[N] = (solution(N-2)+solution(N-1))%15746;
//    }
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        dp = new int[N+1];
//        dp[1] = 1;
//        if(N>1) dp[2] = 2;
//        System.out.println(solution(N));
//    }
//}


/* 01타일
 * 2021. 01. 18
 * https://www.acmicpc.net/problem/1904
 * 메모리: 18388KB | 시간: 148ms
 */
public class Main_1904_01타일 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n == 1) System.out.println(1);
        else {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for(int i=3; i<=n; i++){
                dp[i] = (dp[i-2]+dp[i-1])%15746;
            }
            System.out.println(dp[n]);
        }
    }
}
