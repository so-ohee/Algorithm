package me.algo.Programmers.level2;

/* 삼각 달팽이
 * 2020. 11. 20
 * https://programmers.co.kr/learn/courses/30/lessons/68645
 */

import java.util.Arrays;

public class M_68645_삼각달팽이 {
    public static int[] solution(int n) {
        int[][] temp = new int[n][n];
        int num = 0, x=-1, y=0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(i%3==0)
                    x++;
                else if(i%3==1)
                    y++;
                else{
                    x--;
                    y--;
                }
                temp[x][y]=++num;
            }
        }
        int[] answer = new int[num]; //new int[n*(n+1)/2]
        int index = 0;
        for(int i=0; i<temp.length; i++){
            for(int value : temp[i]){
                if(value!=0) answer[index++] = value;
                else break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4)));
        System.out.println(Arrays.toString(solution(5)));
        System.out.println(Arrays.toString(solution(6)));
    }
}
