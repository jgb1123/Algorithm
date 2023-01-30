package lv1;// 부족한 금액 계산하기(https://school.programmers.co.kr/learn/courses/30/lessons/82612)

class Programmers82612 {
    public long solution(int price, int money, int count) {
        long pay = 0;
        for(int i = 1; i <= count; i++) {
            pay += i*price; // i번째 이용 시 내야 할 금액 pay에 추가
        }

        long answer = pay - money;  // 부족한 금액
        if(answer < 0) return 0;    // 부족한 금액이 0보다 작으면(돈이 부족하지 않으면) 0리턴
        return answer;  // 부족한 금액 리턴
    }
}

