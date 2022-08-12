// https://www.acmicpc.net/problem/11053
/*
dp로 풀면 된다는걸 파악한 순간 생각보다 간단하게 풀 수 있는 문제이다.
우선 입력받은 수열을 저장할 arr배열을 생성하여 입력받은 수열을 모두 저장한다.
그리고 dp에 사용할 dp배열을 만든다.
index 0  1  2  3  4  5
arr   10 20 10 30 20 50
dp    1  2  1  3  2  4

위와같은 방식으로 진행이 되며, 여기서 규칙을 찾아보면 된다.
2중 for문을 사용하여, (시간복잡도는 O(N^2)이지만, 충분히 시간 내에 통과 가능)
arr[j]가 arr[i]보다 작고, dp[j]가 dp[i]이상일 경우 dp[i] = dp[j]+1이 된다.
이 방법을 이용해 코드를 구현하면 문제풀이는 마무리된다.
*/

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N]; // 입력받은 수열 저장용 배열 생성
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];  // dp에 사용할 배열

        for (int i = 0; i < N; i++) {   // 2중 for문을 돌며
            dp[i] = 1;
            for (int j = 0; j < N; j++) {
                if(arr[j]<arr[i] && dp[j]>=dp[i]){  // 위에서 구한 규칙을 적용
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;    // dp배열중 가장 큰 값 찾기
        for (int i : dp) {
            if(i>max) max = i;
        }
        System.out.println(max);    // 최종 출력
    }
}