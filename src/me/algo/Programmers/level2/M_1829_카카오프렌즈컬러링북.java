package me.algo.Programmers.level2;

import java.util.Arrays;

/* 카카오프렌즈컬러링북
 * 2020. 11. 09
 * https://programmers.co.kr/learn/courses/30/lessons/1829
 */

public class M_1829_카카오프렌즈컬러링북 {
    public static int[] solution(int m, int n, int[][] picture) {
        long[][] p = new long[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                p[i][j] = picture[i][j];
            }
        }

        int max = 0;
        int[] answer = new int[2];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if (p[i][j] != 0) {
                    int temp = dfs(i, j, p, p[i][j]);
                    if(temp!=0){
                        answer[0]++;
                        max =  Math.max(max,temp);
                    }
                }
            }
        }
        answer[1] = max;
        return answer;
    }
    public static int dfs(int x, int y, long[][] p, long n) {
        if (x < 0 || x >= p.length || y < 0 || y >= p[0].length) return 0;
        System.out.println(p[x][y]+" "+n);
        if (p[x][y] == 0 || p[x][y]!=n) return 0;

        p[x][y] = 0;
        return 1 + dfs(x - 1, y, p, n) + dfs(x + 1, y, p, n) + dfs(x, y - 1, p, n) + dfs(x, y + 1, p, n);
    }

    public static void main(String[] args) {
        int[][] p = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        System.out.println(Arrays.toString(solution(6,4, p))); //[4, 5]
    }
}
