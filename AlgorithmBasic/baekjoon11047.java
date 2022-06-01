// https://www.acmicpc.net/problem/11047

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 동전의 종류
        int K = Integer.parseInt(st.nextToken()); // 내야하는 금액
        int remain = K; // 남은 금액
        int count = 0;  // 동전을 낸 횟수
        int[] arr = new int [N];    // 동전의 가치들을 집어넣을 배열 생성
        for(int i = N-1 ; i >= 0  ; i--){   // 동전의 가치들을 내림차순으로 집어넣음
            arr[i] = Integer.parseInt(br.readLine());
        }
        while(remain>0){    // 남은금액이 없을때까지 반복
            for (int j : arr) { // 배열을 처음부터 순회하면서,
                if (j <= remain) {  // 남은금액보다 작은 가치의 동전이 있으면(내림차순이라 작은 가치의 동전 중 제일 큰 동전이 됨)
                    int repeat = remain/j;  // 그 동전으로 몇번까지 낼 수 있는지 확인
                    count += repeat;    // count에 동전 낸 만큼 추가
                    remain -= j*repeat; // 남은 금액에 그 동전으로 총 낸 금액을 빼줌
                    break;  // for문 종료
                }
            }
        }
        System.out.println(count);  // 낸 횟수 출력
    }
}