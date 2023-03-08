package lv2;// 미로 탈출(https://school.programmers.co.kr/learn/courses/30/lessons/159993)

import java.util.*;

class Programmers159993 {
    static char[][] adj;
    static boolean[][] visit;
    static int[] dy = {0, -1, 0, 1};    // 동 남 서 북 순으로 이동
    static int[] dx = {1, 0, -1, 0};    // 동 남 서 북 순으로 이동
    public int solution(String[] maps) {
        int yLen = maps.length; // y축 길이
        int xLen = maps[0].length();    // x축 길이

        adj = new char[yLen][]; // 인접행렬 생성
        for(int i = 0; i < yLen; i++) {
            adj[i] = maps[i].toCharArray();
        }

        int answer = 0; // 총 걸린 시간
        for(int i = 0; i < yLen; i++) { // map 모든 지점 순회, 'S'에서 'L'까지의 최단거리와 'L'에서 'E'까지의 최단거리를 구함
            for(int j = 0; j < xLen; j++) {
                char c = maps[i].charAt(j);
                if(c == 'S') {  // 만약 'S'면
                    visit = new boolean[yLen][xLen];    // 방문확인용 배열 생성
                    int startToLever = bfs(i, j, 'L');   // 'S'에서 'L'까지 이동하는 최단거리를 구함
                    if(startToLever < 0) return -1;  // 만약 최단거리가 음수라면 -1 리턴
                    answer += startToLever;  // answer에 해당 최단거리 저장
                } else if(c == 'L') {   // 만약 'L'이라면
                    visit = new boolean[yLen][xLen];    // 방문확인용 배열 생성
                    int leverToEnd = bfs(i, j, 'E');    // 'L'에서 'E'까지 이동하는 최단거리를 구함
                    if(leverToEnd < 0) return -1;   // 만약 최단거리가 음수라면 -1 리턴
                    answer += leverToEnd;   // answer에 해당 최단거리 저장
                }
            }
        }
        return answer;  // 총 걸린 시간 리턴
    }

    public int bfs(int y, int x, char target) { // 최단거리를 구하기 위한 bfs 구현 메서드(시작 y좌표, 시작 x좌표, 목적지)
        Queue<Location> q = new LinkedList<>(); // bfs에 사용할 Queue 생성
        q.offer(new Location(y, x, 0)); // 시작좌표와, count는 0으로 Location을 생성하여 q에 offer
        visit[y][x] = true; // 해당지점 방문 완료 처리
        while(q.size() > 0) {   // q가 빌때까지 반복
            Location now = q.poll();    // 현재 위치
            if(adj[now.y][now.x] == target) return now.count;   // 만약 현재좌표가 목적지와 같다면, 현재 count 리턴
            for(int i = 0; i < 4; i++) {    // 동 남 서 북순으로 이동
                int ny = now.y + dy[i]; // 다음 y좌표
                int nx = now.x + dx[i]; // 다음 x좌표
                if(checkRange(ny, nx) && adj[ny][nx] != 'X' && !visit[ny][nx]) {    // 다음좌표가 지도 내에 있고, 벽이 아니며 방문하지 않았으면
                    q.offer(new Location(ny, nx, now.count + 1));   // count는 + 1해서 다음 좌표 q에 offer
                    visit[ny][nx] = true;   // 방문 완료 처리
                }
            }
        }
        return -1;  // 목적지에 못갔으면 -1 리턴
    }

    public boolean checkRange(int ny, int nx) {
        return ny >= 0 && nx >= 0 && ny < adj.length && nx < adj[0].length;
    }
    static class Location {
        int y;  // y좌표
        int x;  // x좌표
        int count;  // 해당 좌표까지 걸린시간

        public Location(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
}
