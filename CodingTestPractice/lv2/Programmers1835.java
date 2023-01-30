package lv2;// 단체사진 찍기(https://school.programmers.co.kr/learn/courses/30/lessons/1835)

import java.util.*;

class Programmers1835 {
    static int count;
    static ArrayList<Integer> list;
    static HashMap<Character, Integer> map;
    public int solution(int n, String[] data) {
        // A 0 C 1 F 2 J 3 M 4 N 5 R 6 T 7
        map = new HashMap<>();  // map에 각 알파벳에 해당하는 index 저장
        map.put('A', 0); map.put('C', 1); map.put('F', 2); map.put('J', 3);
        map.put('M', 4); map.put('N', 5); map.put('R', 6); map.put('T', 7);
        count = 0;
        list = new ArrayList<>();   // 숫자들의 순서를 저장할 list
        recur(0, data); // depth 0으로 재귀 시작
        return count;
    }
    public void recur(int depth, String[] data) {
        if(depth == 8) {    // depth가 만약 8이면 (8글자가 모두 채워졌으면)
            for(int i = 0; i < data.length; i++) {  // 조건의 개수만큼 반복
                String str = data[i];
                if(str.charAt(3) == '=') {  // = 일경우
                    if(Math.abs(list.indexOf(map.get(str.charAt(0))) - list.indexOf(map.get(str.charAt(2)))) != str.charAt(4) - '0' + 1) {
                        break;  // 두 알파벳의 인덱스의 차가 조건의 간격 + 1이 아니라면 탈출
                    }
                } else if(str.charAt(3) == '>') {   // > 일경우
                    if(Math.abs(list.indexOf(map.get(str.charAt(0))) - list.indexOf(map.get(str.charAt(2)))) <= str.charAt(4) - '0' + 1) {
                        break;  // 두 알파벳의 인덱스의 차가 조건의 간격 + 1 이하이면 탈출
                    }
                } else if(str.charAt(3) == '<') {   // < 일경우
                    if(Math.abs(list.indexOf(map.get(str.charAt(0))) - list.indexOf(map.get(str.charAt(2)))) >= str.charAt(4) - '0' + 1) {
                        break;  // 두 알파벳의 인덱스의 차가 조건의 간격 +1 이상이면 탈출
                    }
                }
                if(i == data.length - 1) count++;   // 반복문을 통해 조건들을 모두 검증 했는데도 반복문을 탈출안했으면 검증성공이므로 count + 1
            }
        } else {
            for(int i = 0; i < 8; i++) {    // 재귀를 통해 0~7까지 중복되지 않는 숫자들의 순서에 해당하는 경우의 수가 list에 저장됨
                if(!list.contains(i)) {
                    list.add(i);
                    recur(depth + 1, data);
                    if(list.size() > 0) {
                        list.remove(list.size() - 1);
                    }
                }
            }
        }
    }
}
