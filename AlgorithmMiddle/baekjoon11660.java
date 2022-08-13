// https://www.acmicpc.net/problem/11660
/*
그냥 간단한 dp문제라고 생각했다가 고생좀했다. 나는 편의상 xy를 반대로 생각한다.
(y1,x1) 부터 (y2,x2)까지의 합을 구할 때 직사각형 모양의 구간합이 아니라, 차례대로 그 사이 모든 요소들의 합을 해야하는 줄알았다.
그래서 풀고나서 잘못풀었구나 싶어서 다시 풀었고, 다시풀었는데도 결코 쉽진 않았다.

풀이 방법은 다음과 같다.
arr  1  2  3  4    dp   1  3  6  10
     2  3  4  5         3  8  15 24
     3  4  5  6         6  15 27 42
     4  5  6  7         10 24 42 64
(1,1)에서 해당 좌표까지의 직사각형 모향의 구간합인 dp값을 위와 같이 dp배열에 채워넣는다.
여기서 규칙을 찾아보면, dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + arr[i][j]이다.
여기서 dp[i-1][j-1]을 빼는 이유는, 중복되서 2번 더해지는 값이기 때문이다.

그리고 최종적으로, 시작좌표부터 목표좌표까지의 직사각형 모양의 구간합은 다음과 같이 구하면 된다.
문제 예시로 예를 들어보면, 시작좌표 (2,2) 끝좌표 (3,4)인 경우는
dp[3][4](큰 직사각형) - dp[1][4](뺄 직사각형) - dp[3][1](뺄 직사각형) + dp[1][1](직사각형 2번빼면서 중복되서 빠진 값 다시 더해줌)이다.
그림이 있으면 참 설명하기 편할텐데 아쉽다.

정리하자면 구할 직사각형의 구간합은 dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1]이다.
해당 식들을 이용해 코드를 구현하면 된다.
실제 코드 구현 시, 나는 x와 y를 반대로 생각하는게 편해 (startY, startX) (endY, endX)와 같이 표현했다.

난이도도 높지 않아 간단하게 생각했다가 호되게 고생한 문제이다.
이런 dp문제들을 더 많이 경험해봐야 될 것 같다.
*/
import java.io.*;
import java.util.StringTokenizer;

public class baekjoon11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 배열의 크기
        int M = Integer.parseInt(st.nextToken());   // 구할 구간합의 개수

        int[][] arr = new int[N+1][N+1];    // 입력받은 요소들을 저장할 arr배열
        int[][] dp = new int[N+1][N+1];     // dp에 사용할 배열
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());   // 사실 arr배열을 만들지 않고, 아래 dp배열 식에 바로 직접적으로 입력받은 값을 더해도 된다.
                dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + arr[i][j];  // 위 설명에서 구한 식
            }
        }
        int result; // 구간합을 저장할 변수
        for (int i = 0; i < M; i++) {   // 구할 구간합의 개수만큼 반복
            st = new StringTokenizer(br.readLine());    // 구간합 구할 좌표들 입력받아옴
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            result = dp[endY][endX] - dp[startY-1][endX] - dp[endY][startX-1] + dp[startY-1][startX-1]; // 위 설명에서 구한 식
            sb.append(result).append("\n"); // 해당 result값 SB에 저장
        }
        System.out.println(sb);  // 최종 SB출력
    }
}