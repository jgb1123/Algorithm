// https://www.acmicpc.net/problem/2156
/*
너무 시간을 많이 소비했다.
baekjoon2579 문제와 비슷한 방식으로 풀려고 했다가 시간을 너무 많이 소비했다.
기존에 2579번 문제와의 차이점은 먹고 지나가도 되고, 안먹고 그냥 지나가도 되는 것이였다.
처음에 문제를 보고 마지막 포도주를 먹는것만 필수가 아니라는 차이만 있는 줄 알고 풀었어서 결국 틀렸었고,
왜 틀린지 예외케이스를 찾는데 시간을 너무 소비했다.

결국 코드 자체도 아예 새로 짜게 됐다.
2579문제와 다르게 dp배열을 1개만 이용했다.
고려해야 할 케이스는 3개이다.
해당 와인을 안먹었을 때는, dp[i] = dp[i-1]이 된다.
2번째 전 와인에서 한칸 건너뛰어서 먹었을 때는, dp[i] = dp[i-2]+arr[i]가 된다.
이전와인 해당 와인을 연속해서 먹었을 때는, dp[i] = dp[i-3]+arr[i-1]+arr[i]가 된다.
결국 dp[i]는 dp[i-1], dp[i-2]+arr[i], dp[i-3]+arr[i-1]+arr[i] 중 큰 수가 오면 된다.

물론 baekjoon2579 문제도 비슷한 방식으로 1개의 dp배열을 이용해서 풀 수 있다.
*/

import java.io.*;

public class baekjoon2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N];
        dp[0] = arr[0]; // dp[0]은 arr[0]과 같다.
        if(N>1) {   // dp[1] 초기화
            dp[1] = arr[0]+arr[1];
        }
        if(N>2){
            dp[2] = Math.max(dp[1], Math.max(dp[0] + arr[2], arr[1] + arr[2])); // 적용할 식에 dp[i-3]이 들어가므로, dp[2]까지는 초기화 해놔야 한다.
        }

        for(int i = 3; i<N; i++){   // 반복문을 통해 찾은 식을 이용하여 dp배열을 완성한다
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        }

        System.out.println(dp[N-1]);    // 최종 출력
    }
}
