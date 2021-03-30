package me.algo.Programmers.level2;

/* 방문 길이
 * 2021. 03. 31
 * https://programmers.co.kr/learn/courses/30/lessons/49994
 */

import java.util.HashMap;
import java.util.Map;

public class M_49994_방문길이 {
    static int x = 0, y = 0;
    static int nX = 5, nY=5;
    static boolean[][][][] visit = new boolean[11][11][11][11];
    static Map<Character,int[]> map = new HashMap<>();
    static int answer = 0;
    public static int solution(String dirs) {
        map.put('U',new int[]{-1,0});
        map.put('D',new int[]{1,0});
        map.put('R',new int[]{0,1});
        map.put('L',new int[]{0,-1});

        for(int i=0; i<dirs.length(); i++){
            x = nX;
            y = nY;
            char c = dirs.charAt(i);
            int[] temp = map.get(c);
            nX += temp[0];
            nY += temp[1];

            if(nX>=0 && nX<11 && nY>=0 && nY<11){
                if(!visit[x][y][nX][nY] && !visit[nX][nY][x][y]){
                    visit[x][y][nX][nY] = true;
                    visit[nX][nY][x][y] = true;
                    answer++;
                }
            }else{
                nX -= temp[0];
                nY -= temp[1];
            }
        }
        return answer;
    }
}
