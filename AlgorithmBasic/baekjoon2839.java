// https://www.acmicpc.net/problem/2839
/*
사실 DP 말고 더 간단하게 푸는 방법이 있지만,
DP를 연습해보기 위해 DP로 풀어봤다.
Bottom Up 방식으로 접근했고, 생각보다 간단하게 풀렸다.
아마 비슷한 접근방식으로 풀어본 문제가 있었어서 그런 것 같다. (baekjoon1463)
*/

import java.io.*;
import java.util.Arrays;

public class baekjoon2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 입력 값
        int[] dp = new int[N+1];    // 입력값 +1의크기를 갖는 dp배열 생성 (3과 5로 해당 숫자를 만들 수 있는 최소 연산 횟수)
        Arrays.fill(dp, -1);    // 배열의 값을 모두 -1로 초기화
        dp[3]=1;    // dp[3]은 1번으로 초기화
        if(N>=5) dp[5]=1;   // 입력값이 5 이상이면 dp[5]는 1번으로 초기화
        for(int i = 6; i<=N; i++){
            if(dp[i-5]!=-1&&dp[i-3]!=-1) dp[i] = Math.min(dp[i-3]+1, dp[i-5]+1); // 만약 dp[i-5]와 dp[i-3] 모두 -1이 아니면(i-5를 만들수 있는 연산이 존재하고, i-3 을 만들 수 있는 연산이 존재하면),
                                                                                 // i의 연산 횟수는 두 수의 (그 수를 만들 수 있는 연산횟수) + 1 중 작은걸로
            else if(dp[i-5]!=-1) dp[i] = dp[i-5]+1; // dp[i-5]의 값이 존재하면 i의 연산 횟수는 (i-5의 연산횟수) + 1
            else if(dp[i-3]!=-1) dp[i] = dp[i-3]+1; // dp[i-3]의 값이 존재하면 i의 연산 횟수는 (i-3의 연산횟수) + 1
        }                                           // 최종적으로 dp[N]에는 N을 만들수 있는 최소의 연산 횟수가 저장됨
        System.out.println(dp[N]);  // 최종 출력 (불가능하면 -1 출력됨)
    }
}
