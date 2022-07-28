// https://www.acmicpc.net/problem/1806
/*
교육 동기분에게 투 포인터 알고리즘이라는 것을 듣게 되었다.
왼쪽 포인터와 오른쪽 포인터를 통해 각각 상황에 맞게 하나씩 움직이며 풀어나가는 방식이라고 들었다.
그래서 관련 문제를 풀어보려고 푼 문제이다.
당연히 투 포인터 문제임을 알고 풀었기 때문에 바로 투 포인터로 접근했다.

확실히 투 포인터를 알고리즘 문제라는 것을 알고 푸니 꽤나 간단하게 풀 수 있었으나,
처음 주먹구구식으로 풀어본 방식은 코드가 지저분해서 리팩토링 하는데 시간이 좀 걸렸다.

맨날 비슷한 문제 유형들만 풀다가 조금 새로운 문제 유형을 접하게 되니 흥미로웠다.
아마 다음 투포인터 문제들 부터는 문제를 보고 투 포인터로 접근하면 되겠다라는 것을 생각할 수만 있게 되면,
코드 구현은 어렵지 않으니 간단하게 풀 수 있을거같다.
*/

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 수열의 길이
        int S = Integer.parseInt(st.nextToken());   // 부분합의 비교 기준이 되는 값

        int[] arr = new int[N+1];   // 수열 배열로 생성
       st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int L = 0;  // 왼쪽 포인터
        int R = 0;  // 오른쪽 포인터
        int sum = 0;    // 합
        int length; // 길이
        int min = Integer.MAX_VALUE;    // 최소 길이 int의 max값으로 초기화
        while(R<=N) {   // 오른쪽 포인터가 N보다 작을 때 까지만 반복
            if(sum>=S){ // 만약 S보다 sum이 크면
                sum -= arr[L];  // sum에서 arr[L]을 빼주고
                L++;    // L++
                length = R - L + 1; // 길이는 R-L에 +1을 해줘야 한다. (사실 처음 출력보고 +1 놓쳤던거 알아챔)
                if(length<min) min = length;    // 길이가 최소길이보다 작으면 갱신
            }else{  // 만약 S보다 sum이 작으면
                sum += arr[R];  // sum에 arr[R]을 더해준다
                R++;    // R++
            }
        }
        if(min != Integer.MAX_VALUE) System.out.println(min);   // 최소길이 min이 처음 초기화한 값이 아니면 min출력
        else System.out.println(0); // 처음 초기화한 값 그대로면 0 출력
    }
}