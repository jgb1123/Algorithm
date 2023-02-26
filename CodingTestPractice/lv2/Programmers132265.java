package lv2;// 롤케이크 자르기(https://school.programmers.co.kr/learn/courses/30/lessons/132265)

import java.util.*;

class Programmers132265 {
    public int solution(int[] topping) {
        HashSet<Integer> set = new HashSet<>(); // set 생성
        HashMap<Integer, Integer> map = new HashMap<>();    // map 생성
        set.add(topping[0]);    // set에 topping[0] 추가
        for(int i = 1; i < topping.length; i++) {   // 1부터 topping의 길이 전까지
            int num = topping[i];
            map.put(num, map.getOrDefault(num, 0) + 1); // 이미 있는 키면 값 + 1, 없는키면 0으로 map에 추가
        }

        int count = 0;  // 공평하게 자르는 방법의 수
        for(int i = 1; i < topping.length; i++) {   // 1부터 topping의 길이 전까지
            int num = topping[i];
            set.add(num);   // set에 num추가
            int value = map.get(num);
            if(value == 1) { // 만약 value가 1이면
                map.remove(num);    // map에서 해당 num 지움
            } else {    // value가 1이 아니면
                map.put(num, value - 1); // map에 value - 1로 추가
            }

            if(set.size() == map.size()) {  // 만약 set의 크기와 map의 크기가 같으면
                count++;    // count + 1
            }
        }

        return count;   // 최종 리턴
    }
}
