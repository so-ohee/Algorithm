package me.algo.Programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 이진 변환 반복하기
 * 2020. 11. 06
 * https://programmers.co.kr/learn/courses/30/lessons/70129
 */

public class M_70129_이진변환반복하기 {
    public static int[] solution(String s) {
        int[] answer = new int[2];

        while (s.length()!=1){
            answer[0]++;
            List<Integer> list = new ArrayList<>();
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='0')
                    answer[1]++;
                else
                    list.add(1);
            }
            s = Integer.toBinaryString(list.size());
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("110010101001"))); //[3,8]
        System.out.println(Arrays.toString(solution("01110"))); //[3,3]
        System.out.println(Arrays.toString(solution("1111111"))); //[4,1]
    }
}
