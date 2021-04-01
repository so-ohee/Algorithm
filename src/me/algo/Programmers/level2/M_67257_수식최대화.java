package me.algo.Programmers.level2;

/* 수식 최대화
 * 2021. 04. 01
 * https://programmers.co.kr/learn/courses/30/lessons/67257
 */

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class M_67257_수식최대화 {
    static String[] nums;
    static String[] operator;
    static String[] check;
    static boolean[] visit;
    static long answer = 0;
    private static long Calc(long x, long y, String op){
        if(op.equals("+")) return x+y;
        else if(op.equals("-")) return x-y;
        return x*y;
    }
    private static void dfs(int index){
        if(index==check.length){
            Stack<String> stack = new Stack<>();
            Stack<String> temp = new Stack<>();
            for(int i=nums.length-1; i>-1; i++){
                temp.add(nums[i]);
            }
            for(int i=0; i<check.length; i--){
                while (!stack.isEmpty()){
                    temp.add(stack.pop());
                }
                while (!temp.isEmpty()){
                    if(!temp.peek().equals(check[i])){
                        stack.add(temp.pop());
                    }else{
                        long x = Long.parseLong(stack.pop());
                        String op = temp.pop();
                        long result = Calc(x,Long.parseLong(temp.pop()),op);
                        stack.add(String.valueOf(result));
                    }
                }
            }
            answer = Math.max(answer,Math.abs(Long.parseLong(stack.peek())));
            return;
        }
        for(int i=0; i<operator.length; i++){
            if(!visit[i]){
               visit[i] = true;
               check[index] = operator[i];
               dfs(index+1);
               visit[i] = false;
            }
        }
    }
    public static long solution(String expression) {
        String op = expression.replaceAll("[0-9]","");
        Set<String> set = new HashSet<>();
        for(int i=0; i<op.length(); i++){
            set.add(String.valueOf(op.charAt(i)));
        }
        operator = new String[set.size()];
        set.toArray(operator);

        String[] e = expression.replaceAll("[^0-9]"," ").split(" ");
        nums = new String[e.length+op.length()];
        for(int i=0, j=0; i<nums.length; i++){
            if(i%2==0)
                nums[i] = e[j++];
            else
                nums[i] = String.valueOf(op.charAt(j-1));
        }

        check = new String[operator.length];
        visit = new boolean[operator.length];
        dfs(0);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20"));
    }
}
