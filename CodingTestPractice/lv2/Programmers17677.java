package lv2;// [1차] 뉴스 클러스터링(https://school.programmers.co.kr/learn/courses/30/lessons/17677)

import java.util.*;

class Programmers17677 {
    public int solution(String str1, String str2) {
        ArrayList<String> list1 = getList(str1);
        ArrayList<String> list2 = getList(str2);
        double size1 = list1.size();    // list1 크기
        double size2 = list2.size();    // list2 크기

        double count = 0;
        for(int i = 0; i < list1.size(); i++) {
            if(list2.contains(list1.get(i))) {  // 만약 list1의 해당 요소가 list2에 포함되어있으면
                list2.remove(list1.get(i)); // list2에서 해당 요소 삭제 후
                count++;    // count + 1
            }
        }
        if(list1.size() == 0 && list2.size() == 0) {    // 모두 공집합이면 65536 리턴
            return 65536;
        }
        return (int) (count / (size1 + size2 - count) * 65536); // 공집합 수 / (A집합의 수 + B집합의 수 - 공집합의 수)가 자카드 유사도
    }

    public ArrayList<String> getList(String str) {  // 문자열을 다중집합으로 만들어 list에 저장 후 list를 반환하는 메서드
        String s = str.toLowerCase();   // 소문자로
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < s.length() - 1; i++) {   // 길이 - 1 이전까지만 반복
            if(checkEng(s.charAt(i)) && checkEng(s.charAt(i + 1))) { // 해당 문자와 다음 문자가 모두 알파벳이면
                list.add(String.valueOf(s.charAt(i)) + s.charAt(i + 1));    // 두 문자를 String으로 변환 후 list에 저장
            }
        }
        return list;    // list 반환
    }

    public boolean checkEng(char c) {   // 알파벳인지 체크해주는 메서드
        return c >= 'a' && c <= 'z';
    }
}