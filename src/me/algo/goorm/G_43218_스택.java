package me.algo.goorm;

/* 스택(Stack)
 * 2020. 12. 18
 * https://level.goorm.io/exam/43218/%EC%8A%A4%ED%83%9D-stack/quiz/1#
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class G_43218_스택 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>();
        int count =0;
        while (count<n){
            int value = Integer.parseInt(br.readLine());
            if(value==0){
                if(stack.size()>=10) {
                    br.readLine();
                    System.out.println("overflow");
                }
                else stack.push(br.readLine());
                count++;
            }else if(value==1){
                if(stack.isEmpty()) System.out.println("underflow");
                else stack.pop();
                count++;
            }else{
                break;
            }
        }

        Stack<String> answer = new Stack<>();
        while (!stack.isEmpty()){
            answer.push(stack.pop());
        }

        while (!answer.isEmpty())
            System.out.print(answer.pop()+" ");
    }
}