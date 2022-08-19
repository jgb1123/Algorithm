// https://www.acmicpc.net/problem/1238
/*
오늘도 다익스트라 문제를 풀었고, 좀 더 어려운 난이도의 다익스트라 문제를 풀었다.
왕복 최단거리가 가장 큰 수를 찾는 문제로, 이전 문제들과 좀 다르다.
한 정점에서 여러정점으로의 최단거리와, 여러 정점들에서 한 정점(X 정점)까지의 최단거리를 각각 구해서 그 왕복 거리를 구해야 하는 문제이다.

나의 첫 접근 방식은 다음과 같았다.
X 정점에서 여러 정점까지의 최단거리는 일반적인 다익스트라 문제를 풀듯이 구현했고,
여러 정점들에서 X 정점까지의 최단거리는 for문을 통해서 각 정점들을 시작지점으로 해서 다익스트라를 정점들의 수만큼 반복하도록 구현했었다.
결국 다익스트라는 (1 + 정점의 수)만큼 반복되어야 했다.
이렇게 구현하고나니 통과는 되었지만, 다른 사람들의 풀이를 보니 내 코드의 성능보다 성능이 확연하게 좋은 사람들을 확인할 수 있었다.
여러 정점들에서 X 정점까지의 최단거리들을 구할 때, for문을 통해서 다익스트라를 여러번 반복하는하는게 아니였다.

코드 성능이 좋은 사람들의 구현 방법은 다음과 같았다.
우선 X 정점에서 여러 정점까지의 최단거리는 일반적인 다익스트라 문제를 풀듯이 구현하고,
단방향 간선들을 모두 역방향으로 변경하여 인접리스트를 만들고,
해당 역방향 인접리스트를 사용하여 X 정점을 시작지점으로 다익스트라를 한번만 실행해도 결국 여러 정점에서 X 정점까지의 최단거리들과 같은 결과가 나온다.
결국 다익스트라 2번의 실행으로 풀이가 끝나는 것이다.
풀이를 보고 이렇게까지도 풀 수 있구나라며 감탄을했고, 바로 나도 구현해봤는데 성능이 굉장히 좋아진 것을 확인할 수 있었다.

기존 다익스트라 문제보단 난이도가 좀 있는 문제였지만, 무리없이 풀고 통과할 수 있었다.
풀고나서 다른사람들의 코드를 참고하며, 문제를 풀때 여유가 되면 성능개선에 대한 부분을 좀 더 생각해 봐야겠다는 것을 깨달은 문제였다.
맨 아래 주석처리한 코드는 나의 첫 접근 방식으로 풀이한 코드이다.
*/

import java.io.*;
import java.util.*;
public class baekjoon1238 {
    static int N, M, X;
    static ArrayList<ArrayList<Node>> adj, rAdj;
    static int[] dist;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        getAdjList(br); // 인접리스트 생성 메서드

        dist = new int[N+1];    // 다익스트라 내에서 최단거리 저장용 배열
        visit = new boolean[N+1];   // 방문 확인용 배열

        dijkstra(rAdj);  // 역방향 인접리스트로 다익스트라 실행
        int[] toX = new int[N+1];   // 각 정점들에서 X 정점까지의 최단거리들을 저장할 배열
        for (int i = 1; i < N+1; i++) {
            toX[i] = dist[i];
        }

        dijkstra(adj);   // 정방향 인접리스트로 다익스트라 실행
        int[] fromX = new int[N+1]; // X 정점에서 각 정점까지의 최단거리들을 저장할 배열
        for (int i = 1; i < N+1; i++) {
            fromX[i] = dist[i];
        }

        // 왕복 최단거리중 max값을 찾아서 출력
        int max = 0;
        for (int i = 1; i < N + 1; i++) {
            if(toX[i]+fromX[i]>max) max = toX[i]+fromX[i];
        }
        System.out.println(max);

    }

    static void getAdjList(BufferedReader br) throws IOException {  // 인접리스트 생성 메서드
        adj = new ArrayList<>();    // 정방향 인접리스트
        rAdj = new ArrayList<>();   // 역방향 인접리스트
        for (int i = 0; i < N+1; i++) {
            adj.add(new ArrayList<>());
            rAdj.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adj.get(start).add(new Node(end, weight));
            rAdj.get(end).add(new Node(start, weight)); // 역방향 인접리스트는 시작지점과 도착지점을 반대로 저장
        }
    }
    static void dijkstra(ArrayList<ArrayList<Node>> list) { // 다익스트라 구현 메서드로, 이전 문제들에서 많이 설명했기 때문에 설명 생략
        Arrays.fill(visit, false);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));
        while(pq.size()>0){
            int curVertex = pq.poll().vertex;
            if(!visit[curVertex]){
                visit[curVertex] = true;

                for(Node next : list.get(curVertex)){
                    int nextVertex = next.vertex;
                    int nextWeight = next.weight;
                    if(!visit[nextVertex] && dist[nextVertex] > dist[curVertex] + nextWeight){
                        dist[nextVertex] = dist[curVertex] + nextWeight;
                        pq.offer(new Node(nextVertex, dist[nextVertex]));
                    }
                }
            }
        }
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

/*
public class baekjoon1238 {
    static int N, M, X;
    static ArrayList<ArrayList<Node>> adj;
    static int[] dist;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        getAdjList(br);

        dist = new int[N+1];
        visit = new boolean[N+1];

        int[] toX = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            dijkstra(i);
            toX[i] = dist[X];
        }

        int[] fromX = new int[N+1];
        dijkstra(X);
        for (int i = 1; i < N+1; i++) {
            fromX[i] = dist[i];
        }

        int max = 0;
        for (int i = 1; i < N + 1; i++) {
            if(toX[i]+fromX[i]>max) max = toX[i]+fromX[i];
        }
        System.out.println(max);

    }

    static void getAdjList(BufferedReader br) throws IOException {
        adj = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adj.get(start).add(new Node(end, weight));
        }
    }
    static void dijkstra(int start) {
        Arrays.fill(visit, false);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while(pq.size()>0){
            int curVertex = pq.poll().vertex;
            if(!visit[curVertex]){
                visit[curVertex] = true;

                for(Node next : adj.get(curVertex)){
                    int nextVertex = next.vertex;
                    int nextWeight = next.weight;
                    if(!visit[nextVertex] && dist[nextVertex] > dist[curVertex] + nextWeight){
                        dist[nextVertex] = dist[curVertex] + nextWeight;
                        pq.offer(new Node(nextVertex, dist[nextVertex]));
                    }
                }
            }
        }
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
*/
