// 짝수와 홀수(https://school.programmers.co.kr/learn/courses/30/lessons/12937)

class Programmers12937 {
    public String solution(int num) {
        if(num % 2 == 0) return "Even"; // num이 2로 나누어 떨어지면 "Even" 반환
        return "Odd";   // 아니면 "Odd" 반환
    }
}
