package lv1;// 문자열 내림차순으로 배치하기(https://school.programmers.co.kr/learn/courses/30/lessons/12917)

import java.util.*;

class Programmers12917 {
    public String solution(String s) {
        char[] arr = s.toCharArray();   // 문자열을 char[]로 변환
        Arrays.sort(arr);   // 오름차순 정렬
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length - 1; i >= 0; i--) {  // 뒤에서부터
            sb.append(arr[i]);  // sb에 넣음
        }
        return sb.toString();   // sb 문자열로 변환 후 리턴
    }
}
