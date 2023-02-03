package lv2;// 땅따먹기(https://school.programmers.co.kr/learn/courses/30/lessons/12913)

class Programmers12913 {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];  // 2차원 dp배열 생성
        dp[0] = land[0];    // dp 첫 행은 land 첫 행과 같음

        for(int i = 1; i < land.length; i++) {
            dp[i][0] = land[i][0] + Math.max(dp[i-1][1], Math.max(dp[i-1][2], dp[i-1][3])); // dp배열의 i열의 0번째 행의 값은 이전 행에서 0번째 행이이 아닌 값 중 가장 큰 수와 더함
            dp[i][1] = land[i][1] + Math.max(dp[i-1][0], Math.max(dp[i-1][2], dp[i-1][3])); // dp배열의 i열의 0번째 행의 값은 이전 행에서 1번째 행이이 아닌 값 중 가장 큰 수와 더함
            dp[i][2] = land[i][2] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][3])); // dp배열의 i열의 0번째 행의 값은 이전 행에서 2번째 행이이 아닌 값 중 가장 큰 수와 더함
            dp[i][3] = land[i][3] + Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2])); // dp배열의 i열의 0번째 행의 값은 이전 행에서 3번째 행이이 아닌 값 중 가장 큰 수와 더함
        }

        int max = 0;
        for(int i = 0; i < land[0].length; i++) {   // dp의 마지막 열 중 가장 큰 수 구함
            if(max < dp[dp.length-1][i]) max = dp[dp.length-1][i];
        }
        return max;
    }
}
