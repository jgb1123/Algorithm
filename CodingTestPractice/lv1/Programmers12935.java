package lv1;// 제일 작은 수 제거하기(https://school.programmers.co.kr/learn/courses/30/lessons/12935)

import java.util.*;

class Programmers12935 {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{-1};   // 배열의 길이가 1이면 {-1} 배열 리턴
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {   // 가장 작은 수를 찾음
            if(arr[i] < min) min = arr[i];
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != min) list.add(arr[i]); // 가장 작은수가 아니면 list에 저장함
        }
        int[] answer = list.stream().mapToInt(i -> i).toArray();    // list를 int[]로 변환
        return answer;  // 최종 반환
    }
}
