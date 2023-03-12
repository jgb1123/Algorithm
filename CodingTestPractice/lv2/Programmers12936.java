package lv2;// 줄 서는 방법(https://school.programmers.co.kr/learn/courses/30/lessons/12936)

import java.util.*;

class Programmers12936 {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        long num = 1;   // num은 1
        for(int i = 1; i <= n; i++) {   // 1부터 n까지
            list.add(i);    // list에는 1부터 n까지 저장
            num *= i;   // num은 n!이 됨
        }
        k--;    // 인덱스때문에 k - 1
        int index = 0;  // 현재 인덱스
        while(index < answer.length) {  // index가 answer.length보다 작을때 까지만 반복
            num /= n;   // num에서 n을 나눔
            n--;    // n - 1
            int i = (int)(k / num); // i 는 k / num
            answer[index] = list.get(i);    // 배열 answer의 현재 인덱스에는 list.get(i)의 값을 넣음
            index++;    // index + 1
            list.remove(i); // 저장된 숫자는 list에서 뺌
            k %= num;   // k는 num으로 나눈 나머지
        }
        return answer;  // 최종 리턴
    }
}
