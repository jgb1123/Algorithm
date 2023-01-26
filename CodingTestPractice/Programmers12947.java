// 하샤드 수(https://school.programmers.co.kr/learn/courses/30/lessons/12947)

class Programmers12947 {
    public boolean solution(int x) {
        int num = x;
        int sum = 0;
        while(num > 0) {    // 각 자릿수들을 sum에 더함
            sum += num % 10;
            num = num / 10;
        }
        return x % sum == 0;    // (기존 수) / (각 자릿수들을 더한 값)이 나누어 떨어지면 하자드 수
    }
}
