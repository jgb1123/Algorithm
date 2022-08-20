// https://www.acmicpc.net/problem/1504
/*
이전에 풀었던 문제들과 크게 다른점은 없고, 1번 정점에서 N번 정점까지 주어진 두 정점 V1, V2를 거쳐서 갈 수 있는 최단거리를 구하는 문제이다.
풀이방식은 생각보다 간단했고, 풀이방법은 다음과 같다.
우선 V1를 시작점으로 다익스트라를 통해 각 정점들 까지의 최단거리(distV1 배열)들을 구하고,
V2를 시작점으로 다익스트라를 통해 각 정점들 까지의 최단거리(distV2 배열)를 구한다.
먼저 V1을 먼저 들르고 V2를 들렀다가 N번 정점으로 가는 최단거리(V1V2라고 함)는,
V1에서 1번정점까지의 최단거리 + V1에서 V2까지의 최단거리 + V2에서 N번 정점까지의 최단거리이다.
V2를 먼저 들르고 V1을 들렀다가 N번 정점으로 가는 최단거리(V2V1라고 함)는,
V2에서 1번정점까지의 최단거리 + V2에서 V1까지의 최단거리(사실 가중치가 동일한 양방향 간선이므로 V1에서 V2까지의 최단거리와 같음) + V1에서 N번정점까지의 최단거리이다.

만약 1번 정점에서 N번 정점까지 갈수 있는 방법이 없으면 -1을 출력하면 되는데 갈수 있는 방법이 있는지 확인하는 방법은 다음과 같다.
V1V2를 구할때 필요한 3가지 최단거리 중 여전히 Integer.MAX_VALUE가 있을 경우 V1V2는 갈 수 없는 방법이 된다. (V2V1도 같은 방법으로 확인)
V1V2, V2V1 두가지 방법 모두 갈 수 있는 방법이 있으면 두가지 방법중 최단거리가 작은 값을 출력하면 되고,
한가지 방법으로만 갈 수 있는 경우 갈 수 있는 방법의 값만 출력하면 되며,
두가지 방법 모두 갈 수 없는 방법이라면 -1을 출력하면 된다.

최근 다익스트라 문제를 많이 풀어봤는데, 사실 다익스트라 문제들은 문제를 딱 보면 다익스트라 문제라는게 눈에 보인다.
그래서 이정도 수준이면 내가 원하는 수준까지는 된 것 같고, 좀 더 다른 유형의 문제가 나와도 조금씩만 변형해서 풀면 되는 것 같다고 느껴진다.
그래서 이제 다른 알고리즘 문제를 접해봐야겠다는 생각이 들었다.
*/
import java.io.*;
import java.util.*;

public class baekjoon1504 {
    static int N, E, V1, V2;
    static ArrayList<ArrayList<Node>> adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 정점 수
        E = Integer.parseInt(st.nextToken());   // 간선 수

        getAdjList(br); // 양방향 인접리스트 생성


        st = new StringTokenizer(br.readLine());
        V1 = Integer.parseInt(st.nextToken());  // 꼭 경유해야 하는 V1 정점
        V2 = Integer.parseInt(st.nextToken());  // 꼭 경유해야 하는 V2 정점

        int[] distV1 = dijkstra(V1);    // V1정점에서 다익스트라를 통해 각 정점까지의 최단거리들을 구함
        int[] distV2 = dijkstra(V2);    // V2정점에서 다익스트라를 통해 각 정점까지의 최단거리들을 구함

        print(distV1, distV2);  // 최종 출력 메서드


    }

    static void getAdjList(BufferedReader br) throws IOException {  // 양방향 인접리스트 생성 메서드
        adj = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adj.get(start).add(new Node(end, weight));
            adj.get(end).add(new Node(start, weight));
        }
    }

    static int[] dijkstra(int start) {  // 다익스트라 구현 메서드로, 이전 풀어본 문제들에서 많이 설명했기 때문에 생략
        boolean[] visit = new boolean[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while(pq.size()>0){
            Node cur = pq.poll();
            if(!visit[cur.vertex]){
                visit[cur.vertex] = true;
                for (Node next : adj.get(cur.vertex)) {
                    if(!visit[next.vertex] && dist[next.vertex] > dist[cur.vertex] + next.weight){
                        dist[next.vertex] = dist[cur.vertex] + next.weight;
                        pq.offer(new Node(next.vertex, dist[next.vertex]));
                    }
                }
            }
        }
        return dist;
    }

    static void print(int[] distV1, int[] distV2) { // 최종 출력 메서드
        boolean existV1V2 = false;  // 1번 정점에서 N번 정점까지 V1, V2를 경유해서 갈 수 있는 방법(V1V2)이 존재하는지
        boolean existV2V1 = false;  // 1번 정점에서 N번 정점까지 V2, V1을 경유해서 갈 수 있는 방법(V2V1)이 존재하는지
        int V1V2 = 0;   // V1V2 최단거리 초기화
        int V2V1 = 0;   // V2V1 최단거리 초기화
        if (distV1[1] != Integer.MAX_VALUE && distV1[V2] != Integer.MAX_VALUE && distV2[N] != Integer.MAX_VALUE) {  // 위에서 설명한 V1V2를 구하는 최단거리들 중 Integer.MAX_VALUE값이 없으면
            V1V2 = distV1[1] + distV1[V2] + distV2[N];  // V1V2는 존재하는 방법이므로 위에서 설명한 방법대로 구함
            existV1V2 = true;   // V1V2 방법 존재
        }
        if (distV2[1] != Integer.MAX_VALUE && distV2[V1] != Integer.MAX_VALUE && distV1[N] != Integer.MAX_VALUE) {  // 위에서 설명한 V2V1을 구하는 최단거리들 중 Integer.MAX_VALUE값이 없으면
            V2V1 = distV2[1] + distV2[V1] + distV1[N];  // V2V1은 존재하는 방법이므로 위에서 설명한 방법대로 구함
            existV2V1 = true;   // V2V1 방법 존재
        }
        if (existV1V2 && existV2V1) System.out.println(Math.min(V1V2, V2V1));   // 두가지 방법 다 존재하면 두가지 방법의 최단거리중 작은 값 출력
        else if (existV1V2) System.out.println(V1V2);   // V1V2만 존재하면 V1V2 출력
        else if(existV2V1) System.out.println(V2V1);    // V2V1만 존재하면 V2V1 출력
        else System.out.println(-1);    // 두가지 방법 모두 존재하지 않으면 -1 출력
    }

    static class Node implements Comparable<Node>{
        int vertex;
        int weight;
        public Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }
}