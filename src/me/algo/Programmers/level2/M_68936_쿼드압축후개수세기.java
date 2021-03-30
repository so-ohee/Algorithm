package me.algo.Programmers.level2;

/* 쿼드압축 후 개수 세기
 * 2021. 03. 30
 * https://programmers.co.kr/learn/courses/30/lessons/68936
 */

public class M_68936_쿼드압축후개수세기 {
    static int[][] array;
    static int[] answer = new int[2];

    private static void dfs(int x, int y, int size) {
        boolean zero = false;
        boolean one = false;

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (array[i][j] == 0) zero = true;
                if (array[i][j] == 1) one = true;
            }
        }

        if (zero && !one) {
            answer[0]++;
            return;
        }
        if (!zero && one) {
            answer[1]++;
            return;
        }

        dfs(x, y, size / 2);
        dfs(x, y + size / 2, size / 2);
        dfs(x + size / 2, y, size / 2);
        dfs(x + size / 2, y + size / 2, size / 2);
    }

    public static int[] solution(int[][] arr) {
        array = arr;
        dfs(0, 0, arr.length);
        return answer;
    }
}