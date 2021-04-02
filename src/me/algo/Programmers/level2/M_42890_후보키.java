package me.algo.Programmers.level2;

/* 후보키
 * 2021. 04. 02
 * https://programmers.co.kr/learn/courses/30/lessons/42890
 * 참고 : https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%9B%84%EB%B3%B4%ED%82%A4-Java
 */

import java.util.*;

public class M_42890_후보키 {
    static int col;
    static int row;
    static String[][] arr;
    static ArrayList<Integer> ck = new ArrayList<>();

    private static boolean isMainimal(int set){
         for(int key : ck){
            if((key & set) == key) return false;
        }
        return true;
    }
    private static boolean isUnique(int set){
        Set<String> map = new HashSet<>();

        for(int i = 0; i<row; i++){
            String data = "";
            for(int j=0; j<col; j++){
                if((set & (1<<j)) != 0) {
                    data += arr[i][j];
                }
            }
            if(map.contains(data)) return false;
            else map.add(data);
        }
        return true;
    }
    public static int solution(String[][] relation) {
        row = relation.length;
        col = relation[0].length;
        arr = relation;

        for(int set=1; set<(1<<col); set++){
            //최소성 검사
            if(!isMainimal(set)) continue;

            //유일성 검사
            if(isUnique(set)) ck.add(set);
        }
        return ck.size();
    }
}
