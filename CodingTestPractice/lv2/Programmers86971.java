package lv2;// 전력망을 둘로 나누기(https://school.programmers.co.kr/learn/courses/30/lessons/86971)

import java.util.*;

class Programmers86971 {
    static int[][] adj;
    public int solution(int n, int[][] wires) {
        adj = new int[n+1][n+1];    // 인접행렬
        for(int i = 0; i < wires.length; i++) { // wires의 데이터를 받아와 인접행렬을 채움
            adj[wires[i][0]][wires[i][1]] = 1;
            adj[wires[i][1]][wires[i][0]] = 1;
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < wires.length; i++) { // wires의 전선들을 순회하며
            int a = wires[i][0];    // 전선에 연결된 노드 a
            int b = wires[i][1];    // 전선에 연결된 나머지 노드 b
            adj[a][b] = 0;  // 해당 노드들을 연결해주는 전선을 끊음
            adj[b][a] = 0;  // 반대방향도 끊음
            boolean[] visit = new boolean[n + 1];
            int count1 = bfs(a, visit); // 노드 a에서 bfs
            int count2 = bfs(b, visit); // 노드 b에서 bfs
            if(min > Math.abs(count1 - count2)) min = Math.abs(count1 - count2);    // count1과 count2의 차의 절대값중 최솟값을 구함
            adj[a][b] = 1;  // 전선 다시 연결
            adj[b][a] = 1;  // 반대방향도 연결
        }
        return min; // 최솟값 출력
    }
    public int bfs(int start, boolean[] visit) {    // bfs 구현메서드. start노드에서 이동가능한 노드의 수를 리턴함
        int count = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visit[start] = true;
        while(q.size() > 0) {
            int now = q.poll();
            for(int i = 1; i < adj.length; i++) {
                if(adj[now][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    q.offer(i);
                    count++;
                }
            }
        }
        return count;
    }
}