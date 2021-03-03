package me.algo.BaekJoon;

/* N과 M (9)
 * 2021. 03. 03
 * https://www.acmicpc.net/problem/15663
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_15663_N과M_9 {
    static int N, M;
    static int[] arr;
    static int[] answer;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    private static void dfs(int count) {
        if (count == M) {
            for (int a : answer)
                sb.append(a).append(' ');
            sb.append("\n");
            return;
        }
        int temp = 0;
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                if(temp == arr[i]) continue;
                visit[i] = true;
                answer[count] = arr[i];
                dfs(count + 1);
                visit[i] = false;
                temp = arr[i];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        answer = new int[M];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0);
        System.out.println(sb);
    }
}