// https://www.acmicpc.net/problem/9461
/*
간단한 dp문제이다.
예시를 조금만 보면 간단한 규칙을 찾을 수 있다.
삼각형의 변의 길이는 [1, 1, 1, 2, 2, 3, 4, 5, 7, 9, 12]와 같이 증가한다.
여기서 규칙을 찾아보면 dp[N] = dp[N-3]+dp[N-2]가 되는 걸 확인할 수 있다.

연산이 반복되는 부분을 최대한 줄이기 위해 각각의 테스트 케이스중에 가장 큰 수를 구하고,
그 수를 기준으로 dp배열을 만들었다.
그리고 각각의 케이스들에 대한 값을 출력하면 된다.
주의해야 할 점은 dp배열을 int로 만들면, 테스트케이스가 100일경우 숫자가 너무 커서 overflow가 생긴다.
그래서 dp배열을 long으로 생성해야 한다.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class baekjoon9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 테스트 케이스의 개수
        ArrayList<Integer> list = new ArrayList<>();    // 테스트 케이스들을 저장할 list

        for(int i = 0; i < N; i++){ // 테스트 케이스들을 입력받아 list에 저장
            list.add(Integer.parseInt(br.readLine()));
        }

        int max = Collections.max(list);    // 테스트 케이스들 중 가장 큰 수를 구함

        long[] dp = new long[max+1];    // dp배열을 그 가장 큰 수 기준으로 만듬(index를 편하게 하기위해 +1)

        dp[1] = 1;  // dp[1]은 1
        if(dp.length>2) dp[2] = 1; // dp배열의 길이가 2보다 크면 dp[2] = 1;
        if(dp.length>3) dp[3] = 1; // dp배열의 길이가 3보다 크면 dp[3] = 1;
        if(dp.length>4){    // 만약 dp배열의 길이가 4보다 크면
            for(int i = 4; i <= max ; i++){ // 찾은 규칙을 통해 Bottom Up 방식으로 구함
                dp[i] = dp[i - 3] + dp[i - 2];
            }
        }
        for (int i : list) {    // 각각의 테스트 케이스로 최종 출력
            System.out.println(dp[i]);
        }
    }
}