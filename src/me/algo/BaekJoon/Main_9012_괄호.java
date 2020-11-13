package me.algo.BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012_괄호 {
    public static String check(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push("(");
            } else if (stack.isEmpty()) {
                return "NO";
            } else stack.pop();
        }
        return (stack.isEmpty() ? "YES" : "NO");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());

        for (int i = 0; i < length; i++) {
            String s = br.readLine();
            if (s.length() % 2 != 0 || s.charAt(0) == ')')
                System.out.println("NO");
            else
                System.out.println(check(s));
        }
    }
}
