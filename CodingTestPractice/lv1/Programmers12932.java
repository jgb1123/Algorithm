package lv1;// 자연수 뒤집어 배열로 만들기(https://school.programmers.co.kr/learn/courses/30/lessons/12932)

import java.util.*;

class Programmers12932 {
    public int[] solution(long n) {
        ArrayList<Integer> list = new ArrayList<>();
        while(n > 0) {  // 뒷자리부터 list에 저장
            list.add((int) (n % 10));
            n = n / 10;
        }
        int[] answer = list.stream().mapToInt(i -> i).toArray();    // list를 int[]로 변환
        return answer;  // 최종 리턴
    }
}
