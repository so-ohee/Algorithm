package me.algo.Programmers.level2;

import java.util.*;

/* 오픈채팅방
 * 2020. 11. 09
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 */

public class M_42888_오픈채팅방 {
    public static String[] solution(String[] record) {
        int size = 0;
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < record.length; i++) {
            String[] temp = record[i].split(" ");
            if (temp.length == 3)
                map.put(temp[1], temp[2]);
            if (!temp[0].equals("Change"))
                size++;
        }

        String[] answer = new String[size];
        int index = 0;
        for (int i = 0; i < record.length; i++) {
            String[] temp = record[i].split(" ");
            if (!temp[0].equals("Change")) {
                if (temp[0].equals("Enter"))
                    answer[index++] = map.get(temp[1]) + "님이 들어왔습니다.";
                else if (temp[0].equals("Leave"))
                    answer[index++] = map.get(temp[1]) + "님이 나갔습니다.";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] r = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(r)));
        //["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
    }
}
