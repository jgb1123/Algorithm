// https://www.acmicpc.net/problem/1753
/*
이전에 풀었던 baekjoon1916문제와 거의 똑같은 문제이다.
(https://github.com/jgb1123/Algorithm/blob/main/AlgorithmMiddle/baekjoon1916.java)
풀이 방법은 거의 동일하고, 자세한 풀이는 아래 코드만 참고하면 된다.

다익스트라에 대해 좀 익숙해지기위해 관련 문제들을 더 풀어보려고 푼 문제인데, 이전에 푼 문제와 거의 비슷하다.
다익스트라 문제는 다 비슷한가..?라는 의문이 들었고, 다음엔 좀 더 높은 난이도에서의 문제를 하나 더 풀어봐야겠다.
그래도 한번 더 풀어보니 더 확실하게 이해할 수 있어서 좋았다.
이런 문제는 까먹지 않고 나중에도 잘 풀 수 있을 것 같다.
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon1753 {
    static int V, E, start;
    static ArrayList<ArrayList<Node>> adj;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());   // 정점 수
        E = Integer.parseInt(st.nextToken());   // 간선 수
        start = Integer.parseInt(br.readLine());    // 시작 지점

        getAdjList(br); // 인접리스트 생성 메서드

        dijkstra(); // 다익스트라 구현 메서드

        print();    // 최종 출력 메서드
    }

    static void getAdjList(BufferedReader br) throws IOException {  // 인접리스트 생성 메서드
        adj = new ArrayList<>();
        for (int i = 0; i < V+1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            int w = Integer.parseInt(st2.nextToken());
            adj.get(u).add(new Node(v, w));
        }
    }

    static void dijkstra() {    // 다익스트라 구현 메서드
        dist = new int[V+1];    // 최단거리 저장용 배열
        boolean[] visit = new boolean[V+1]; // 방문 확인용 메서드
        Arrays.fill(dist, Integer.MAX_VALUE);   // 최단거리 배열 Integer.MAX_VALUE로 초기화
        dist[start] = 0;    // 시작지점의 최단 거리는 0
        PriorityQueue<Node> pq = new PriorityQueue<>(); // 다익스트라에 사용할 우선순위 큐 pq
        pq.offer(new Node(start, 0));   // 시작지점과 가중치는 0으로 pq에 저장
        while(pq.size()>0){ // pq의 요소가 없어질 때까지 반복
            Node curNode = pq.poll();   // pq에서 꺼내온 노드가 현재 노드
            int curVertex = curNode.vertex; // 현재 정점
            if(!visit[curVertex]) { // 현재 정점이 아직 방문하지 않은 정점이면
                visit[curVertex] = true;    // 해당 정점 방문완료처리
                for (Node nextNode : adj.get(curVertex)) {  // 해당 정점의 인접리스트에 저장된 노드들을 순회하며
                    int nextVertex = nextNode.vertex;   // 다음 갈 정점
                    int nextWeight = nextNode.weight;   // 다음 정점까지의 가중치
                    if (!visit[nextVertex] && dist[nextVertex] > dist[curVertex] + nextWeight) {    // 아직 방문하지 않은 정점이고,
                                                                                                    // 다음 정점까지의 최단거리가 (지금 정점의 최단거리 + 다음 정점까지의 가중치)보다 크면
                        dist[nextVertex] = dist[curVertex] + nextWeight;    // 다음 정점까지의 최단거리 = 지금 정점의 최단거리 + 다음 정점까지의 가중치
                        pq.offer(new Node(nextVertex, dist[nextVertex]));   // 다음 정점과, 다음 정점까지의 현재 최단거리 pq에 저장
                    }
                }
            }
        }
    }

    static void print() {   // 최종 출력 메서드
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < dist.length; i++) { // dist 배열을 index 1부터순회하며
            if(dist[i]==Integer.MAX_VALUE) sb.append("INF\n");  // 해당 인덱스의 값이 여전히 Integer.MAX_VALUE 값이면 "INF" sb에 저장
            else sb.append(dist[i]).append("\n");   // 아니면 해당 인덱스의 값 sb에 저장
        }

        System.out.println(sb); // 최종sb출력
    }

    static class Node implements Comparable<Node>{
        int vertex; // 목적지 정점
        int weight; // 목적지 정점까지의 가중치
        public Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o){   // 정렬 기준을 가중치 기준으로 설정
            return this.weight - o.weight;
        }
    }
}