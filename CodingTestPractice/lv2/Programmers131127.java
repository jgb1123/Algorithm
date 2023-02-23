package lv2;// 할인 행사(https://school.programmers.co.kr/learn/courses/30/lessons/131127)

import java.util.*;

class Programmers131127 {
    public int solution(String[] want, int[] number, String[] discount) {
        int count = 0;  // 가능한 회원가입일 수
        for(int i = 0; i <= discount.length - 10; i++) {    // 0부터 discount의 길이 - 10까지만
            int[] arr = new int[number.length]; // 해당 날짜부터 10일간 각 상품들의 할인 날짜 수를 저장할 arr 배열
            for(int j = 0; j < want.length; j++) {  // 해당 날짜부터 10일간 각 상품들의 할인 날짜 수를 arr에 저장
                for(int k = i; k < i + 10; k++) {
                    if(want[j].equals(discount[k])) {
                        arr[j] += 1;
                    }
                }
            }
            if(Arrays.equals(number, arr)) count++; // number배열과 arr배열이 같다면 가능한 회원가입일 수 + 1
        }
        return count;   // 최종 리턴
    }
}
