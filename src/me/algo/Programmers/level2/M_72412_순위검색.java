package me.algo.Programmers.level2;

/* 순위 검색
 * 2021. 03. 30
 * https://programmers.co.kr/learn/courses/30/lessons/72412
 */

import java.util.*;

public class M_72412_순위검색 {
    static Map<String,List<Integer>> map = new HashMap<>();
    private static void dfs(String s, int depth, String[] info){
        if(depth == 4){
            if(!map.containsKey(s)){
                List<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(info[4]));
                map.put(s,list);
            }else{
                map.get(s).add(Integer.parseInt(info[4]));
            }
            return;
        }

        dfs(s+"-",depth+1,info);
        dfs(s+info[depth],depth+1,info);
    }
    public static int[] solution(String[] info, String[] query) {
        for(int i=0; i<info.length; i++){
            String[] infoArr = info[i].split(" ");
            dfs("",0,infoArr);
        }

        for(String key : map.keySet())
            map.get(key).sort(null);

        int[] answer = new int[query.length];
        for(int i=0; i<query.length; i++){
            StringBuilder sb = new StringBuilder();
            String[] queryArr = query[i].split(" ");
            for(int j=0; j<queryArr.length-1; j++){
                if(!queryArr[j].equals("and"))
                    sb.append(queryArr[j]);
            }
            int score = Integer.parseInt(queryArr[queryArr.length-1]);

            String s = String.valueOf(sb);
            if(!map.containsKey(s)) {
                answer[i] = 0;
            }else {
                List<Integer> list = map.get(s);
                int start = 0, end = list.size() - 1;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if (list.get(mid) < score) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
                answer[i] = list.size() - start;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        System.out.println(Arrays.toString(solution(info,query)));
    }
}
