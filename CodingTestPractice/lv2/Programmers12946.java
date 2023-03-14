package lv2;// 하노이의 탑(https://school.programmers.co.kr/learn/courses/30/lessons/12946)

import java.util.*;

class Programmers12946 {
    static ArrayList<int[]> list;
    public int[][] solution(int n) {
        list = new ArrayList<>();   // 재귀에 사용할 list 생성
        hanoi(1, 2, 3, n);  // n개의 원판을 1에서 시작해서 2를 거쳐 3으로 옮김
        int[][] answer = new int[list.size()][2];   // 재귀를 돌고 난 다음 list의 길이만큼 answer배열 생성
        for(int i = 0; i < list.size(); i++) {  // answer에 list의 값들 저장
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }
        return answer;  // 최종 리턴
    }

    public void hanoi(int a, int b, int c, int n) { // a에서 시작해서 b를 거쳐 c로 옮김
        int[] move = {a, c};
        if(n == 1) list.add(move);  // 만약 n이 1이면 list에 move 추가
        else {  // n이 1이 아니면
            hanoi(a, c, b, n - 1) ; // a c b에 n-1로 재귀
            list.add(move); // list에 move 추가
            hanoi(b, a, c, n - 1);  // b a c에 n-1로 재귀
        }
    }
}
