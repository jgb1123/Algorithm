package lv2;// 숫자 카드 나누기(https://school.programmers.co.kr/learn/courses/30/lessons/135807)

import java.util.*;

class Programmers135807 {
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int a = getResult(arrayA, arrayB);  // arrayA와 arrayB로 실행
        int b = getResult(arrayB, arrayA);  // arrayB와 arrayA로 실행(양쪽 모든 조건을 확인)
        return Math.max(a, b);  // a와 b중 큰 값 리턴
    }

    public int getResult(int[] arr1, int[] arr2) {  // 주어진 조건을 만족하는 가장 큰 정수를 리턴하는 메서드
        int min = arr1[0];    // arr1의 가장 작은 값 min

        ArrayList<Integer> list = new ArrayList<>();    // min의 약수들을 저장할 list
        for(int i = min; i > 0; i--) {  // 내림차순으로 찾아서 list에 저장
            if(min % i == 0) list.add(i);
        }

        int result = 0; // 조건을 만족하는 가장 큰 정수
        loop:
        for(int i = 0; i < list.size(); i++) {  // 가장 큰 약수부터 내림차순으로
            int num = list.get(i);  // 약수
            for(int j = 0; j < arr1.length; j++) {
                if(arr1[j] % num != 0 || arr2[j] % num == 0) continue loop; // 해당 약수가 arr1이랑 나누어 떨어지지 않거나, arr2랑 나누어 떨어지면 continue loop;
            }
            result = num;   // 반복문들 도는동안 continue에 걸리지 않았으면 result는 num
            break;  // 반복문 탈출
        }
        return result;  // result 리턴
    }
}
