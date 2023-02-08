package lv2;// 예상 대진표(https://school.programmers.co.kr/learn/courses/30/lessons/12985)

class Programmers12985 {
    public int solution(int n, int a, int b) {
        int count = 0;
        while(a != b) { // a와 b가 다르다면 반복
            a = (a + 1)/2;  // a의 다음 번호
            b = (b + 1)/2;  // b의 다음 번호
            count++;    // count + 1
        }
        return count;
    }
}
