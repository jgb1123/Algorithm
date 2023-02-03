package lv2;// 최솟값 만들기(https://school.programmers.co.kr/learn/courses/30/lessons/12941)

import java.util.*;

class Programmers12941 {
    public int solution(int []A, int []B) {
        Arrays.sort(A); // A 오름차순 정렬
        Arrays.sort(B); // B 오름차순 정렬
        int answer = 0; // 최종 합
        for(int i = 0; i < A.length; i++) {
            answer += A[A.length - i - 1] * B[i];   // A배열은 뒤부터, B배열은 앞부터 순회하며 두 값을 곱한 후 answer에 더함
        }
        return answer;  // 결과 리턴
    }
}
