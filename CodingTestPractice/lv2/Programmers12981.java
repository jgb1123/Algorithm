package lv2;// 영어 끝말잇기(https://school.programmers.co.kr/learn/courses/30/lessons/12981)

import java.util.*;

class Programmers12981 {
    public int[] solution(int n, String[] words) {
        ArrayList<String> list = new ArrayList<>(); // 중복 확인을 위한 list
        list.add(words[0]); // 첫 문자열 list에 저장
        for(int i = 1; i < words.length; i++) {
            String prev = words[i - 1]; // 이전 문자열
            if(prev.charAt(prev.length() - 1) != words[i].charAt(0) || list.contains(words[i])) {   // 첫 문자가 이전 문자열의 끝 문자와 다르거나, list에 포함되어있으면
                int num = (i + 1) % n;  // 사람의 번호 계산
                if(num == 0) num = n;
                int count = (i + n) / n;    // 그 사람의 몇번째 차례였는지 계산

                return new int[]{num, count};   // 리턴
            }
            list.add(words[i]); // list에 문자 저장
        }

        return new int[]{0, 0}; // for문 다 돌고도 리턴이 안됬으면 탈락자가 발생하지 않은 것 이므로 {0, 0}리턴
    }
}
