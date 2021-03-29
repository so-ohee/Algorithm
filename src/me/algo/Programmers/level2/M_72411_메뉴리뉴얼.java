package me.algo.Programmers.level2;

/* 메뉴 리뉴얼
 * 2021. 03. 30
 * https://programmers.co.kr/learn/courses/30/lessons/72411
 */

import java.util.*;

public class M_72411_메뉴리뉴얼 {
    private static Map<String, Integer> map = new HashMap<>();

    public static String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < orders.length; i++) {   // 한 주문당 모든 조합 구하기
            String[] orders_char = orders[i].split("");
            Arrays.sort(orders_char);

            for (int index = 0; index < orders_char.length - 1; index++) {  // 차례대로 한글자씩 선택 후
                for (int j = 0; j < course.length; j++) {   // course 에 있는 모든 경우
                    dfs(orders_char, index, 1, course[j], orders_char[index]);
                }
            }
        }

        List<String> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        List<String> ansList = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            int max_value = 0;

            for (String key : keySetList) {
                if (map.get(key) >= 2 && key.length() == course[i]) {
                    if (map.get(key) >= max_value) {
                        ansList.add(key);
                        max_value = map.get(key);
                    }
                }
            }
        }
        Collections.sort(ansList);
        String[] answer = new String[ansList.size()];
        ansList.toArray(answer);

        return answer;
    }

    public static void dfs(String[] arr, int idx, int length, int course, String str) {
        if (length == course) {
            map.put(str,map.getOrDefault(str,0)+1);
            return;
        }

        for (int i = idx + 1; i < arr.length; i++) {
            dfs(arr, i, length + 1, course, str + arr[i]);
        }
    }

    public static void main(String[] args) {
        String[] orders = {"ABCFG","AC","CDE","ACDE","BCFG","ACDEH"};
        int[] course = {2,3,4};
        System.out.println(Arrays.toString(solution(orders,course)));
    }
}
