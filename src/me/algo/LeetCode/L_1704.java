package me.algo.LeetCode;

/* 1704. Determine if String Halves Are Alike
 * 2021. 04. 29
 * https://leetcode.com/problems/determine-if-string-halves-are-alike/
 */

public class L_1704 {
    public boolean halvesAreAlike(String s) {
        int mid = s.length()/2;
        s = s.toLowerCase();
        String A = s.substring(0,mid);
        String B = s.substring(mid);

        int count=0;
        for (int i=0; i<mid; i++){
            char cA = A.charAt(i);
            if(cA=='a'||cA=='e'||cA=='i'||cA=='o'||cA=='u')
                count++;

            char cB = B.charAt(i);
            if(cB=='a'||cB=='e'||cB=='i'||cB=='o'||cB=='u')
                count--;
        }

        return count==0;
    }
}
