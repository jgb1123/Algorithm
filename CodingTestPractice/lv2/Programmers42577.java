package lv2;// 전화번호 목록(https://school.programmers.co.kr/learn/courses/30/lessons/42577)

import java.util.*;

class Programmers42577 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);    // phone_book 오름차순 정렬

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {  // 앞뒤끼리만 비교하며, 이전 문자열로 시작되면
                return false;   // false 리턴
            }
        }
        return true;    // 그외에는 true 리턴
    }
}