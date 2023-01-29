// 같은 숫자는 싫어(https://school.programmers.co.kr/learn/courses/30/lessons/12906)

import java.util.*;

class Programmers12906 {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);   // 배열의 첫 요소는 list에 집어넣고
        for(int i = 1; i < arr.length; i++) {   // i는 1부터시작
            if(arr[i] != arr[i - 1]) {  // 이전 숫자랑 다르면
                list.add(arr[i]);   // list에 추가
            }
        }
        return list.stream().mapToInt(i -> i).toArray();    // list를 int[]로 변환 후 리턴
    }
}
