package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 덩치
 * 2021. 02. 16
 * https://www.acmicpc.net/problem/7568
 */

public class Main_7568_덩치 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i][0]<arr[j][0]&&arr[i][1]<arr[j][1])
                    arr[i][2]++;
                else if(arr[i][0]>arr[j][0]&&arr[i][1]>arr[j][1])
                    arr[j][2]++;
            }
        }
        StringBuilder  sb= new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(arr[i][2]+1).append(" ");
        }
        System.out.print(sb.toString());

//      2020. 12. 07
//      for(int i=0; i<n; i++){
//          for(int j=i+1; j<n; j++){
//              if(arr[i][0]<arr[j][0]&&arr[i][1]<arr[j][1])
//                  arr[i][2]++;
//              else if(arr[i][0]>arr[j][0]&&arr[i][1]>arr[j][1])
//                  arr[j][2]++;
//          }
//          System.out.print((arr[i][2]+1)+" ");
//       }
    }
}
