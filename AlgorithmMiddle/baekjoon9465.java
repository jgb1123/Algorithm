// https://www.acmicpc.net/problem/9465
/*
코로나 확진으로 몸상태가 굉장히 안좋다. 그래서 아마 해설이 짧을 것이다.
일단 dp로 접근해야 된다는걸 찾아낸 순간 간단하게 풀 수 있는 문제이다.
문제 예시를 예로 들어서 생각해보면 된다.
50  10  100 20  40
30  50  70  10  60

50  40  200 160 250
30  100 140 210 260
위와 같이 진행되며 간단하게 보면 해당 지점에서의 값은 왼쪽 위 대각선과의 합, 왼쪽 아래 대각선과의 합으로 생각할 수 있으나, 한가지를 더 고려를 해야한다.
바로 2칸전 위 대각선과의 합, 2칸전 아래 대각선과의 합도 생각해줘야 한다는 것이다. 여기까지만 설명읃 들어도 이해할 수 있을 것이다.

따라서 점화식은, Math.max(dp[1][j-1],dp[1][j-2]) + arr[0][j]와,
Math.max(dp[0][j-1],dp[0][j-2]) + arr[1][j]로 만들 수 있다.

해당 점화식을 통해 구현을 하면 된다.
*/
import java.io.*;
import java.util.StringTokenizer;

public class baekjoon9465 {
    static int[][] dp, arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());    // 테스트케이스 개수
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());    // 열의 개수

            dp = new int[2][n+1];   // dp용 배열

            arr = new int[2][n+1];  // 입력받은 비용을 저장할 arr배열
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 1; k < n+1; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = arr[0][1];   // dp배열의 초기값을 설정한다.
            dp[1][1] = arr[1][1];   // dp배열의 초기값을 설정한다.
            for (int j = 2; j < n+1; j++) { // 찾은 점화식을 통해 dp알고리즘을 적용한다.
                dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2])+arr[0][j];
                dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2])+arr[1][j];
            }
            sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");   // 마지막 요소들중 큰 수를 StringBuilder에 저장한다
        }
        System.out.println(sb); // 최종적으로 StringBuilder에 저장된 값들을 출력한다.
    }
}