package lv2;// 다리를 지나는 트럭(https://school.programmers.co.kr/learn/courses/30/lessons/42583)

import java.util.*;

class Programmers42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayList<Integer> list = new ArrayList<>();    // list에 다리의 길이만큼 0을 채움 (트럭이 없는 빈 공간은 0)
        for(int i = 0; i < bridge_length; i++) {
            list.add(0);
        }

        int n = 0;  // 트럭의 인덱스
        int time = 0;  // 걸린 시간
        int sum = 0;    // 다리 위 트럭들의 총 무게
        do {
            time++; // time + 1
            sum -= list.get(0); // 첫번째 트럭의 무게를 다리 위 트럭들의 총 무게에서 뺌 (트럭이 없으면 0)
            list.remove(0); // 첫번째 트럭 제거
            if(n >= truck_weights.length || sum + truck_weights[n] > weight) {  // 트럭의 인덱스를 넘어갔거나,
                                                                                // (다리위 트럭의 총 무게) + (다음 트럭의 무게)가 weight보다 크면
                list.add(0);    // 0추가 (빈 공간)
            } else {    // 그 외에는
                list.add(truck_weights[n]); // 다음 트럭 다리에 추가
                sum += truck_weights[n];    // 다리 위 트럭의 총 무게에 해당 트럭무게를 더함
                n++;    // 트럭의 인덱스 + 1
            }
        } while(sum != 0);  // 다리의 총 무게가 0이면 반복문 종료
        return time;    // 걸린 시간 리턴
    }
}
