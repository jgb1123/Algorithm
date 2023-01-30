package lv1;// 두 정수 사이의 합(https://school.programmers.co.kr/learn/courses/30/lessons/12912)

class Programmers12912 {
    public long solution(int a, int b) {
        int max = Math.min(a, b);   // 둘 중 큰수가 max
        int min = Math.max(a, b);   // 둘 중 작은수가 min

        long answer = 0;
        for(int i = min; i <= max; i++) {   // i는 min 부터 max까지 반복
            answer += i;    // answer에 i 더함
        }
        return answer;  // 최종 리턴
    }
}
