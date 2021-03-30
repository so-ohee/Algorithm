package me.algo.Programmers.level2;

/* 단체사진 찍기
 * 2021. 03. 30
 * https://programmers.co.kr/learn/courses/30/lessons/1835
 */

import java.util.HashMap;
import java.util.Map;

public class M_1835_단체사진찍기_map {
    static Map<Character,Integer> map = new HashMap<>();
    static int[] position = new int[8];
    static boolean[] visit = new boolean[8];
    static int answer = 0;
    static String[] dataArr;
    private boolean check(int n){
        for(int i=0; i<n; i++){
            char[] arr = dataArr[i].toCharArray();
            int from = position[map.get(arr[0])];
            int to = position[map.get(arr[2])];
            int length = arr[4]-'0';
            int gap = Math.abs(from-to)-1;

            switch (arr[3]){
                case '=':
                    if(gap!=length) return false;
                    break;
                case '<':
                    if(gap>=length) return false;
                    break;
                case '>':
                    if(gap<=length) return false;
                    break;
            }
        }
        return true;
    }
    private void dfs(int index, int n){
        if(index==8){
            if(check(n))
                answer++;
            return;
        }
        for(int i=0; i<8; i++){
            if(!visit[i]){
                visit[i] = true;
                position[index] = i;
                dfs(index+1,n);
                visit[i] = false;
            }
        }
    }
    public int solution(int n, String[] data) {
        map.put('A',0);
        map.put('C',1);
        map.put('F',2);
        map.put('J',3);
        map.put('M',4);
        map.put('N',5);
        map.put('R',6);
        map.put('T',7);

        dataArr = data;
        answer = 0;
        dfs(0,n);
        return answer;
    }
}
