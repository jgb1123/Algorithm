package lv2;// 다음 큰 숫자(https://school.programmers.co.kr/learn/courses/30/lessons/12911)

class Programmers12911 {
    public int solution(int n) {
        int nowCount = countOne(n); // 지금 숫자의 2진법 변환 시 1의 개수
        int nextNumber = n;
        while(true) {
            nextNumber++;   // nextNumber 1씩 증가시키며 반복
            if(nowCount == countOne(nextNumber)) {  // 기존 숫자의 2진법 변환시 1의 개수와, nextNumber의 2진법 변환시 1의 개수가 같으면
                break;  // 반복문 탈출
            }
        }
        return nextNumber;  // nextNumber 리턴
    }
    public int countOne(int n) {    // 해당 숫자를 2진법으로 변환했을 때 1의 개수를 세는 메서드
        int num = n;
        int count = 0;
        while(num > 0) {
            int remain = num % 2;
            num = num / 2;  // 숫자를 2로 나누면서
            if(remain == 1) {   // 나눈 나머지가 1이면 count + 1
                count++;
            }
        }
        return count;   // count 리턴
    }
}
