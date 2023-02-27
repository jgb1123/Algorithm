package lv2;// 귤 고르기

import java.util.*;

class Programmers138476 {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();    // HashMap 생성
        for(int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);   //tagerine[i]의 키가 이미 존재하면 값은 해당 값 + 1, 존재하지 않으면  값은 0 + 1
        }
        List<Integer> keySet = new ArrayList<>(map.keySet());   // 값을 기준으로 내림차순 정렬하기 위해, key들을 list로 생성
        keySet.sort((o1, o2) -> map.get(o2) - map.get(o1));   // 해당 list를 값을 기준으로 내림차순 정렬
        int count = 0;  // 귤의 종류 수
        for(int key : keySet) {
            k -= map.get(key);  // 내림차순으로 정렬되어있으므로, 가장 많은 귤의 수들부터 차례대로 뺌
            count++;    // count + 1
            if(k<=0) break; // k가 0이하가 되면 반복문 탈출
        }
        return count;   // 최종 리턴
    }
}
