// https://www.acmicpc.net/problem/1463
/*
사실 코드는 굉장히 짧고 간단해 보이지만,
다이나믹 프로그래밍 문제를 처음 풀어보다보니 쉽지 않았다.
이번 문제에서는 Bottom Up방식으로 문제를 접근했다.
나에겐 Bottom Up방식이 편한 것 같은데, 아무래도 Top-down방식으로 풀어야 할 상황도 생길 것 같으니, 두방법 다 연습해야겠다.
일단 메모이제이션을 할 dp배열을 만들었다.
반복문을 통해 dp배열을 모두 순회하며, 그 수까지 갈 수 있는 가장 적은 연산 횟수를 저장한다.
*/

import java.io.*;

public class baekjoon1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 숫자 N을 입력받음
        int[] dp = new int[N+1];    // dp배열 생성 (index때문에 +1해서 만듬)
        dp[1]=0;    // 1일땐 연산 횟수 0
        for(int i = 2; i<=N; i++){
            dp[i] = dp[i-1]+1;  // dp[i]까지의 연산 횟수는, dp[i-1]+1이 될 수 있다. (연산으로 +1을 했을 경우이다)
            if(i%2==0) dp[i] = Math.min(dp[i], dp[i/2]+1);  //만약 i가 2로 나누어 떨어지면,
                                                            //dp[i]는 현재 dp[i]와 dp[i/2]+1중 작은 수로 결정
            if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3]+1);  //만약 i가 3으로 나누어 떨어지면,
                                                            //dp[i]는 현재 dp[i]와 dp[i/3]+1중 작은 수로 결정
        }                                                  //결국 그 수를 만들 수 있는 가장 적은 연산 횟수들이 dp배열에 저장됨
        System.out.println(dp[N]);  // N을 만들 수 있는 가장 적은 연산횟수 출력
    }
}