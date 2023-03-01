package lv2;// 테이블 해시 함수(https://school.programmers.co.kr/learn/courses/30/lessons/147354)

import java.util.*;

class Programmers147354 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, new Comparator<int[]>() { // 2차원배열 data를 조건에 맞도록 정렬
            @Override
            public int compare(int[] arr1, int[] arr2) {
                return arr1[col - 1] == arr2[col - 1] ? arr2[0] - arr1[0] : arr1[col - 1] - arr2[col - 1];
                // col번째 컬럼의 값을 기준으로 오름차순 정렬, 만약 그 값이 동일하면 첫번째 컬럼의 값을 기준으로 내림차순 정렬
            }
        });
        int answer = 0; // 누적 XOR값
        for(int i = row_begin; i <= row_end; i++) { // i는 row_begin부터 row_end까지
            int sum = 0;    // i번째 행의 각 컬럼의 값을 i로 나눈 나머지들의 합
            for(int j = 0; j < data[i - 1].length; j++) {
                sum += data[i - 1][j] % i;  // data[i-1][j] % i를 sum에 더함 (인덱스 고려)
            }
            if(i == row_begin) answer = sum;    // 만약 처음 sum 값이면 answer는 sum
            else answer = answer ^ sum; // 처음 sum 값이 아니면 answer는 이전 answer와 sum XOR연산
        }
        return answer;  // 최종 리턴
    }
}