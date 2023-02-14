package lv2;// H-Index(https://school.programmers.co.kr/learn/courses/30/lessons/42747)

import java.util.*;

class Programmers42747 {
    public int solution(int[] citations) {
        Arrays.sort(citations); // 오름차순 정렬
        for(int i = citations.length - 1; i >= 0; i--) {    // 뒤에서부터 앞으로
            if(citations[citations.length - i - 1] >= i + 1) return i + 1;  // citations[citations.length - i - 1]이 i+1보다 크면 i+1 리턴
        }
        return 0;   // 다돌아도 리턴이 안되었으면 0리턴
    }
}
