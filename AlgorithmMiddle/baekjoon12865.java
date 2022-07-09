// https://www.acmicpc.net/problem/12865
/*
이 문제의 경우 브루트 포스로 풀면, 해당 물건이 있는경우와 없는 경우로 나눠서 볼 수 있다.
근데 그러면 시간복잡도가 O(2^n)이 되므로 연산횟수가 2^100으로 말도 안되게 많아진다.
그래서 DP로 접근해야 했다.

일단 예제를 1차원 dp배열로 만들어 생각해봤다

dp  0  1  2  3  4  5  6  7
    0  0  0  6  8  12 13 14

여기서 점화식을 찾으려고 하니 아무리 생각해도 찾을 수가 없었다.
그래서 좀더 세분화해서 2차원 dp배열로 푸는 방식으로 접근해봤고, 어떻게 세분화 해야 할지 고민을 많이 했다.
결국 아래와 같은 2차원 배열을 만들고 나니 어느정도 규칙이 보였고, 점화식만 찾으면 될 것 같았다.
(1번째 물건만 사용한 경우, 2번쨰 물건까지 사용한 경우, ... 이런식으로 만들었다.)

   w  h   dp 0  1  2  3  4  5  6  7
0  0  0      0  0  0  0  0  0  0  0
1  6  13     0  0  0  0  0  0  13 13
2  4  8      0  0  0  0  8  8  13 13
3  3  6      0  0  0  6  8  8  13 14
4  5  12     0  0  0  6  8  12 13 14

물론 점화식을 찾는것도 간단하지만은 않았다.
간단하게 찾을 수 있는 규칙은 dp[i][j] = dp[i-1][j]이다.
추가적으로 특정 조건에서의 규칙을 더 찾아야 한다.
가장 큰 힌트가 된 부분은 dp[3][7]이다.
dp[3][7] = (3번째 물건의 가치) + dp [3-1][7 - (3번째 물건의 무게)]이다.
따라서 dp[i][j] = v[i] + dp[i-1][j-w[i]]라는 식을 만들 수 있었다.
찾아낸 식들을 통해 풀어보니 통과했다.

1차원 dp배열로 접근해서 낭비한 시간도 많았고, 2차원 dp배열을 어떻게 만들어야 할지 생각한 시간도 너무 오래걸렸다.
사실상 거의 반 노가다 수준으로 푼 문제이고, 정말 힘들게 풀었다.
풀고 다른 사람들의 풀이 코드를 확인해보니, 2차원 dp배열로 푼 방법을 좀 더 간소화해 1차원 dp배열로 푼 사람들이 있었다.
보고나서 감탄이 나왔다.. 당연히 실행 시간은 내가 푼 코드보다 많이 짧았다.

그래도 문제를 풀었다는 것에 의의를 두고, 낙심하지 말자.
*/

import java.io.*;
import java.util.*;

public class baekjoon12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] w = new int[N+1];
        int[] v = new int[N+1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st2.nextToken());
            v[i] = Integer.parseInt(st2.nextToken());
        }
        int[][] dp = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                if(w[i]>j){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}