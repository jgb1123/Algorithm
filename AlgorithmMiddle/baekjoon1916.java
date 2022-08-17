// https://www.acmicpc.net/problem/1916
/*
저번에 플로이드 워셜 알고리즘 문제를 접하고 공부를 하면서, 다익스트라라는 알고리즘이 있다는 것도 알게 되었다.
그래서 다익스트라에 대해서 예제들을 보며 공부를 했고, 관련 문제를 찾아서 풀어보았다.
당연히 다익스트라 문제인 것을 알고 있었기 때문에, 공부했던대로 풀이를 하니 풀 수 있었다.
우선순위 큐를 사용하는 방식으로 풀었으며, 이번에 푼 문제는 아주 기본적인 다익스트라 문제였기 때문에 무리없이 풀 수 있었다. (시간은 좀 걸렸다..)
솔직히 다익스트라에 대해서 공부하지 않은 상태에서 이 문제를 접했으면 못 풀었을것 같다.
상세 설명은 아래 코드를 참고하면 된다.

아직 한 문제로는 부족한 것 같다.
그래프 관련 문제들은 맨날 비슷비슷한 dfs bfs 문제만 나와서 살짝 안일하게 생각하고 있었는데,
플로이드 워셜과 다익스트라를 접하면서 반성하게 되었다.
더 다양한 다익스트라 문제와 플로이드 워셜 문제를 풀어봐서 확실히 공부하고 넘어가야겠다.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon1916 {
    static int N, M, startCity, stopCity;
    static ArrayList<Node>[] adj;
    static int[] dist;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 도시 수
        M = Integer.parseInt(br.readLine());    // 버스 노선 수

        getAdjList(br); // 인접리스트 생성 메서드

        StringTokenizer st = new StringTokenizer(br.readLine());
        startCity = Integer.parseInt(st.nextToken());   // 출발 도시
        stopCity = Integer.parseInt(st.nextToken());    // 도착 도시
        visit = new boolean[N+1];   // 방문 여부 확인용 배열 생성
        dist = new int[N+1];    // 최단거리를 담을 배열 생성
        Arrays.fill(dist, Integer.MAX_VALUE);   // dist 배열 가장 큰 값으로 초기화

        dijkstra(); // 다익스트라 구현 메서드

        System.out.println(dist[stopCity]); // 최종 도착 도시의 최단거리 출력
    }

    static void dijkstra() {    // 다익스트라 구현 메서드
        PriorityQueue<Node> pq = new PriorityQueue<>(); // 다익스트라에 사용할 우선순위 큐 pq 생성
        pq.add(new Node(startCity, 0)); // 처음엔 시작 도시와 비용 0으로 시작하기 때문에 해당 Node pq에 저장
        dist[startCity] = 0;    // 시작도시의 최단 거리는 0이다.

        while (pq.size()>0){    // pq에 저장된 요소가 있으면 계속 반복
            Node curNode = pq.poll();   // 현재 노드
            int cur = curNode.stop; // 현재 위치

            if(cur==stopCity) break;    // 현재위치가 도착 도시이면 while문 종료

            if(!visit[cur]) {   // 현재 위치가 아직 방문하지 않은 위치면
                visit[cur] = true;  // 해당 위치 방문 완료 처리
                for (int i = 0; i < adj[cur].size(); i++) { // 반복문을 통해 해당위치의 인접리스트를 순회
                    Node next = adj[cur].get(i);    // 인접리스트에 저장된 해당 위치에서 갈 수 있는 다음 Node
                    if (!visit[next.stop] && dist[next.stop] > dist[cur] + next.cost) { // 다음 노드의 도착지가 아직 방문하지 않았으며,
                                                                                        // 다음 도착지의 최단거리가 (현재 위치의 최단거리 + 다음 Node의 가중치)보다 크면
                        dist[next.stop] = dist[cur] + next.cost;    // 다음 도착지의 최단거리는 (현재 위치의 최단거리 + 다음 Node의 가중치)가 된다.
                        pq.add(new Node(next.stop, dist[next.stop]));   // Node pq에 저장
                    }
                }
            }
        }
    }

    static void getAdjList(BufferedReader br) throws IOException {  // 입력된 값을 통해 인접 리스트를 생성하는 메서드
        adj = new ArrayList[N+1];

        for (int i = 0; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int stop = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj[start].add(new Node(stop, cost));
        }
    }

    static class Node implements Comparable<Node>{  // Node 클래스
        int stop;   // 도착지
        int cost;   // 비용(가중치)

        public Node(int stop, int cost) {
            this.stop = stop;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {  // compareTo를 Override해서 비용을 기준으로 정렬기준을 변경
            return this.cost-o.cost;
        }
    }
}