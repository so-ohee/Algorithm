package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* LCS
 * 2021. 02. 04
 * https://www.acmicpc.net/problem/9251
 */

public class Main_9251_LCS {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arrA = br.readLine().toCharArray();
        char[] arrB = br.readLine().toCharArray();

        int [][] LCS = new int[arrA.length+1][arrB.length+1];
        for(int i=1; i<=arrA.length; i++){
            for(int j=1; j<=arrB.length; j++){
                if(arrA[i-1]==arrB[j-1])
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                else
                    LCS[i][j] = Math.max(LCS[i-1][j],LCS[i][j-1]);
            }
        }
        System.out.println(LCS[arrA.length][arrB.length]);
    }
}
