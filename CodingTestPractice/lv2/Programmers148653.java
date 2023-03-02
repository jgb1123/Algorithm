package lv2;// 마법의 엘리베이터(https://school.programmers.co.kr/learn/courses/30/lessons/148653)

class Programmers148653 {
    public int solution(int storey) {
        int count = 0;  // 이동한 수
        while(storey > 0) { // 0보다 클때까지만 반복
            int num = storey % 10;  // 현재 1의자리 숫자
            int next = storey / 10 % 10;    // 현재 10의자리 숫자
            if(num >= 6) {  // 1의자리 숫자가 6이상이면 올림
                count += 10 - num;  // count에 10 - num을 더하고
                storey = storey / 10 + 1;   // storey는 10으로 나누고 1을 더함 (올림)
            } else if(num <= 4) {   // 1의자리 숫자가 4이하면 내림
                count += num;   // count에 num을 더하고
                storey = storey / 10;   // storey는 10으로 나눔
            } else {    // 1의자리숫자가 5일 경우에는
                if(next >= 5) { // 현재 10의자리 숫자가 5이상이면 올림
                    count += 10 - num;  // count에 10 - num을 더하고
                    storey = storey / 10 + 1;   // storey는 10으로 나누고 1을 더함 (올림)
                } else {    // 현재 10의자리 숫자가 4이하이면 내림
                    count += num;   // count에 num을 더하고
                    storey = storey / 10;   // storey는 10으로 나눔
                }
            }
        }
        return count;   // 최종 리턴
    }
}
