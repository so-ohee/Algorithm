package me.algo.Programmers.level2;

/* 괄호변환
 * 2020. 11. 06
 * https://programmers.co.kr/learn/courses/30/lessons/60058
 */

public class M_60058_괄호변환 {
    public static String solution(String p) {
        return checkString(p);
    }

    public static String checkString(String p){
        if(p.length()==0) return "";
        if(checkCorrectString(p)) return p;
        else return splitString(p);
    }

    public static Boolean checkCorrectString(String p) {
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') count++;
            else count--;
            if (count < 0) return false;
        }
        return true;
    }

    public static String splitString(String p) {
        int count = 0;
        String u = "", v = "";
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') count++;
            else count--;
            u += String.valueOf(p.charAt(i));
            if (count == 0) {
                v = p.substring(i+1);
                break;
            }
        }

        if (checkCorrectString(u)) {
            return u+checkString(v);
        } else {
            String s = "("+checkString(v)+")";
            for (int i = 1; i < u.length() - 1; i++) {
                s += u.charAt(i) == '(' ? ")" : "(";
            }
            return s;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("(()())()")); //"(()())()"
        System.out.println(solution(")(")); //"()"
        System.out.println(solution("()))((()")); //"()(())()"
    }
}
