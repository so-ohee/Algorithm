package me.algo.LeetCode;

/* 1314. Matrix Block Sum
 * 2021. 01. 17
 * https://leetcode.com/problems/matrix-block-sum/
 */

public class L_1314 {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] answer = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int sum=0;
                for(int r=Math.max(0,i-K); r<Math.min(m,i+K+1); r++){
                    for(int c=Math.max(0,j-K); c<Math.min(n,j+K+1); c++){
                        sum += mat[r][c];
                    }
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}
