// https://www.acmicpc.net/problem/11052
/*
이제는 어느정도 익숙해져서인지 dp로 풀면 되겠다는 생각이 금방 떠오른다.

많은 입력 예시가 있는데, 간단하게 아래 예시로만 봐도 금방 점화식을 찾을 수 있다.
2차원 dp배열과, 각 카드팩의 가격이 있는 value배열을 만들었다.
index value  dp 0  1  2  3  4
0     0         0  0  0  0  0
1     1         0  1  2  3  4   // 1번 카드팩으로만 구매했을때
2     5         0  1  5  6  10  // 2번 카드팩으로만 구매했을때
3     6         0  1  5  6  10  // 3번 카드팩으로만 구매했을때
4     7         0  1  5  6  10  // 4번 카드팩으로만 구매했을때
위 예시에서 점화식을 찾을 수 있었다.
만약 j가 i이상일 경우, dp[i][j] = Math.max(dp[i-1][j], dp[i][j-i] + value[i]) 를 찾을 수 있다.
또 j가 i보다 작으면 dp[i][j] = dp[i-1][j]가 된다.
이 점화식을 토대로 코드를 구현하면 간단하게 풀 수 있다.

자세한 구현 방법은 코드를 확인해보면 된다.

이제 DP문제는 어느정도 익숙해 진 것 같다. 점화식을 찾는것도 이전보다는 훨씬 수월해지고 있다.
물론 어려운 문제를 아직 접하지 못해서 그런 것 이므로, 방심하지말고 꾸준히 해야겠다.
*/


import java.io.*;
import java.util.StringTokenizer;

public class baekjoon11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] value = new int[N+1]; // 각 카드팩의 가격
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][N+1]; // 2차원 dp배열 생성
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if(j>=i) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-i] + value[i]); // 찾은 점화식
                }else{
                    dp[i][j] = dp[i-1][j];   // 찾은 점화식
                }
            }
        }
        System.out.println(dp[N][N]);   // 최종 출력
    }
}