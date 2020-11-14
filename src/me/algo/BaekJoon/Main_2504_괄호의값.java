package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2504_괄호의값 {
    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int n = 1;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[') {
                stack.push(s.charAt(i));
                n *= s.charAt(i)=='(' ? 2 : 3;
            }else if(s.charAt(i)==')'){
                if(stack.isEmpty() || stack.peek()!='(') return 0;
                if(s.charAt(i-1)=='(') answer += n;
                stack.pop();
                n/=2;
            }else{
                if(stack.isEmpty() || stack.peek()!='[') return 0;
                if(s.charAt(i-1)=='[') answer += n;
                stack.pop();
                n/=3;
            }
        }
        return stack.empty() ? answer : 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        if (s.length() % 2 != 0) System.out.println(0);
        else System.out.println(solution(s));
    }
}
