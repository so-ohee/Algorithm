package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 소수의 연속합
 * 2021. 01. 04
 * https://www.acmicpc.net/problem/1644
 */

public class Main_1644_소수의연속합 {
    static int N;
    static List<Integer> list = new ArrayList<>();

    private static void isPrime() {
        boolean[] check = new boolean[N + 1];
        check[0] = check[1] = true;

        int sqrt = (int) Math.sqrt(N);
        for (int i = 2; i <= sqrt; i++) {
            if (!check[i]) {
                for (int j = i * i; j <= N; j += i) {
                    check[j] = true;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            if (!check[i]) list.add(i);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (N == 1) System.out.println(0);
        else {
            isPrime();

            int count = 0, sum = list.get(0);
            for (int left = 0, right = 0; right < list.size(); ) {
                if (sum > N) sum -= list.get(left++);
                else if (sum < N) {
                    right++;
                    if (right < list.size()) sum += list.get(right);
                } else {
                    count++;
                    right++;
                    if (right < list.size()) sum += list.get(right);
                }
            }
            System.out.println(count);
        }
    }
}