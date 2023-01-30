package lv1;// 정수 제곱근 판별(https://school.programmers.co.kr/learn/courses/30/lessons/12934)

class Programmers12934 {
    public long solution(long n) {
        long a = (long) Math.sqrt(n);   // n의 제곱근을 정수형으로 저장 (소숫점 아래자리 짤림)
        if (a * a == n) return (long) Math.pow(a + 1, 2);    // a를 다시 제곱한 값이 n과 같으면 n의 제곱근은 정수이므로, a+1의 제곱을 리턴
        return -1L; // 그 외에는 -1리턴
    }
}
