package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1966_프린터큐 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        for (int i = 0; i < length; i++) {
            String[] nm = br.readLine().split(" ");
            int n = Integer.parseInt(nm[0]), m = Integer.parseInt(nm[1]);
            int count = 0;
            Queue<int[]> queue = new LinkedList<>();
            String[] important = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                queue.add(new int[]{j, Integer.parseInt(important[j])});
            }
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                boolean checkMax = true;
                for (int[] q : queue) {
                    if (q[1] > now[1]) {
                        checkMax = false;
                        break;
                    }
                }
                if (checkMax) {
                    count++;
                    if (now[0] == m) break;
                } else queue.add(now);
            }
            System.out.println(count);
        }
    }
}


