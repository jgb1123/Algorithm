// 예산(https://school.programmers.co.kr/learn/courses/30/lessons/12982)

import java.util.*;

class Programmers12982 {
    public int solution(int[] d, int budget) {
        Arrays.sort(d); // 최대한 많은 부서에 지원해주기 위해 신청 금액을 오름차순으로 정렬
        int answer = 0; // 지원 가능한 부서 수
        for(int i = 0; i < d.length; i++) {
            if(budget - d[i] >= 0) {    // 남은 예산으로 신청금액만큼 지원 가능하면
                budget -= d[i]; // 예산에서 신청금액만큼 빼고
                answer++;   // 지원 가능한 부서 수 +1
            } else {    // 예산이 부족하면
                break;  // 반복문 탈출
            }
        }
        return answer;  // 최종 리턴
    }
}
