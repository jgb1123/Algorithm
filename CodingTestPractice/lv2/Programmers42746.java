package lv2;

import java.util.*;

class Programmers42746 {
    public String solution(int[] numbers) {
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {   // 우선순위 큐 생성
            @Override
            public int compare(String s1, String s2) {  // 정렬 기준은 s2 + s1과 s1 + s2의 값을 비교하여 내림차순으로 되도록
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        for (int number : numbers) {    // pq에 numbers 요소들 저장
            pq.offer(String.valueOf(number));
        }

        StringBuilder sb = new StringBuilder();
        while(pq.size() > 0) {  // pq가 빌때까지 반복
            sb.append(pq.poll());   // sb에 pq에서 빼온 값 저장
        }
        String answer = sb.toString();  // sb에서 문자열로 변환
        if(answer.charAt(0) == '0') return "0"; // 만약 첫글자가 '0'이면 "0" 리턴
        return answer;  // 최종 리턴
    }
}