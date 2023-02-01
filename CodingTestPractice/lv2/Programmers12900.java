package lv2;// 2 x n 타일링(https://school.programmers.co.kr/learn/courses/30/lessons/12900)

class Programmers12900 {
    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 1000000007;   // dp[i] = dp[i-2] + dp[i-1]이라는 규칙을 찾으면 됨
        }
        return dp[n];   // 마지막 값 리턴
    }
}
