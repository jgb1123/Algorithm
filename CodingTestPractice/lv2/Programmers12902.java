package lv2;// 3 x n 타일링(https://school.programmers.co.kr/learn/courses/30/lessons/12902)

class Programmers12902 {
    public int solution(int n) {
        long[] dp = new long[n+1];
        int div = 1000000007;
        dp[0] = 1;
        dp[2] = 3;
        for(int i = 4; i <= n; i += 2) {    // dp[i] = dp[i-2] * dp[2] + dp[i-4] * 2 + dp[i-6] * 2 + ..... dp [0] * 2 라는 규칙을 찾으면 됨
            dp[i] = dp[i-2] * dp[2];
            for(int j = i - 4; j >= 0; j -= 2){
                dp[i] += dp[j] * 2;
            }
            dp[i] %= div;
        }
        return (int) dp[n]; // 마지막 값 리턴
    }
}
