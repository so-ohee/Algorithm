package me.algo.goorm;

/* 사은품 교환하기
 * 2020. 12. 18
 * https://level.goorm.io/exam/47878/%EC%82%AC%EC%9D%80%ED%92%88-%EA%B5%90%ED%99%98%ED%95%98%EA%B8%B0/quiz/1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G_47878_사은품교환하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long M = Long.parseLong(st.nextToken());

            long answer = Math.min(N/5,M/7);
            N -= 5*answer;
            M -= 7*answer;
            if(N>=5 && N+M>=12) {
                N -= 12-M;
                answer++;
            }
            if(N>=12) answer += N/12;
            System.out.println(answer);
        }
    }
}
