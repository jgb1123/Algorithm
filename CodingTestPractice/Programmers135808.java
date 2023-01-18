// 과일 장수(https://school.programmers.co.kr/learn/courses/30/lessons/135808)

import java.util.*;
class Programmers135808 {
    public int solution(int k, int m, int[] score) {
        Integer[] arr = Arrays.stream(score).boxed().toArray(Integer[]::new);   // 내림차순 정렬을 위해 Integer[] 배열로 변환
        Arrays.sort(arr, Collections.reverseOrder());   // 내림차순으로 정렬
        int len = arr.length;   // 배열의 길이
        int answer = 0; // 최대 이익
        int div = len / m;  // 나머지는 버리기 때문에 상자에 들어가는 사과의 수로 나눈 몫을 구함
        for(int i = m - 1; i < div * m; i = i + m) {    // 나머지는 버리기 때문에 (나눈 몫) * (상자의 용량)까지만 구하면 됨
            answer += arr[i] * m;   // 각 나눠진 구간에서 최솟값은 마지막에 있는 수이므로, (최솟값 * 상자의 용량)이 해당 상자의 이익이 됨
        }
        return answer;  // 결과 리턴
    }
}
