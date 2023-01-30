package lv1;// 자릿수 더하기(https://school.programmers.co.kr/learn/courses/30/lessons/12931)

class Programmers12931 {
    public int solution(int n) {
        int answer = 0;
        while(n>0) {    // 각 자릿수들을 구해서 answer에 더함
            answer += n % 10;
            n = n / 10;
        }
        return answer;  // 최종 반환
    }
}
