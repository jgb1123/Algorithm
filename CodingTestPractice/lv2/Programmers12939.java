package lv2;// 최댓값과 최솟값(https://school.programmers.co.kr/learn/courses/30/lessons/12939)

import java.util.*;

class Programmers12939 {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);    // 공백을 기준으로 토큰화
        int max = Integer.MIN_VALUE;    // max값
        int min = Integer.MAX_VALUE;    // min값
        while(st.hasMoreTokens()) { // 다음 문자열 토큰이 없어질때까지 반복
            String str = st.nextToken();    // 해당 토큰을 가져오고
            int n = Integer.parseInt(str);  // int로 변환
            if(max < n) max = n;    // max보다 크면 갱신
            if(min > n) min = n;    // min보다 작으면 갱신
        }
        return min + " " + max; // "min max"형태로 출력
    }
}
