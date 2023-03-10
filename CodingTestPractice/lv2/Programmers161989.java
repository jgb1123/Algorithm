package lv2;

import java.util.*;

class Programmers161989 {
    public int solution(int n, int m, int[] section) {
        boolean[] painted = new boolean[n + 1]; // 칠해진 구역을 저장할 boolean형 배열 생성
        Arrays.fill(painted, true); // 모두 칠한 구역 처리
        for(int i = 0; i < section.length; i++) {   // 칠해야 하는 구역들을 순회하며
            painted[section[i]] = false;    // 해당 구역들은 칠해야 하는 구역으로 변경
        }
        int count = 0;  // 칠해야 하는 횟수
        for(int i = 1; i < painted.length; i++) {   // i는 1부터(index 고려) painted.length 전까지
            if(!painted[i]) {   // 칠해지지 않은 구역이라면
                count++;    // 칠해야 하는 횟수 + 1
                for(int j = 0; j < m; j++) {    // 한번에 칠할때 칠해지는 길이만큼
                    if(i + j < painted.length) painted[i+j] = true; // 칠한 구역 처리
                }
            }
        }
        return count;   // 최종 리턴
    }
}
