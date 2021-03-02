package me.algo.BaekJoon;

/* 연산자 끼워넣기 (3)
 * 2021. 03. 01
 * https://www.acmicpc.net/problem/15659
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_15659_연산자끼워넣기3 {
    static int N;
    static int[] arr;
    static int[] operatorCount = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static Vector<Integer> operator = new Vector<>();

    private static String OperatorCheck(int op){
        if(op==0) return "+";
        else if(op==1) return "-";
        else if(op==2) return "*";
        else return "/";
    }
    private static int Calc(int x, int y, int op){
        if(op==0) return x+y;
        else if(op==1) return x-y;
        else if(op==2) return x*y;
        else return x/y;
    }
    private static void solution(){
        Vector<String> vector = new Vector<>();
        for(int i=0; i<operator.size(); i++){
            if(operator.get(i)==0||operator.get(i)==1){
                if(vector.isEmpty())
                   vector.add(String.valueOf(arr[i]));
                vector.add(OperatorCheck(operator.get(i)));
                vector.add(String.valueOf(arr[i+1]));
            }else{
                int num = arr[i];
                if(!vector.isEmpty())
                    num = Integer.parseInt(vector.remove(vector.size()-1));
                int res = Calc(num,arr[i+1],operator.get(i));
                vector.add(String.valueOf(res));
            }
        }

        int answer = Integer.parseInt(vector.remove(0));
        while (!vector.isEmpty()){
            String op = vector.remove(0);
            if(op.equals("+"))
                answer += Integer.parseInt(vector.remove(0));
            else
                answer -= Integer.parseInt(vector.remove(0));
        }

        max = Math.max(max,answer);
        min = Math.min(min,answer);
    }
    private static void dfs(int count){
        if(count==N){
            solution();
            return;
        }
        for(int i=0; i<4; i++) {
            if (operatorCount[i] != 0) {
                operatorCount[i]--;
                operator.add(i);
                dfs(count+1);
                operator.remove(operator.size()-1);
                operatorCount[i]++;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            operatorCount[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1);
        System.out.println(max+"\n"+min);
    }
}