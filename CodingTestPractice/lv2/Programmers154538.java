package lv2;// 숫자 변환하기(https://school.programmers.co.kr/learn/courses/30/lessons/154538)

import java.util.*;

public class Programmers154538 {
    public int solution(int x, int y, int n) {
        int count = 0;
        Queue<Integer> q = new LinkedList<>();  // bfs에 사용할 q
        boolean[] visit = new boolean[1000001]; // 방문 확인용 배열
        q.offer(x); // x에서 bfs 시작
        while(q.size() > 0) {   // q가 빌때까지 반복
            int size = q.size();    // q의 사이즈
            for(int i = 0; i < size; i++) { // 사이즈만큼 반복
                if(q.peek() == y) { // 만약 peek한값이 y면
                    return count;   // 현재 count 리턴
                }
                int num = q.poll(); // num은 q에서 poll한값
                if(num + n <= y && !visit[num + n]) {   // num + n이, y이하 이면서 방문하지 않은 숫자면
                    visit[num + n] = true;  // 방문 완료 처리
                    q.offer(num + n);   // q에 num + n offer
                }
                if(num * 2 <= y && !visit[num * 2]) {   // num * 2가, y이하 이면서 방문하지 않은 숫자면
                    visit[num * 2] = true;  // 방문 완료 처리
                    q.offer(num * 2);   // q에 num * 2 offer
                }
                if(num * 3 <= y && !visit[num * 3]) {   // num * 3이, y이하 이면서 방문하지 않은 숫자면
                    visit[num * 3] = true;  // 방문 완료 처리
                    q.offer(num * 3);   // q에 num * 3 offer
                }
            }
            count++;    // count + 1
        }
        return -1;  // 탐색이 모두 종료될 때까지 리턴되지 않았으면 -1 리턴
    }
}
