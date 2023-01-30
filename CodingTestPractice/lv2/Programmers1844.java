package lv2;// 게임 맵 최단거리(https://school.programmers.co.kr/learn/courses/30/lessons/1844)

import java.util.*;

class Programmers1844 {
    static int[] dy = {0, 1, 0, -1};    // 동 남 서 북 순으로 이동
    static int[] dx = {1, 0, -1, 0};    // 동 남 서 북 순으로 이동
    static boolean[][] visit;
    public int solution(int[][] maps) {
        visit = new boolean[maps.length][maps[0].length];   // 방문 확인용 배열 생성
        return bfs(maps);
    }
    public int bfs(int[][] maps) {
        Queue<Location> qu = new LinkedList<>();
        qu.offer(new Location(0, 0, 1));    // (0,0)에서 이동횟수 1로 시작
        visit[0][0] = true; // (0,0) 방문 완료처리
        while(qu.size() > 0) {
            Location now = qu.poll();
            int y = now.y;  // 현재 y위치
            int x = now.x;  // 현재 x위치
            if(y == maps.length - 1 && x == maps[0].length - 1) {   // 맵 끝에 도착했으면
                return now.count;   // 지금의 count 리턴
            }
            for(int i = 0; i < 4; i++) {    // 동 남 서 북으로 이동
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(checkRange(ny, nx, maps) && !visit[ny][nx] && maps[ny][nx] == 1) {   // 다음 좌표가 지도 범위 이내이고, 방문하지 않았고, 1이면
                    qu.offer(new Location(ny, nx, now.count + 1));  // 다음 좌표로 Queue에 저장
                    visit[ny][nx] = true;   // 다음 좌표 방문 완료처리
                }
            }
        }
        return -1;  // bfs 수행 후 맵 끝에 도달하지 못했으면 -1 리턴
    }
    public boolean checkRange(int y, int x, int[][] maps) {
        return y >= 0 && x >= 0 && y < maps.length && x < maps[0].length;
    }
}
class Location {    // 위치에 대한 정보가 들어있는 class
    int y;  // y축
    int x;  // x축
    int count;  // 이동 횟수
    public Location(int y, int x, int count) {
        this.y = y;
        this.x = x;
        this.count = count;
    }
}
