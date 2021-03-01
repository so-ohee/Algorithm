package me.algo.LeetCode;

/* 284. Peeking Iterator
 * 2021. 03. 01
 * https://leetcode.com/problems/peeking-iterator/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class L_284 {
    static class PeekingIterator implements Iterator<Integer> {
        private List<Integer> list = new ArrayList<>();
        private int index = 0;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            while (iterator.hasNext())
                list.add(iterator.next());
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return list.get(index);
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            return list.get(index++);
        }

        @Override
        public boolean hasNext() {
            return index<list.size();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Iterator<Integer> iterator = list.iterator();
        PeekingIterator peekingIterator = new PeekingIterator(iterator);
    }
}
