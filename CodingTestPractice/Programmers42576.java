// 완주하지 못한 선수(https://school.programmers.co.kr/learn/courses/30/lessons/42576)

import java.util.*;

class Programmers42576 {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);   // 오름차순 정렬
        Arrays.sort(completion);    // 오름차순 정렬
        for(int i = 0; i < completion.length; i++) {
            if(!completion[i].equals(participant[i])) { // 만약 두 배열에서 같은 인덱스에 해당하는 값이 달라지면
                return participant[i];  // 그 참가자는 완주하지 못함
            }
        }
        return participant[participant.length - 1]; // 반복문을 다 돌고도 완주하지 못한 선수가 안나왔으면, 맨 마지막 선수가 완주하지 못함
    }
}
