// 두 개 뽑아서 더하기(https://school.programmers.co.kr/learn/courses/30/lessons/68644)

import java.util.*;

public class Programmers68644 {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i+1; j < numbers.length; j++){  // 모든 경우의 수 고려
                int num = numbers[i] + numbers[j];
                if(!list.contains(num)) {   // 만약 num이 list에 없으면
                    list.add(num);  // list에 추가
                }
            }
        }
        Collections.sort(list); // 오름차순 정렬
        int[] answer = list.stream().mapToInt(i -> i).toArray();    // int[]로 변환
        return answer;
    }
}
