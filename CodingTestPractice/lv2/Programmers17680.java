package lv2;// [1차] 캐시(https://school.programmers.co.kr/learn/courses/30/lessons/17680)

import java.util.*;

class Programmers17680 {
    public int solution(int cacheSize, String[] cities) {
        int time = 0;   // 걸린 시간
        if(cacheSize == 0) return cities.length * 5;    // 캐시크기가 0이면, (cities의 길이) * 5 리턴
        Queue<String> q = new LinkedList<>();   // LRU에 사용할 Queue
        for(int i = 0; i < cities.length; i++) {
            String str = cities[i].toLowerCase();   // 대소문자 구분 안하므로 모두 소문자로 변환 후 처리
            if(q.size() < cacheSize) {  // Queue의 사이즈가 캐시크기보다 작으면
                if(q.contains(str)) {   // 해당 문자열이 Queue에 포함되어 있으면
                    time += 1;  // 시간 + 1
                    q.remove(str);  // Queue에서 해당 문자열 삭제
                } else {    // 해당 문자열이 Queue에 포함되어 있지 않으면
                    time += 5;  // 시간 +5
                }
                q.offer(str);   //  Queue에 해당 문자열 offer
            } else {    // 캐시크기만큼 모두 차있으면
                if(q.contains(str)) {   // 해당 문자열이 Queue에 포함되어 있으면
                    time += 1;  // 시간 + 1
                    q.remove(str);  // Queue에서 해당 문자열 삭제
                } else {    // 해당 문자열이 Queue에 포함되어 있지 않으면
                    time += 5;  // 시간 + 5
                    q.poll();   // poll
                }
                q.offer(str);   // Queue에 해당 문자열 offer
            }
        }
        return time;    // time 리턴
    }
}
