// https://www.acmicpc.net/problem/1912
/*
입력 데이터량이 많기 때문에 시간 복잡도를 고려하지 않고 풀면 시간초과가 될 것이다.
문제를 보고 DP로 풀면 되겠다는 생각이 들었고, 지금까지 푼 DP문제중에선 가장 복잡한 문제였던 것 같다.
풀이방법은 출력 예제를 보고 알아낼 수 있었다.
dp 배열을 만들어서, dp배열의 각 인덱스에 수열에서 그 인덱스까지의 합을 저장하고, 그 dp배열을 이용해 풀면 됐다.
예를 들면,
[2, 1, -4, 3, 4, -4, 6, 5, -5, 1] 이라는 수열이 들어오면 dp배열에 그 해당 인덱스까지의 합을 모두 저장한다
[2, 3, -1, 2, 6, 2, 8, 13, 8, 9] 와 같이 dp배열이 만들어지고, 만약 5~7번째 수의 합을 구하려면 dp[6]-dp[4]를 하면 된다.
합의 최대값이 나오는 범위의 합 찾으면 때문에, 반복문을 통해 모든 인덱스를 기준으로 확인한다.
(dp배열의 그 인덱스의 값)-(dp배열의 그 인덱스의 값 이전의 값 중 가장 작은 값)이 합의 최대값이 나오는 범위의 합이다.
*/


import java.io.*;
import java.util.StringTokenizer;

public class baekjoon1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 입력 수열의 개수
        int[] arr = new int[N]; // 입력 수열을 저장할 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++){    // 수열을 arr배열에 저장
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];  // 수열의 해당 인덱스까지의 합들을 저장할 dp 배열
        int sum = 0;
        for(int i = 0; i<N ; i++){  // dp배열에 값들 저장
            sum += arr[i];
            dp[i] = sum;
        }

        int Max = Integer.MIN_VALUE;    // 합이 최대가 되는 범위의 합을 저장할 Max
        int dpMin = 0;  // 해당 인덱스 이전의 값 중에서 가장 작은 값을 0으로 초기화 (0으로 초기화 해야 0번째~i번째 범위의 합일 경우 제대로 계산이 됨)
        for(int i = 0; i<N; i++){   // 반복문을 통해 모든 인덱스를 기준으로 확인
            if(dp[i]-dpMin>Max) Max = dp[i]-dpMin;  // (해당 인덱스의 값)-(해당 인덱스 이전의 값 중 가장 작은 값)이 Max보다 크면 갱신
            if(dp[i]<=dpMin) dpMin = dp[i]; // 해당 인덱스의 값이 dpMin보다 작으면 갱신
        }
        System.out.println(Max);    // Max값 최종 출력
    }
}