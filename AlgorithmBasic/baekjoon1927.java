// https://www.acmicpc.net/problem/1927
/*
0이 아닌 숫자들을 입력받으면 배열에 넣고, 0을 입력받으면 배열에서 가장 작은수를 출력하고 해당 수를 배열에서 제거하면 되는 문제이다. (배열에 요소가 없는경우 0출력)
문제의 풀이는 정말 간단하다. 그냥 우선순위 큐를 이용하면 된다.
그냥 우선순위 큐라는게 있다는걸 알려주기 위한 문제정도로만 느껴진다.
해설도 딱히 할게 없으므로 코드를 바로 확인하면 된다.
*/

import java.io.*;
import java.util.PriorityQueue;

public class baekjoon1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());    // 입력되는 수의 개수

        PriorityQueue<Integer> PQ = new PriorityQueue<>();  // 우선순위 큐 생성
        for (int i = 0; i < N; i++) {   // N만큼 반복
            int input = Integer.parseInt(br.readLine());    // 입력 받은 값을 input이라고 함
            if(input == 0){ // 만약 입력값이 0이면,
                if(PQ.size()==0) sb.append(0).append("\n"); // 우선순위큐에 아무 요소도 없으면 0출력
                else sb.append(PQ.poll()).append("\n"); // 그게 아니면 poll한 값 출력(가장 작은 값이 poll됨)
            } else {
                PQ.offer(input);    // 만약 입력값이 0이 아니라면 우선순위큐에 저장
            }
        }
        System.out.println(sb); // 최종 출력력
    }
}