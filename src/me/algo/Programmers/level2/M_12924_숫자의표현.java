package me.algo.Programmers.level2;

public class M_12924_숫자의표현 {
    public static int solution(int n) {
        int answer = 0;
        int left = 0, right = 0;
        int sum = left + right;
        while (left <= right && right <= n) {
            if (sum < n)
                sum += ++right;
            else if (sum == n)
                answer++;
            sum -= ++left;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(15)); //4
    }
}
