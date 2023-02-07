package lv2;// 배달(https://school.programmers.co.kr/learn/courses/30/lessons/12978)

import java.util.*;

class Programmers12978 {
    public int solution(int N, int[][] road, int K) {
        ArrayList<ArrayList<Node>> adj = getAdj(N, road);   // 인접리스트 생성
        int[] dist = dijkstra(N, adj);  // 다익스트라

        int count = 0;  // K보다 적게걸리는 좌표들의 수를 카운팅함
        for(int i = 1; i < dist.length; i++) {
            if(dist[i] <= K) count++;
        }

        return count;   // count 리턴
    }

    public ArrayList<ArrayList<Node>> getAdj(int N, int[][] road) { // 인접행렬 생성 메서드
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < road.length; i++) {
            int start = road[i][0];
            int stop = road[i][1];
            int cost = road[i][2];
            adj.get(start).add(new Node(stop, cost));   // 양방향
            adj.get(stop).add(new Node(start, cost));   // 양방향
        }
        return adj;
    }

    public int[] dijkstra(int N, ArrayList<ArrayList<Node>> adj) {   // 다익스트라
        boolean[] visit = new boolean[N + 1];   // 방문확인용 배열
        int[] dist = new int[N + 1];    // 최단거리를 저장할 배열
        Arrays.fill(dist, Integer.MAX_VALUE);   // 최단거리는 모두 MAX로
        dist[1] = 0;    // 시작점은 걸린시간 0

        PriorityQueue<Node> pq = new PriorityQueue<>(); // 다익스트라에 사용될 우선순위큐 생성
        pq.offer(new Node(1, 0));   // 시작은 1, 걸린시간은 0

        while(pq.size() > 0) {
            Node curNode = pq.poll();
            int now = curNode.stop; // 지금 좌표
            if(!visit[now]) {   // 방문하지 않은 좌표면
                visit[now] = true;  // 방문처리
                for(Node nextNode : adj.get(now)) { // 갈수있는 지점들을 모두 순회
                    int next = nextNode.stop;   // 다음 좌표
                    int nextCost = nextNode.cost;   // 다음좌표까지 걸리는 시간
                    if(!visit[next] && dist[next] > dist[now] + nextCost) { // 다음 좌표가 방문하지 않았고, 다음좌표까지 걸린 시간이 (지금까지 걸린 시간) + (다음좌표까지 걸리는 시간)보다 크면
                        dist[next] = dist[now] + nextCost;  // 갱신
                        pq.offer(new Node(next, dist[next]));   // 그 지점에서 다시 탐색
                    }
                }
            }
        }
        return dist;
    }
}

class Node implements Comparable<Node> {
    int stop;   // 목적지
    int cost;   // 걸린시간
    public Node(int stop, int cost) {
        this.stop = stop;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {  // 비교기준 Override
        return this.cost-o.cost;
    }
}
