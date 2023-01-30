package lv1;// 내적(https://school.programmers.co.kr/learn/courses/30/lessons/70128)

class Programmers70128 {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];  // 두 배열에서 같은 index에 해당하는 값들끼리 곱하여 answer에 더함
        }
        return answer;
    }
}