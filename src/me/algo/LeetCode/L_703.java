package me.algo.LeetCode;

/* 703. Kth Largest Element in a Stream
 * 2021. 01. 07
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */

import java.util.PriorityQueue;

public class L_703 {
    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public L_703(int k, int[] nums) {
        this.k=k;
        for(int i:nums){
            pq.add(i);
            if(pq.size()>k) pq.poll();
        }
    }

    public int add(int val) {
        pq.add(val);
        if(pq.size()>k) pq.poll();
        return pq.peek();
    }
    public static void main(String[] args) throws Exception{
        L_703 kthLargest = new L_703(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }
}
