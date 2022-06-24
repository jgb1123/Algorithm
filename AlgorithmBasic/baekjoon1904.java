// https://www.acmicpc.net/problem/1904
/*
사실 처음에 감이 잘 안와서 무식하게 접근했다.
N이 1~6때 까지의 케이스를 다 구해보니,
1 2 3 5 8 13 순으로 늘어나는 걸 확인했다.
피보나치 수열처럼 늘어나고 있었고, 이를 토대로 다시 접근해봤다
N이 만약 4이면,
N이 2일때 가능한 (11, 00)에 00을 붙인 (1100, 0000)이 되고
N이 3일때 가능한 (111, 100, 001)에 1을 붙인(1111, 1001, 0011)이 된다
이런 식으로 피보나치 수열처럼 증하가게 되는 것이다.
그래서 이러한 수열을 DP의 Bottom-Up 방식으로 풀었다.
*/

import java.io.*;

public class baekjoon1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 입력 값
        int[] dp = new int[N + 1]; // dp 풀이를 위한 배열 생성
        dp[1] = 1;
        if (N >= 2) dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 15746; // 피보나치 수열과 같이 구하고, 문제의 조건에 있는 것처럼 15746으로 나눈 나머지를 저장       }
        }
        System.out.println(dp[N]);// 최종 출력
    }
}
