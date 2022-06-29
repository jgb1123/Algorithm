// https://www.acmicpc.net/problem/1932
/*
생각보다 간단한 DP문제이다.
arr= 7              dp= 30
     3  8               23 21
     8  1  0            20 13 10
     2  7  4  4         7  12 10 10
     4  5  2  6  5      4  5  2  6  5
위의 dp처럼 아래에서부터 둘 중 큰수를 더해가면서 저장하고,
맨 위에있는 dp[0][0]의 값을 구하면 합이 최대가 되는 경로의 합이 된다.

2차원 배열을 만들 때 길이를 dp[0]은 1, dp[1]은 2 이런식으로 반복문내에서 만들면서 진행하면 메모리를 아낄 수 있으나,
그냥 가장 큰 배열의 크기로 맞춰서 한번에 만들면 시간이 조금 단축되서 이렇게 했다.
*/

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];    // 입력 배열을 저장할 arr배열
        int[][] dp = new int[N][N];     // dp 배열

        for(int i = 0; i<N ; i++){  // 입력을 받아 2차원 배열인 arr에 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<i+1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[N-1] = arr[N-1].clone(); // 배열의 맨 아랫줄, dp[N-1] 은 arr[N-1]과 같다.
        for(int i = N-2; i>=0; i--){    // 반복문을 통해 아래에서 2번째 줄부터 연산을 해 나간다.
            for(int j = 0; j<=i; j++){
                dp[i][j] = arr[i][j]+Math.max(dp[i+1][j], dp[i+1][j+1]);    // dp배열 아랫 줄의 2개의 수 중 큰 수를 더해가며 저장
            }
        }
        System.out.println(dp[0][0]);   // 최종적으로 꼭대기에 있는 dp[0][0] 출력
    }
}