package lv2;// 프린터(https://school.programmers.co.kr/learn/courses/30/lessons/42587)

import java.util.*;

class Programmers42587 {
    public int solution(int[] priorities, int location) {
        ArrayList<Integer> list = new ArrayList<>();    // int[] to ArrayList<Integer>
        for(Integer i : priorities) {
            list.add(i);
        }

        int count = 0;  // 인쇄 횟수
        loop:
        while(list.size() > 0) {
            int now = list.get(0);  // 현재 인쇄될 문서 now
            for(int i = 1; i < list.size(); i++) {  // for문을돌며
                if(now < list.get(i)) { // 만약 now보다 우선순위가 높은 문서가 있으면
                    list.remove(0); // 현재 인쇄될 문서를 지우고
                    list.add(now);  // 맨뒤로 다시 추가
                    location--; // location(내가 요청한 문서의 인덱스) - 1
                    if(location < 0) location = list.size() - 1;    // 만약 locaton이 0보다 작아졌으면 (list의 크기 - 1)로
                    continue loop;  // while문 continue
                }
            }
            // for문을 문제없이 통과했으면
            count++;    // 인쇄 횟수 + 1
            if(location == 0) break;    // 만약 내가 요청하 문서의 인덱스가 0이였으면 인쇄되었으므로 while문 탈출
            list.remove(0); // 인쇄 됬으므로 list에서 지움
            location--; // location - 1
        }
        return count;   // 인쇄 횟수 + 1
    }
}
