// 콜라 문제(https://school.programmers.co.kr/learn/courses/30/lessons/132267)

public class Programmers132267 {
    public int solution(int a, int b, int n) {
        int answer = 0; // 총 받은 콜라 수
        int remain = n; // 현재 남아있는 콜라 수
        while(remain >= a) {    // 콜라를 a개 이상 낼 수 있을때까지만 반복
            int get = remain / a  * b;  // 현재 콜라병으로 받을 수 있는 콜라 수
            answer += get;  // 총 받은 콜라 수에 추가
            remain = get + remain % a;  // 이제 남은 콜라 수는 (받은 콜라 수) + (내고 남아 있던 콜라 수)
        }
        return answer;  // 최종 반환환
    }
}
