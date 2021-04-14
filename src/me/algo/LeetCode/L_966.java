package me.algo.LeetCode;

/* 966. Vowel Spellchecker
 * 2021. 04. 14
 * https://leetcode.com/problems/vowel-spellchecker/
 */

import java.util.*;

public class L_966 {
    private static String solution(String w){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<w.length(); i++){
            char c = w.charAt(i);
            if(c=='A'||c=='E'||c=='I'||c=='O'||c=='U')
                c = '*';
            sb.append(c);
        }
        return sb.toString();
    }
    public static String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> set = new HashSet<>(Arrays.asList(wordlist));
        Map<String,String> case1 = new HashMap<>();
        Map<String,String> case2 = new HashMap<>();

        for(int i=0; i<wordlist.length; i++){
            String w = wordlist[i];
            String wCase1 = w.toUpperCase();
            String wCase2 = solution(wCase1);
            if(!case1.containsKey(wCase1))
                case1.put(wCase1,w);
            if(!case2.containsKey(wCase2))
               case2.put(wCase2,w);
        }

        for(int i=0; i<queries.length; i++){
            String q= queries[i];
            String qCase1 = q.toUpperCase();
            String qCase2 = solution(qCase1);
            if(set.contains(q)) continue;
            else if(case1.containsKey(qCase1)) queries[i] = case1.get(qCase1);
            else if(case2.containsKey(qCase2)) queries[i] = case2.get(qCase2);
            else queries[i] = "";
        }
        return queries;
    }
    public static void main(String[] args) {
        String[] wordlist = {"KiTe", "kite", "hare", "Hare"};
        String[] queries = {"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"};

        System.out.println(Arrays.toString(spellchecker(wordlist,queries)));
    }
}
