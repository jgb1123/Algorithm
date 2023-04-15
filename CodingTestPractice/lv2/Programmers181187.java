package lv2;// 두 원 사이의 정수 쌍(https://school.programmers.co.kr/learn/courses/30/lessons/181187)

class Programmers181187 {
    public long solution(int r1, int r2) {
        long answer = 0;    // 조건을 만족하는 정수 좌표의 수
        long r2r2 = (long) r2 * (long) r2;  // r2의 제곱 long으로
        long r1r1 = (long) r1 * (long) r1;  // r1의 제곱 long으로
        // 전체의 1/4만 구한 후 * 4를 곱하는 방식
        for(long i = 0; i < r2; i++) {  // i 는 0부터 r2보다 작을때까지
            if(i == 0) {    // i가 0이면
                answer += r2 - r1 + 1;  // answer에 r2 - r1 + 1을 더함
            } else if(i >= r1) {    // i가 r1이상일 경우
                answer += (int) Math.sqrt(r2r2 - i * i);    // answer에 (r2^2 - i^2)의 제곱근(소숫점 버림)을 더함
            } else {    // i가 r1보다 작을경우 (i가 r1보다 작으면 반지름이 r1인 원 안에 있는 점들의 수는 빼야됨)
                answer += (int) Math.sqrt(r2r2 - i * i) - (int) Math.ceil(Math.sqrt(r1r1 - i * i)) + 1; // answer에 ((r2^2 - i^2)의 제곱근(소숫점 버림)) - ((r1^2 - i^2)의 제곱근(소숫점 올림)) + 1을 더함
            }
        }
        return answer * 4;  // 전체의 1/4만 구했으므로 answer * 4 리턴
    }
}