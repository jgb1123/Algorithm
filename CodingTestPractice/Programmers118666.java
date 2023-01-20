// 성격 유형 검사하기(https://school.programmers.co.kr/learn/courses/30/lessons/118666)

import java.util.*;
public class Programmers118666 {
    public String solution(String[] survey, int[] choices) {
        int[] result = new int[8]; // R T C F J M A N   // 각 성격의 점수
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('R', 0); map.put('T', 1);
        map.put('C', 2); map.put('F', 3);
        map.put('J', 4); map.put('M', 5);
        map.put('A', 6); map.put('N', 7);

        int[] score = {0, 3, 2, 1, 0, 1, 2, 3}; // 더해질 점수들의 가중치
        for(int i = 0; i < survey.length; i++) {
            char a = survey[i].charAt(0);   // 질문 유형의 앞 글자
            char b = survey[i].charAt(1);   // 질문 유형의 뒷 글자
            if(choices[i] >= 5) {   // 만약 해당 질문이 5점 이상이라면,
                result[map.get(b)] += score[choices[i]];    // 뒷 글자 성격의 점수에 가중치만큼 더함
            } else {    // 4점 이하라면
                result[map.get(a)] += score[choices[i]];    // 앞 글자 성격의 점수에 가중치만큼 더함
            }
        }
        StringBuilder sb = new StringBuilder();
        if(result[0] >= result[1]) {    // R의 점수가 T의 점수 이상이면 R추가
            sb.append('R');
        } else {    // 아니면 T추가
            sb.append('T');
        }
        if(result[2] >= result[3]) {    // C의 점수가 F의 점수 이상이면 C추가
            sb.append('C');
        } else {    // 아니면 F추가
            sb.append('F');
        }
        if(result[4] >= result[5]) {    // J의 점수가 M의 점수 이상이면 J추가
            sb.append('J');
        } else {    // 아니면 M추가
            sb.append('M');
        }
        if(result[6] >= result[7]) {    // A의 점수가 N의 점수 이상이면 A추가
            sb.append('A');
        } else {    // 아니면 N추가
            sb.append('N');
        }
        String answer = sb.toString();
        return answer;  // 최종 성격 유형 반환
    }
}
