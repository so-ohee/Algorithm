package me.algo.LeetCode;

/* 234. Palindrome Linked List
 * 2021. 04. 29
 * https://leetcode.com/problems/palindrome-linked-list/
 */

import java.util.Stack;

public class L_234 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){this.val=val;}
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public static boolean isPalindrome(ListNode head) {
        ListNode listNode = head;
        Stack<Integer> stack = new Stack<>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!stack.isEmpty()){
            if(stack.pop()!=head.val) return false;
            head = head.next;
        }
        return true;
    }
}
