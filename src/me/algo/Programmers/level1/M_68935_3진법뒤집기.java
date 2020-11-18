package me.algo.Programmers.level1;

/* 3진법 뒤집기
 * 2020. 11. 18
 * https://programmers.co.kr/learn/courses/30/lessons/68935
 */

public class M_68935_3진법뒤집기 {
    public static int solution(int n){
        int answer = 0;
        String s = Integer.toString(n,3);
        for(int i=0; i<s.length(); i++){
            answer += Integer.parseInt(String.valueOf(s.charAt(i)))*Math.pow(3,i);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(45));
        System.out.println(solution(125));
    }
}
