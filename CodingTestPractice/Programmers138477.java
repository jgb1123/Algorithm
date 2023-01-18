// 명예의전당 (1)(https://school.programmers.co.kr/learn/courses/30/lessons/138477)
import java.util.*;

class Programmers138477 {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // 낮은 수가 우선순위를 갖는 우선순위 큐 pq 생성
        int[] answer = new int[score.length];   // 명예의 전당 최하위 점수들을 저장할 배열 생성
        pq.offer(score[0]); // 첫 점수 pq에 offer
        answer[0] = score[0];   // 명예의 전당 첫 최하위 점수는 첫 점수와 같음
        for(int i = 1; i<score.length; i++) {   // 반복문에서 i는 1부터 시작
            if(pq.size() == k && pq.peek() < score[i]) {    // pq의 크기가 k와 같고, pq에서 가장 작은 수가 현재 점수보다 작으면
                pq.poll();  // pq에서 가장 작은수를 빼내고
                pq.offer(score[i]); // 현재 점수를 넣음
            } else if(pq.size() < k) {  // pq의 크기가 k보다 작으면
                pq.offer(score[i]); // 현재 점수를 넣음
            }
            answer[i] = pq.peek();  // 현재 pq에서 가장 작은 값이 명예의 전당 최저점이 됨
        }
        return answer;  // 결과 리턴
    }
}
