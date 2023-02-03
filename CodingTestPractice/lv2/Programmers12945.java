package lv2;// 피보나치 수(https://school.programmers.co.kr/learn/courses/30/lessons/12945)

class Programmers12945 {
    public int solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;  // 전값과 전전값의 합을 1234567로 나눈 값을 dp에 저장
        }
        return dp[n];   // dp최종값 리턴
    }
}
