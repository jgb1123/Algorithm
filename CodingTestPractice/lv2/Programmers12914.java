package lv2;// 멀리 뛰기(https://school.programmers.co.kr/learn/courses/30/lessons/12914)

class Programmers12914 {
    public long solution(int n) {
        int[] dp = new int[n+1];    // dp배열 생성
        dp[1] = 1;  // dp[1]은 1
        if(n>1) {   // dp[2]는 2
            dp[2] = 2;
        }
        for(int i = 3; i <= n; i++) {   // dp[3]부터는 전과 전전의 합을 1234567로 나눈 나머지를 저장
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }
        return dp[n];   // n에 도착할 수 있는 경우의 수가 됨
    }
}
