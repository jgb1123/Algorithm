package lv2;// 기능개발(https://school.programmers.co.kr/learn/courses/30/lessons/42586)

import java.util.*;

class Programmers42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();    // 각 배포때마다 배포되는 기능의 수들을 저장할 list
        int n = 0;  // 인덱스로 사용
        while(n < progresses.length) {  // n이 작업의 길이보다 작을때까지만 반복
            if(progresses[n] < 100) {   // 현재 인덱스의 작업의 진행률이 100보다 작으면
                for(int i = n; i < progresses.length; i++) {    // 현재 작업부터 뒤에있는 모든 작업들의 진행률을 각 작업의 속도만큼 더함
                    progresses[i] += speeds[i];
                }
            } else {    // 현재 인덱스의 작업이 100이상이면
                int count = 0;  // 같이 배포될 작업의 수
                for(int i = n; i < progresses.length; i++) {
                    if(progresses[i] >= 100) {  // 작업률이 100이상이면
                        count++;    // 같이 배포될 작업의 수 + 1
                        n++;    // 인덱스도 + 1
                    } else {    // 만약 작업률이 100미만이면
                        break;  // 반복문 탈출
                    }
                }
                list.add(count);    // 같이 배포되는 작업의 수를 list에 저장
            }
        }
        return list.stream().mapToInt(i->i).toArray();  // list를 int[]로 변환후 리턴
    }
}
