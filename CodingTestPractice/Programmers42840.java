// 모의고사(https://school.programmers.co.kr/learn/courses/30/lessons/42840)

import java.util.*;

class Programmers42840 {
    public int[] solution(int[] answers) {
        int[] p1 = {1, 2, 3, 4, 5}; // 5
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};    // 8
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};  // 10
        int[] count = {0, 0, 0};    // 각 인원이 맞힌 수
        for(int i = 0; i < answers.length; i++) {   // 각 인원들이 답을 맞췄으면 맞힌 수 +1 (i를 각각의 배열의 길이만큼으로 나눈 나머지에 해당하는 인덱스를 사용하여 반복)
            if(answers[i]==p1[i%5]) count[0] += 1;
            if(answers[i]==p2[i%8]) count[1] += 1;
            if(answers[i]==p3[i%10]) count[2] += 1;
        }
        int max = 0;    // 가장 많이 맞힌 문제 수
        for(int i = 0; i < 3; i++) {    // 가장 많이 맞힌 문제 수를 찾음
            if(max < count[i]) max = count[i];
        }
        ArrayList<Integer> list = new ArrayList<>();    // 문제를 가장 많이 맞힌 인원이 들어갈 ArrayList
        for(int i = 0; i < 3; i++) {
            if(count[i]==max) list.add(i + 1);  // 해당 인원이 가장 많이 맞힌 수라면 list에 추가
        }
        int[] answer = list.stream().mapToInt(i -> i).toArray();    // list를 int[]로 변환

        return answer;  // 최종 반환
    }
}
