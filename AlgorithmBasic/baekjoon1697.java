// https://www.acmicpc.net/problem/1697
/*
bfs를 사용하면 간단하게 풀 수 있다.
구현 방법은 간단하다.
일반적인 bfs문제와 같이 방문 완료 확인을 위한 visit배열을 사용했다.
또 해당 index까지 가는데 걸린 시간을 저장하기 위한 arr 배열을 사용했다.
그리고 시작지점 N에서부터 bfs를 이용해 탐색을 하며 최종 목적지인 K에 도달하면 bfs를 종료하면 된다.
그리고 arr[K]의 값을 출력하면 K까지 도달하기 위한 최소 거리가 된다.

자세한 설명은 아래 코드를 보면 된다.
 */
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1697 {
    static int N, K, start, end;
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 시작 index
        K = Integer.parseInt(st.nextToken());   // 목표 index
        start = 0;  // 인덱스의 시작 값
        end = 100000;   // 인덱스의 마지막 값
        visit = new boolean[end+1]; // 방문확인용 배열 생성
        arr = new int[end+1];   // 걸린 시간을 저장하기위한 arr배열 생성

        bfs();  // bfs 메서드
        System.out.println(arr[K]); // 최종 K까지 걸린 시간 출력
    }

    private static void bfs() {
        Queue<Integer> Q = new LinkedList<>();  // bfs에 사용할 Queue
        Q.offer(N); // Queue에 시작 지점 저장
        visit[N] = true;    // 시작 지점 방문 완료처리
        while(Q.size()>0){  // Queue의 요소가 비어있을 때까지 반복
            int cur = Q.poll(); // poll한 값이 현재 index
            if(cur== K) {   // 만약 현재 index가 목표지점 K면
                break;  // 반복문 종료
            }
            else {
                if (cur - 1 >= start && !visit[cur-1]) {    // 왼쪽으로 한칸 이동 할 경우(arr범위 내에 있고, 방문하지 않았으면)
                    arr[cur - 1] = arr[cur]+1;  // 해당 방문 index까지의 소요 시간은 현재 index까지 소요 시간 +1
                    Q.offer(cur - 1);   // 해당 index 방문을 위해 Queue에 저장
                    visit[cur - 1] = true;  // 해당 index 방문 완료 처리
                }
                if (cur * 2 <= end && !visit[cur * 2]) {    // 순간이동(현재 인덱스 * 2)를 할 경우(arr범위 내에 있고, 방문하지 않았으면)
                    arr[cur * 2] = arr[cur]+1;  // 해당 방문 index까지의 소요 시간은 현재 index까지 소요 시간 +1
                    Q.offer(cur * 2);   // 해당 index 방문을 위해 Queue에 저장
                    visit[cur * 2] = true;  // 해당 index 방문 완료 처리
                }
                if (cur + 1 <= end && !visit[cur + 1]) {    // 오른쪽으로 한칸 이동 할 경우(arr범위 내에 있고, 방문하지 않았으면)
                    arr[cur + 1] = arr[cur]+1;  // 해당 방문 index까지의 소요 시간은 현재 index까지 소요 시간 +1
                    Q.offer(cur + 1);   // 해당 index 방문을 위해 Queue에 저장
                    visit[cur + 1] = true;  // 해당 index 방문 완료 처리
                }
            }
        }
    }
}