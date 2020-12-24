package me.algo.Goorm;

/* 최대 자리 곱
 * 2020. 12. 19
 * https://level.goorm.io/exam/49113/%EC%B5%9C%EB%8C%80-%EC%9E%90%EB%A6%AC%EA%B3%B1/quiz/1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G_49113_최대자리곱 {
    public static int solution(int[] n){
       int mul = 1;
       for(int i=0; i<n.length; i++){
           if(n[i]>0) mul*=n[i];
       }
       return mul;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");
        if(s.length==1) System.out.println(s[0]);
        else{
            int answer = solution(Arrays.stream(s).mapToInt(Integer::parseInt).toArray());
            for(int i=0; i<s.length-1; i++){
                int[] temp = Arrays.stream(s).mapToInt(Integer::parseInt).toArray();
                temp[i]--;
                for(int j=i+1; j<temp.length; j++) temp[j] = 9;
                answer = Math.max(answer,solution(temp));
            }
            System.out.println(answer);
        }
    }
}
