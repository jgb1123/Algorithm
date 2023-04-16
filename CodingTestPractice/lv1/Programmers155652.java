package lv1;// 둘만의 암호(https://school.programmers.co.kr/learn/courses/30/lessons/155652)

import java.util.*;

class Programmers155652 {
    public String solution(String s, String skip, int index) {
        ArrayList<Character> skipChar = new ArrayList<>();  // 스킵할 문자들을 담는 ArrayList생성
        for(int i = 0; i < skip.length(); i++) {    // 스킵할 문자들 list에 저장
            skipChar.add(skip.charAt(i));
        }

        StringBuilder sb = new StringBuilder(); // 결과를 저장할 StringBuilder 생성
        for(int i = 0; i < s.length(); i++) {
            int num = index;    // 뒤로 이동할 수
            char c = s.charAt(i);   // 현재 문자
            while(num > 0) {    // 뒤로 이동할 수가 0보다 크면 반복
                c += 1; // 현재 문자 한칸뒤로 이동
                if(c > 'z') {   // 현재 문자가 'z'보다 크면 -26
                    c -= 26;
                }
                if(skipChar.contains(c)) {  // 현재문자가 스킵할 문자에 포함되어있으면 continue
                    continue;
                }
                num--;  // num - 1
            }
            sb.append(c);   // sb에 현재 문자 저장
        }
        return sb.toString();   // sb를 String으로 변환 후 리턴
    }
}
