// 로또의 최고 순위와 최저 순위(https://school.programmers.co.kr/learn/courses/30/lessons/77484)

import java.util.*;
import java.util.stream.*;

public class Programmers77484 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int count = 0;  // 맞은 번호 수
        int zeroCount = 0;  // 지워진 번호 수
        List<Integer> win_list = Arrays.stream(win_nums).boxed().collect(Collectors.toList());  // int[] to List<Integer>
        for(int i = 0; i < lottos.length; i++) {
            if(win_list.contains(lottos[i])) {  // 만약 번호가 당첨 번호에 포함되어있으면
                count++;    // 맞은 번호 수 + 1
            }
            if(lottos[i] == 0){ // 만약 지워진 번호라면
                zeroCount++;    // 지워진 번호 수 +1
            }
        }
        int[] rank = {6, 6, 5, 4, 3, 2, 1}; // 맞은 번호 개수에 따른 등수
        int max = count + zeroCount;    // 최대로 맞을 수 있는 번호 수
        int min = count;    // 최소로 맞을 수 있는 번호 수

        int[] answer = {rank[max], rank[min]};  // 최고 등수와 최저 등수
        return answer;  // 반환
    }
}