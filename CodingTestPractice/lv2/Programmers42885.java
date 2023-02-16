package lv2;// 구명보트(https://school.programmers.co.kr/learn/courses/30/lessons/42885)

import java.util.*;

class Programmers42885 {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int a = people.length - 1;  // 뒤쪽 인덱스
        int b = 0;  // 앞쪽 인덱스
        while(a >= b) { // a가 b이상일 경우만 반복
            if(people[a] + people[b] <= limit) {    // people[a] + people[b]가 limit 이하이면
                a--;    // a인덱스 - 1
                b++;    // b인덱스 + 1
                count++;    // 구명보트 수 + 1
            } else {    // 아니라면
                a--;    // a인덱스만 -1
                count++;    // 구명보트 수 +1
            }
        }
        return count;   // 구명보트 수 리턴
    }
}
