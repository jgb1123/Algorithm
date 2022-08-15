// https://www.acmicpc.net/problem/12851
/*
bfs를 통해 최단거리를 구해야 하는 문제로, 거의 비슷한 문제를 풀어본적이 있다. (baekjoon1697)
(https://github.com/jgb1123/Algorithm/blob/main/AlgorithmBasic/baekjoon1697.java)
풀어봤던 문제의 경우 그냥 최단거리만 구하면 되는 문제였는데,
이 문제에서는 최단거리로 도착할수 있는 방법의 수도 구해야 한다.
이 조건 하나때문에 정말 복잡한 문제가 되었다.

나의 풀이 방법은 다음과 같다.
우선 기존의 풀었던 최단거리만 구하는 문제인 baekjoon1697과 최단거리를 구하는 부분은 거의 비슷하게 구현되었다.
그 다음 추가된 부분은, 최단거리로 도착할 수 있는 방법의 수를 count하기 위한 부분이다.
이 부분은 다음과 같이 구현했다.
visit 배열로 방문 여부를 확인되며, count 배열에는 각 좌표에 도착까지 걸린 최소 시간들을 저장된다.(각 좌표에 도착하기 위한 최단거리 시간만 저장 됨)
그다음 bfs를 돌며 만약 이미 방문한 좌표라도, count에 저장된 최소시간과 같은 시간이 걸렸다면, 그 좌표로도 다시한번 탐색을 하기 위해 Queue에 추가한다.
이렇게 되면 다양한 최단거리 도착 방법들을 count할 수 있다.
자세한 코드 구현 방법은 아래 코드를 참고하면 된다.

저 간단한 조건 하나가 추가되면서 난이도가 많이 올라간 문제였고, 결국 풀어내서 뿌듯하다.
코드를 더 리팩토링하면 성능도 더 개선될 수 있어보이지만,
시간이 생각보다 많이 소비되었기 때문에 우선 풀었다는거에 의의를 두고 넘어가려고 한다.
*/
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon12851 {
    static int N, K, limit, result, resultCount;
    static boolean[] visit;
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        limit = 100000;
        visit = new boolean[limit+1];   // 방문 확인용 배열
        count = new int[limit+1];   // 각 좌표별 최단거리 시간 저장용 배열
        result = 0; // 최단거리 도착 시간
        resultCount = 0;    // 최단거리 도착 방법 수

        bfs();  // bfs로 탐색

        System.out.println(result); // 최단거리 도착 시간 출력
        System.out.println(resultCount);    // 최단거리 도착 방법 수 출력
    }

    static void bfs() { // bfs 메서드
        Queue<Integer> Q = new LinkedList<>();  // bfs에 사용할 Queue
        Q.offer(N); // 시작 지점 Queue에 저장
        visit[N] = true;    // 시작지점 방문완료처리

        while(Q.size()>0){  // Queue가 빌때까지 반복
            int cur = Q.poll(); // 현재 좌표
            if(cur == K){    // 현재 좌표가 목표좌표이면서, 최단거리 도착 시간이 아직 구해지지 않은 상태이면
                result = count[cur];    // 최단거리 도착 시간은 그 현재 좌표의 최단거리 도착 시간
                resultCount++;  // 방법 수 +1
            }
            if(cur*2<=limit && !visit[cur*2] && cur*2 <= K+1){  // cur*2가 limit 이하이면서, 방문하지 않은 좌표이며, cur*2가 K+1이하이면 (마지막 조건은 의미없는 탐색을 줄이기 위해 추가)
                Q.offer(cur*2); // cur*2좌표 탐색을 위해 Queue에 저장
                count[cur*2] = count[cur]+1;    // cur*2좌표까지 걸린 시간은 현재 좌표까지 걸린시간+1
                visit[cur*2] = true;    // cur*2 방문 완료처리
            } else if(cur*2<=limit && visit[cur*2]){    // 이미 방문한 좌표라도
                if(count[cur*2]==count[cur]+1) Q.offer(cur*2);  // 만약 해당 좌표까지의 최단거리 도착 시간이 같다면 추가 탐색을 위해 Queue에 추가 (다양한 최단거리 도착 방법을 count할 수 있게 됨)
            }
            if(cur+1<=K && !visit[cur+1]){  // cur+1이 목표좌표 이하이면서, 방문하지 않은 좌표면
                Q.offer(cur+1); // cur+1 좌표 탐색을 위해 Queue에 저장
                count[cur+1] = count[cur]+1;    // cur+1좌표까지 걸린 시간은 현재좌표까지 걸린시간+1
                visit[cur+1] = true;    // cur+1 방문 완료 처리
            } else if(cur+1<=limit && visit[cur+1]){    // 이미 방문한 좌표라도
                if(count[cur+1]==count[cur]+1) Q.offer(cur+1);  // 만약 해당 좌표까지의 최단거리 도착 시간이 같다면 추가 탐색을 위해 Queue에 추가 (다양한 최단거리 도착 방법을 count할 수 있게 됨)
            }
            if(cur-1>=0 && !visit[cur-1]){  // cur-1이 0이상이면서, 방문하지 않은 좌표면
                Q.offer(cur-1); // cur-1 좌표 탐색을 위해 Queue에 저장
                count[cur-1] = count[cur]+1;    // cur-1좌표까지 걸린 시간은 현재좌표까지 걸린시간+1
                visit[cur-1] = true;    // cur-1 방문 완료 처리
            } else if(cur-1>=0 && visit[cur-1]){    // 이미 방문한 좌표라도
                if(count[cur-1]==count[cur]+1) Q.offer(cur-1);  // 만약 해당 좌표까지의 최단거리 도착 시간이 같다면 추가 탐색을 위해 Queue에 추가 (다양한 최단거리 도착 방법을 count할 수 있게 됨)
            }
        }
    }
}