// 정수 내림차순으로 배치하기(https://school.programmers.co.kr/learn/courses/30/lessons/12933)

import java.util.*;

class Programmers12933 {
    public long solution(long n) {
        ArrayList<Long> list = new ArrayList<>();
        while(n>0){ // 정수의 각 자리수들을 list에 저장
            list.add(n%10);
            n = n / 10;
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(list, Collections.reverseOrder()); // list를 내림차순으로 정렬
        for(int i = 0; i < list.size(); i++) {  // sb에 앞에서부터(큰수부터) 저장
            sb.append(list.get(i));
        }
        long answer = Long.parseLong(sb.toString());    // sb를 String으로 변환 후 Long으로 변환
        return answer;  // 최종 반환
    }
}
