package me.algo.BaekJoon.Tree;

/* Numbers On a Tree
 * 2021. 04. 10
 * https://www.acmicpc.net/problem/11203
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11203_NumbersOnATree {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        String s = "";
        if(st.hasMoreTokens()) s = st.nextToken();

        int N = (1 << (H + 1));
        if(s.isEmpty()) System.out.println(N-1);
        else {
            int index = 1;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == 'L')
                    index *= 2;
                else
                    index = index * 2 + 1;
            }
            System.out.println(N - index);
        }
    }
}
