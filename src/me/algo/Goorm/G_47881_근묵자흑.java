package me.algo.Goorm;

/* 근묵자흑
 * 2021. 03. 19
 * https://level.goorm.io/exam/47881/%EA%B7%BC%EB%AC%B5%EC%9E%90%ED%9D%91/quiz/1
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G_47881_근묵자흑 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int count = 0;
        int min = arr[1];
        int temp = 0;
        for(int i=1; i<=N; i++){
            arr[i] = min;
            temp++;
            if(temp==K){
                count++;
                temp = 0;
                if(i==N) break;
                i--;
            }
        }
        count += temp!=0 ? 1 : 0;
        System.out.println(count);
    }
}
