package lv1;// K번째수(https://school.programmers.co.kr/learn/courses/30/lessons/42748)

import java.util.*;

class Programmers42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            int from = commands[i][0];  // array를 from 번째부터
            int to = commands[i][1];    // to 번째까지 자른 후
            int index = commands[i][2]; // 오름차순 정렬한다음 index번째에 해당하는 값을 찾으면 됨

            int[] arr = Arrays.copyOfRange(array, from - 1, to);    // 입력받은 array를 from 부터 to까지 자름 (인덱스 고려)
            Arrays.sort(arr);   // 오름차순정렬
            answer[i] = arr[index-1];   // 자른 배열에서 index - 1 에 해당하는 값 answer에 저장(인덱스 고려)
        }
        return answer;  // 최종 반환
    }
}
