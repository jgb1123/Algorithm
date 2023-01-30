package lv1;

import java.util.*;

class Programmers12915 {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() { // Comparator 구현
            @Override
            public int compare(String s1, String s2) {
                if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);   // 만약 각 자릿수가 같으면 문자열 사전순으로 오름차순 정렬
                return s1.charAt(n) - s2.charAt(n); // 각 자릿수가 다르면 해당 자리수로 오름차순 정렬
            }
        });
        return strings; // 정렬된 strings 리턴
    }
}