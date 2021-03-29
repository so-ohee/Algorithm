package me.algo.Programmers.level1;

/* 신규 아이디 추천
 * 2021. 03. 29
 * https://programmers.co.kr/learn/courses/30/lessons/72410
 */

public class M_72410_신규아이디추천 {
    public String solution(String new_id) {
        //1단계
        new_id = new_id.toLowerCase();

        //2단계
        new_id = new_id.replaceAll("[^-_.a-z0-9]", "");

        //3단계
        new_id = new_id.replaceAll("[.]{2,}",".");

        //4단계
        if(new_id.startsWith("."))
            new_id = new_id.substring(1);
        if(new_id.endsWith("."))
            new_id = new_id.substring(0,new_id.length()-1);

        //5단계
        if(new_id.length()==0)
            new_id = "a";

        //6단계
        if(new_id.length()>15)
            new_id = new_id.substring(0,15);
        if(new_id.endsWith("."))
            new_id = new_id.substring(0,new_id.length()-1);

        //7단계
        if(new_id.length()<3){
            String s = new_id.charAt(new_id.length()-1)+"";
            while (new_id.length()<3){
                new_id += s;
            }
        }
        return new_id;
    }
}