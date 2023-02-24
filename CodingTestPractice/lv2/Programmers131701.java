package lv2;//연속 부분 수열 합의 개수(https://school.programmers.co.kr/learn/courses/30/lessons/131701)

import java.util.*;

class Programmers131701 {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>(); // 중복없이 저장할 hashset 생성
        for(int i = 1; i <= elements.length; i++) { // i는 1부터 elements의 길이까지
            for(int j = 0; j < elements.length; j++) {  // j는 0부터 elements길이 전까지
                int sum = 0;    // 합
                for(int k = j; k < j + i; k++) {    // k는 j부터 j + i 이전까지
                    sum += elements[k % elements.length];   // sum에 더하는데, 인덱스를 고려하여 k % elements의 길이를 사용
                }
                set.add(sum);   // set에 합 저장
            }
        }
        return set.size();  // set의 길이 리턴
    }
}
