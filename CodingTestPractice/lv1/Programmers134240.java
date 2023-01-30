package lv1;// 푸드 파이트 대회(https://school.programmers.co.kr/learn/courses/30/lessons/134240)

import java.util.*;

class Programmers134240 {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder(); // 음식들의 순서를 저장할 StringBuilder sb 생성
        ArrayList<Integer> list = new ArrayList<>();    // 나중에 역순으로 사용하기 위한 ArrayList
        for(int i = 1; i < food.length; i++) {
            int div = food[i] / 2;
            for(int j = 0; j < div; j++) {  // 해당 음식의 수를 2로 나눈 몫 까지만 반복
                sb.append(i);   // 해당 음식 sb에 추가
                list.add(i);    // 나중에 list를 이용해 역순으로 넣어줌
            }
        }
        sb.append(0);   // 물 sb에 추가
        for(int i = list.size() - 1; i >= 0; i--) { // 음식들 역순으로 다시 sb에 추가
            sb.append(list.get(i));
        }
        String answer = sb.toString();  // 최종 문자열
        return answer;  // 결과 리턴
    }
}
