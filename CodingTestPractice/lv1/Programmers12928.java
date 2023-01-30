package lv1;// 약수의 함

class Programmers12928 {
    public int solution(int n) {
        int answer = 0; // 약수의 합
        for(int i = 1; i <= n; i++) {   // i는 1부터 n까지 반복
            if(n % i == 0) answer += i; // 만약 n이 i 나누어 떨어지면 i는 약수이므로 answer에 더함
        }
        return answer;  // 최종 반환
    }
}
