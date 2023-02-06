package lv2;// 점프와 순간 이동(https://school.programmers.co.kr/learn/courses/30/lessons/12980)

class Programmers12980 {
    public int solution(int n) {
        int count = 0;  // 점프 횟수
        while(n > 0) {
            if(n % 2 == 0) {    // n이 짝수면
                n = n / 2;  // 2로 나눔
            } else {    // 홀수면
                n = n - 1;  // 1을 빼고
                count++;    // 점프 횟수 +1
            }
        }
        return count;   // 점프 횟수 리턴
    }
}
