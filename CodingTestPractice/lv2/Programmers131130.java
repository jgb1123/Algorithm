package lv2;// 혼자 놀기의 달인(https://school.programmers.co.kr/learn/courses/30/lessons/131130)

import java.util.*;

public class Programmers131130 {
    public int solution(int[] cards) {
        boolean[] visit = new boolean[cards.length];    // 방문 확인용 배열
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < cards.length; i++) {
            if(!visit[i]) { // 방문하지 않았으면
                visit[i] = true;    // 방문 완료 처리
                int count = 1;  // count는 1부터 시작
                int next = cards[i] - 1;    // 다음 오픈해야할 카드의 위치 next는 cards[i] - 1 (인덱스 고려)
                while(!visit[next]) {   // next가 방문하지 않은 카드면 계속 반복
                    visit[next] = true; // next카드 방문 완료 처리
                    count++;    // count + 1
                    next = cards[next] - 1; // 다시 다음 오픈해야할 카드의 위치 next는 cards[next] - 1
                }
                list.add(count);    // 반복문 종료 후 list에 count 저장
            }

        }
        Collections.sort(list); // count 오름차순 정렬
        if(list.size() == 1) return 0;  // list의 크기가 1이면 0 리턴
        return list.get(list.size() - 1) * list.get(list.size() - 2);   // list에서 가장 큰 두 수의 곱 리턴
    }
}