package lv1;// 나머지가 1이 되는 수 찾기(https://school.programmers.co.kr/learn/courses/30/lessons/87389)

class Programmers87389 {
    public int solution(int n) {
        for(int i = 2; i <= n; i++) {
            if(n % i == 1) {    // n을 i로 나눈 나머지가 1이면
                return i;   // i리턴
            }
        }
        return 0;
    }
}

