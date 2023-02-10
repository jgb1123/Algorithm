package lv2;// 위장(https://school.programmers.co.kr/learn/courses/30/lessons/42578)

import java.util.*;

class Programmers42578 {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {   // 의상의 종류별 개수를 구함
            if(map.get(clothes[i][1]) == null) {
                map.put(clothes[i][1], 1);
            } else {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            }
        }
        for(String s : map.keySet()) {  // 의상의 종류별 개수들끼리 곱함
            answer *= (map.get(s) + 1); // 안입은것도 고려하기때문에 + 1해야함
        }
        answer--;   // 모두안입은 케이스는 뺌
        return answer;  // 리턴
    }
}
