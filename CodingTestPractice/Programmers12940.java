// 최대공약수와 최소공배수(https://school.programmers.co.kr/learn/courses/30/lessons/12940)

public class Programmers12940 {
    public int[] solution(int n, int m) {
        int max = 0;
        if(n >= m) max = n; // n이 m이상이면 max는 n
        else max = m;   // n이 m보다 작으면 max는 m

        int[] answer = new int[2];  // 최대공약수와 최소공배수를 저장할 배열
        for(int i = max; i > 0; i--) {  // 최대공약수를 찾음 (i는 max부터 1씩 줄이며 반복)
            if(n % i == 0 && m % i == 0) {  // 만약 두 수가 모두 i로 나누어 떨어지면
                answer[0] = i;  // i는 최대공약수
                break;  // 반복문 탈출
            }
        }

        answer[1] = n * m / answer[0];  // (두 수를 곱한 값) / (최대공약수) 는 최소공배수가 됨

        return answer;  // 최종 반환
    }
}
