package lv2;// 스킬트리(https://school.programmers.co.kr/learn/courses/30/lessons/49993)

import java.util.*;

class Programmers49993 {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;
        loop:   // continue 포인트
        for(int i = 0; i < skill_trees.length; i++) {   // 스킬트리 순회
            ArrayList<Character> list = stringToCharList(skill_trees[i]);   // String에서 Char List로 변환
            for(int j = 0; j < skill.length() - 1; j++) {
                char c1 = skill.charAt(j);  // 앞글자 c1
                char c2 = skill.charAt(j + 1);  // 뒷글자 c2
                if(list.contains(c1) && list.contains(c2) && list.indexOf(c1) > list.indexOf(c2)) { // c1,c2 모두 있는데, c1의 인덱스가 c2의 인덱스보다 크면
                    continue loop;  // 다음 loop 실행
                }
                if(!list.contains(c1) && list.contains(c2)) {   // c1은 없는데 c2는 있으면
                    continue loop;  // 다음 loop 실행
                }
            }
            count++;    // 반복문을 모두 돌고도 나왔으면 count + 1
        }
        return count;   // 최종 리턴
    }

    public ArrayList<Character> stringToCharList(String skill_trees) {  // string에서 char List로 변환하는 메서드
        ArrayList<Character> list = new ArrayList<>();  //
        for(int j = 0; j < skill_trees.length(); j++) {
            list.add(skill_trees.charAt(j));
        }
        return list;
    }
}