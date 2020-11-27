package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* 한수
 * 2020. 11. 27
 * https://www.acmicpc.net/problem/1065
 */

public class Main_1065_한수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()), k, han=0, a[] = new int[3];
        for (int i = 1; i <= n; i++) {
            if (0 < i && i < 100) han = i;
            else if (i == 1000) break;
            else {
                k = 0; int t = i;
                while (t > 0) {
                    a[k] = t % 10;
                    t /= 10; k++;
                }
                if (a[0] - a[1] == a[1] - a[2]) han++;
            }
        }
        bw.write(String.valueOf(han));
        bw.close();
    }
}

