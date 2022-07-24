// https://www.acmicpc.net/problem/2293
/*
일단 각각의 동전을 사용한 경우와 안사용한 경우로 모든 경우의 수를 구하려면, 연산 수는 2^100으로 굉장히 연산이 많아진다.
그래서 비슷한 문제도 경험한 적이 있어서 dp로 접근해야겠다고 생각을 했다.
2차원 dp배열로 접근했다.
아래와 같이 예제로 배열을 만들 수 있었다.
index coin dp  0  1  2  3  4  5  6  7  8  9  10
0     1        0  1  1  1  1  1  1  1  1  1  1      값 1의 동전까지 사용했을 경우의 수
1     2        0  1  2  2  3  3  4  4  5  5  6      값 2의 동전까지 사용했을 경우의 수
2     5        0  1  2  2  3  4  5  6  7  8  10     값 5의 동전까지 사용했을 경우의 수

위와같이 배열을 만들어 보니 규칙이 보였고, 점화식을 만들 수 있을거 같았다.
일단 dp[i][j]는 dp[i-1][j]이고, 거기에 조건에 추가로 더해지는 값이 있다.
만약 j의 값이 해당 동전의 값보다 크면 dp[i][j]는 dp[i-1][j]+dp[i][j-해당 동전 값]과 같고, (1)
j의 값이 해당 동전의 값과 같으면 dp[i][j]는 dp[i-1][j]+1이 된다. (2)
여기서 위 (1)번 점화식 하나로만 하면 dp[i][0]이 0이라 안된다.
(1)번 점화식만 사용하려면 dp[i][0]들을 모두 1로 초기화 한 후 풀면 하나의 점화식만으로도 풀 수 있다.

위와같은 점화식을 통해 코드를 구현하면 된다.

풀고나서 다른 사람들의 풀이를 보니 그냥 1차원 배열로도 해결할 수 있었다. (속도도 약간 더 빠름)
그래도 내겐 아직 그러한 접근방식은 어렵기 때문에 우선은 이렇게 풀고 넘어가자.
*/


import java.io.*;
import java.util.StringTokenizer;

public class baekjoon2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n][k+1];
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i < k+1; i++) {
            if(i%coin[0]==0) dp[0][i]=1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k+1; j++) {
                if(j-coin[i]==0) dp[i][j] = dp[i-1][j]+1;
                else if(j>=coin[i]) dp[i][j] = dp[i-1][j]+dp[i][j-coin[i]];
            }
        }
        System.out.println(dp[n-1][k]);
    }
}