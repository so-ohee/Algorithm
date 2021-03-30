package me.algo.Programmers.level2;

/* 단체사진 찍기
 * 2021. 03. 30
 * https://programmers.co.kr/learn/courses/30/lessons/1835
 */

public class M_1835_단체사진찍기_array {
    static char[] character = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static char[] position = new char[8];
    static boolean[] checkArr = new boolean[8];
    static String[] dataArr;
    static int answer;

    private static boolean check(int n){
        for(int i=0; i<n; i++){
            char[] arr = dataArr[i].toCharArray();
            int from = 0, to = 0, length = arr[4]-'0';

            for(int j=0; j<8; j++){
                if(position[j] == arr[0]) from = j;
                if(position[j] == arr[2]) to = j;
            }

            int gap = Math.abs(from-to)-1;
            switch (arr[3]){
                case '=':
                    if(gap != length)
                        return false;
                    break;
                case '<':
                    if(gap >= length)
                        return false;
                    break;
                case '>':
                    if(gap <= length)
                        return false;
                    break;
            }
        }
        return true;
    }
    private static void dfs(int idx, int n){
        if(idx==8){
            if(check(n))
                answer++;
            return;
        }
        for(int i=0; i<8; i++){
            if(!checkArr[i]){
                checkArr[i] = true;
                position[idx] = character[i];
                dfs(idx+1, n);
                checkArr[i] = false;
            }
        }
    }

    public static int solution(int n, String[] data) {
        dataArr = data;
        answer = 0;
        dfs(0,n);
        return answer;
    }
}
