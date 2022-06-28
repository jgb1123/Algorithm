// https://www.acmicpc.net/problem/1149
/*
이 문제는 시간복잡도를 고려하지 않고 풀면 무조건 시간초과이다.
DP로 풀어야 했고, 그 규칙을 찾는게 쉽지는 않았다.
하지만 규칙을 찾고 나서 보니 생각보다 간단했다..
일단 2차원 배열 arr에 입력 값(각 집에 칠할 색들의 가격)을 모두 저장하고,
각 요소까지 도달할 수 있는 수 중에서 가장 작은 수를 2차원배열인 dp배열에 저장하면서 Bottom Up방식으로 풀었다.

dp배열의 초기값인 dp[0][0], dp[0][1], dp[0][2]는 arr[0][0], arr[0][1], arr[0][2]와 같다.
그리고 dp[1][0]은, (dp[0][1]과 dp[0][2]중 작은 수) + arr[1][0]가 최솟값이 된다.
계산식으로 만들면, dp[i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2])가 된다.
마찬가지로 dp[i][1] = arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2])가 되고,
dp[i][2] = arr[i][2] + Math.min(dp[i-1][0], dp[i-1][1])이 된다.
이 계산식을 이용해 dp배열에 저장하면서 끝까지 도달하면, 마지막 값들인 dp[N-1]의 값 중 가장 작은 값을 출력하면 된다.
*/

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 칠해야 할 집의 개수

        int[][] arr = new int[N][3];    // 각집에 칠할 색들의 가격들을 2차원배열 arr에 저장
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][3]; // 각 요소까지 도달할 수 있는 수 중에서 가장 작은수를 저장할 dp배열

        dp[0] = arr[0].clone(); // dp배열의 초기값인 dp[0]의 값은 arr[0]와 같다.
        for (int i = 1; i < N; i++) {   // 반복문으로, 찾은 계산식을 통해 각 요소마다 도달할 수 있는 수 중 최소값을 저장함
            dp[i][0] = arr[i][0]+Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = arr[i][1]+Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = arr[i][2]+Math.min(dp[i-1][0], dp[i-1][1]);
        }

        int min = Integer.MAX_VALUE;    // dp배열의 마지막 dp[N-1]의 요소중 가장 작은수를 판별
        for (int i : dp[N-1]) {
            if (min > i) min = i;
        }
        System.out.println(min);    // 최종 최솟값 출력
    }
}