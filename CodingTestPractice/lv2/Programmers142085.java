package lv2;// 디펜스 게임(https://school.programmers.co.kr/learn/courses/30/lessons/142085)

import java.util.*;

class Programmers142085 {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());    // 큰 수가 우선순위를 갖는 우선순위 큐 생성
        int round = 0;  // 현재 라운드
        for(int i = 0; i < enemy.length; i++) {
            n -= enemy[i];  // 현재 남은 병사의 수
            pq.offer(enemy[i]); // 해당 라운드의 병사 수 pq에 저장
            if(n < 0 && k > 0) {    // 현재 남은 병사 수가 0보다 작으면서, 무적권이 남아있으면
                int num = pq.poll();    // pq에서 가장 큰 값을 poll 해서
                n += num;   // 남은 병사 수에 다시 더함
                k--;    // 무적권 - 1
            } else if(n < 0 && k == 0) {    // 현재 남은 병사수가 0보다 작으면서 무적권이 남아있지 않으면
                break;  // 반복문 탈출
            }
            round = i + 1;  // 현재 라운드는 i + 1

        }
        return round;   // 최종 리턴
    }
}
