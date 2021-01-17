package me.algo.LeetCode;

/* 1277. Count Square Submatrices with All Ones
 * 2021. 01. 17
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 */

public class L_1277 {
    public static int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int answer = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if((i!=0 && j!=0) && matrix[i][j]==1){
                    matrix[i][j] = Math.min(matrix[i-1][j-1],Math.min(matrix[i-1][j],matrix[i][j-1]))+1;
                }
                answer += matrix[i][j];
            }
        }
        return answer;
    }
}
