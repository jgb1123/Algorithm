// https://www.acmicpc.net/problem/11048
/*
생각보다 간단한 dp문제이다.
dp배열 채워 나갈 때, dp배열의 초기 값만 잘 세팅하면 간단하게 풀 수 있다.
한가지 함정이 하나 있는데, (r+1, c+1)로 이동하는 경우는 신경쓰지 않아도 된다.
왜냐면 대각선으로 한번에 이동하는 것보다, 오른쪽 한번 아래 한번 이런식으로 움직여야 최대값을 구할 수 있기 때문이다.
(물론 저 경우를 고려 해도 실행 시간만 늘어날 뿐, 결과에는 문제 없다.)
우선 지도를 저장할 2차원 arr배열을 만들고, dp에 사용할 2차원 dp배열도 만든다.
첫 가로줄과, 첫 세로줄은, 이 전의 값과 현재 좌표의 값을 더하면서 채워 나간다.
arr  1 2 3 4    dp 1 3 6 10
     0 0 0 5       1
     9 8 7 6       10

그리고 (1,1)좌표부터는 왼쪽 값과 위에 값 중 큰 값을 현재 좌표의 값에 더하면서 dp배열을 완성하면 된다.
arr  1  2  3  4    dp 1  3  6  10
     0  0  0  5       1  3  6  15
     9  8  7  6       10 18 25 31
그리고 마지막 (N-1, M-1)의 값을 출력하면 된다.
*/

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon11048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];    // 지도를 저장할 arr배열
        int[][] dp = new int[N][M];     // dp풀이를 위한 dp배열

        for (int i = 0; i<N; i++){  // 입력을 받아와 arr배열에 저장한다
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++){
                arr[i][j]=Integer.parseInt(st2.nextToken());
            }
        }
        dp[0][0]=arr[0][0]; // 첫 시작점은 arr와 같다.

        for(int i = 1; i<N; i++){   // dp배열의 첫 세로줄을 모두 채운다
            dp[i][0] =arr[i][0]+dp[i-1][0];
        }
        for(int i = 1; i<M; i++){   // dp배열의 첫 가로줄을 모두 채운다
            dp[0][i]=arr[0][i]+dp[0][i-1];
        }

        for(int i = 1; i<N; i++){   // 반복문을 통해 (1,1)부터 왼쪽값인 dp[i][j-1]과 위값인 dp[i-1][j]중 큰 값을 현재의 값에 더하며 dp배열에 저장한다.
            for(int j = 1; j<M; j++){
                dp[i][j] = arr[i][j]+Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        System.out.println(dp[N-1][M-1]);   // 마지막 지점의 값을 출력한다.
    }
}