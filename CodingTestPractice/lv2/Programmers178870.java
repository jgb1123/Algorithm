package lv2;// 연속된 부분 수열의 합(https://school.programmers.co.kr/learn/courses/30/lessons/178870)

import java.util.*;

class Programmers178870 {
    public int[] solution(int[] sequence, int k) {
        int min = Integer.MAX_VALUE;    // 가장 짧은 길이를 구하기 위한 min값
        int start = 0;  // 시작 인덱스 0
        int end = -1;   // 끝 인덱스는 -1부터 시작
        int sum = 0;    // 합
        int[] answer = new int[2];  // 시작인덱스와 끝 인덱스가 들어갈 배열
        Queue<Integer> q = new LinkedList<>();  // Queue 생성
        for(int i = 0; i < sequence.length; i++) {  // sequence 배열 순회
            sum += sequence[i]; // sum에 sequence[i]값 더함
            q.offer(sequence[i]);   // Queue에 sequence[i]값 저장
            end++;  // 끝 인덱스 + 1
            while(sum > k) { // sum이 k보다 크다면 반복
                sum -= q.poll(); // sum에 Queue에서 poll한 값 뺌
                start++; // 시작 인덱스 + 1
            }
            if(sum == k && end - start < min){  // 만약 sum이 k와 같고, 끝 인덱스 - 시작 인덱스가 min보다 작다면
                min = end - start;  // min값 갱신
                answer[0] = start;  // answer[0]은 현재 시작 인덱스
                answer[1] = end;    // answer[1]은 현재 끝 인덱스
            }
        }
        return answer;  // 최종 리턴
    }
}
