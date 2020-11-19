package me.algo.Programmers.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 두개 뽑아서 더하기
 * 2020. 11. 19
 * https://programmers.co.kr/learn/courses/30/lessons/68644
 */

public class M_68644_두개뽑아서더하기 {
    public static int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        Iterator iterator = set.iterator();
        int[] answer = new int[set.size()];
        for(int i=0; iterator.hasNext(); i++){
            answer[i] = (int)iterator.next();
        }
        Arrays.sort(answer);
        return answer;
    }
    public static void main(String[] args) {
        int[] n = {2,1,3,4,1};
        System.out.println(Arrays.toString(solution(n)));

        int[] n2 ={5,0,2,7};
        System.out.println(Arrays.toString(solution(n2)));
    }
}
