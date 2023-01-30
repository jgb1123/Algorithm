package lv1;// 가장 가까운 같은 글자(https://school.programmers.co.kr/learn/courses/30/lessons/142086)

import java.util.*;

class Programmers142086 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()]; // 결과
        HashMap<Character, Integer> map = new HashMap<>();  // 해당 문자가 나온 마지막 index를 저장할 HashMap
        Arrays.fill(answer, -1);    //  결과를 -1로 채움
        for(int i = 0; i < s.length(); i++) {   // 문자열의 길이만큼 반복
            if(map.containsKey(s.charAt(i))) {  // 만약 이전에 해당 문자가 나온적이 있으면
                answer[i] = i - map.get(s.charAt(i));   // (현재 index) - (해당 문자가 마지막에 나왔던 index) 마지막에 나왔던 index까지의 거리를 구할 수 있음
            }
            map.put(s.charAt(i), i);    // 해당 문자를 키로 i(해당 문자가 나온 마지막 index)를 저장
        }
        return answer;  // 결과 리턴
    }
}