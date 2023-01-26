// 콜라츠 추측(https://school.programmers.co.kr/learn/courses/30/lessons/12943)

class Programmers12943 {
    public int solution(int num) {
        long n = num;
        int answer = 0; // 반복 수
        if(n == 1) return 0;    // n이 1이면 0 리턴
        while(true) {
            if(n % 2 == 0){ // 2로 나누어 떨어지면
                n = n / 2;  // n을 2로 나눔
            } else {    // 2로 나누어 떨어지지 않으면
                n = n * 3 + 1;  // n을 3을 곱하고 1을 더함
            }
            answer++;   // 반복 수 + 1
            if(n == 1) {    // 만약 n이 1이 됬으면 반복문 탈출
                break;
            }
            if(answer == 500) { // 만약 500번을 반복해도 1이 안되었으면
                return -1;  // -1리턴턴
            }
        }
        return answer;  // 반복 수 리턴
    }
}
