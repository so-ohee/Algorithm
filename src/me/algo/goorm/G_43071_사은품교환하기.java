package me.algo.goorm;

/* 사은품 교환하기
 * 2020. 12. 18
 * https://level.goorm.io/exam/43071/1c-%ED%99%94%ED%95%99-%EB%AC%BC%EC%A7%88/quiz/1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G_43071_사은품교환하기 {
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
