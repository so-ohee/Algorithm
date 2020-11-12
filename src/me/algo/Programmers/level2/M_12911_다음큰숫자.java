package me.algo.Programmers.level2;

public class M_12911_다음큰숫자 {
    public static int solution(int n) {
        int nCount = Integer.bitCount(n);
        int answer=n+1;
        while (nCount!=Integer.bitCount(answer)) answer++;
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(78)); //83
        System.out.println(solution(15)); //23
    }
}
