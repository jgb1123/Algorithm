// https://www.acmicpc.net/problem/1699
/*
주어진 자연수를 제곱수들의 합으로 표현할 때 그 항의 최소 개수를 구하면 되는 문제이다.
문제를 보고 입력 데이터 수도 많아 시간복잡도를 어느정도 고려해야 하고, 문제 스타일이 DP로 풀면 될 것 같아서 DP로 접근했다.
점화식을 찾은 방식은, 일단 13정도까지만 쭉 나열해보며 찾을 수 있다.
어느정도 이하의 난이도들은 이렇게 쭉 나열해보면 점화식 규칙이 보이는 경우가 많은 것 같다.

dp[1]   1*1                     -> 1
dp[2]   1*1 + 1*1               -> 2
dp[3]   1*1 + 1*1 + 1*1         -> 3
dp[4]   2*2                     -> 1
dp[5]   2*2 + 1*1               -> 2
dp[6]   2*2 + 1*1 + 1*1         -> 3
dp[7]   2*2 + 1*1 + 1*1 + 1*1   -> 4
dp[8]   2*2 + 2*2               -> 2
dp[9]   3*3                     -> 1
dp[10]  3*3 + 1*1               -> 2
dp[11]  3*3 + 1*1 + 1*1         -> 3
dp[12]  2*2 + 2*2 + 2*2         -> 3
dp[13]  3*3 + 2*2               -> 2

이렇게 나열해놓고 규칙을 찾아보면,
13의 경우 (13-1*1), (13-2*2), (13-3*3)의 최소 제곱수의 합 + 1로 볼 수 있다.
12의 경우 (12-1*1), (12-2*2), (12-3*3)의 최소 제곱수의 합 + 1로 볼 수 있다.
반복문을 통해 제곱이 해당 값보다 작은 수들의 경우를 모두 확인하며 찾아내면 된다.
자세한 식은 아래 코드를 보면 더 이해가 쉬울 것이다.

DP문제의 점화식을 찾는건 여전히 힘들다.
그래도 점화식만 찾으면 코드는 금방 짤 수 있어서 점화식만 잘 찾으면 되는 것 같다.
좀 더 어려운 DP문제 풀다가 좀 쉬운 DP문제를 푸니 확실히 할만 했던 것 같다.
*/


import java.io.*;

public class baekjoon1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 입력 값
        int[] dp = new int[N+1];    // dp 배열
        dp[1] = 1;  // dp[1]은 1로 초기화
        for (int i = 2; i < N+1; i++) { // dp[2]부터 시작
            dp[i] = i;  // dp[i]는 일단 1*1 i번 더한 횟수로 초기화
            for (int j = 1; j * j <= i; j++) {  // j*j가 i보다 작을때까지만 반복문을 돌며
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);   // 현재 dp[i]와 dp[i-j*j]+1중 작은 값을 dp[i]에 저장
            }                                           // 현재 i값에서 j*j를 빼는 것 이므로 횟수 +1을 해줘야 한다.
        }
        System.out.println(dp[N]);  //최종 dp[N]출력
    }
}