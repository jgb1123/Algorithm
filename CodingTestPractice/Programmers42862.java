// 체육복(https://school.programmers.co.kr/learn/courses/30/lessons/42862)

import java.util.*;
import java.util.stream.*;

class Programmers42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> list = Arrays.stream(lost).boxed().collect(Collectors.toList());  // 최종적으로 체육복을 못 빌린 학생의 번호 list
        Arrays.sort(reserve);   // reserve 오름차순정렬
        Collections.sort(list); // list 오름차순정렬
        boolean[] visit = new boolean[reserve.length];  // reserve와 list의 중복 여부를 체크할 boolean배열
        for(int i = 0; i < reserve.length; i++) {
            if(list.contains(reserve[i])) { // 만약 reserve[i]가 list에 있으면
                list.remove(list.indexOf(reserve[i]));  // list에서 reserve[i]의 값 삭제
                visit[i] = true;    // 중복 여부 true
            }
        }
        for(int i = 0; i < reserve.length; i++) {
            if(!visit[i] && list.contains(reserve[i] - 1)) {    // reserve[i] - 1 이 list에 있으면
                list.remove(list.indexOf(reserve[i] - 1));  // 해당 값 삭제
            } else if(!visit[i] && list.contains(reserve[i] + 1)) { // reserve[i] + 1 이 list에 있으면
                list.remove(list.indexOf(reserve[i] + 1));  // 해당 값 삭제
            }
        }
        int answer = n - list.size();   // 총 인원에서 최종적으로 체육볼을 못 빌린 학생의 수를 뺌
        return answer;  // 결과 리턴
    }
}
