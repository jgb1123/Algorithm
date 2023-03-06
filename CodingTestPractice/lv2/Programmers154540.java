package lv2;// 무인도 여행(https://school.programmers.co.kr/learn/courses/30/lessons/154540)

import java.util.*;

class Programmers154540 {
    static int[] dy = {0, -1, 0, 1};    // 동 남 서 북 순으로 이동
    static int[] dx = {1, 0, -1, 0};    // 동 남 서 북 순으로 이동
    static int sum;
    static int[][] adj;
    static boolean[][] visit;
    public int[] solution(String[] maps) {
        int yLen = maps.length; // y축길이
        int xLen = maps[0].length();    // x축길이

        adj = new int[yLen][xLen];  // 인접행렬 생성
        for(int i = 0; i < yLen; i++) { // 인접행렬에 지도 저장
            for(int j = 0; j < xLen; j++) {
                char c = maps[i].charAt(j);
                if(c == 'X') adj[i][j] = -1;    // 만약 'X'면 -1로 저장
                else adj[i][j] = c - '0';   // 숫자면 숫자로 저장
            }
        }
        
        visit = new boolean[yLen][xLen];    // 방문확인용 배열 생성
        ArrayList<Integer> list = new ArrayList<>();    // 무인도들의 식량 총 량을 저장할 list
        for(int i = 0; i < yLen; i++) { // 모든지점 순회
            for(int j = 0; j < xLen; j++) {
                if(!visit[i][j] && adj[i][j] != -1) {   // 방문하지 않은 좌표이고, 바다가 아니라면
                    sum = 0;    // 해당 무인도의 총 식량 0으로 시작
                    dfs(i, j);  // 해당 좌표로 dfs시작
                    list.add(sum);  // dfs후 총 식량값 list에 저장
                }
            }
        }

        if(list.size() == 0) return new int[]{-1};  // list의 크기가 0이면 무인도는 없으므로 {-1} 리턴
        Collections.sort(list); // 오름차순으로 정렬 후
        int[] answer = new int[list.size()];    // ArrayList to int[] 변환
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;  // 최종 리턴
    }

    public void dfs(int y, int x) { // dfs 구현 메서드
        visit[y][x] = true; // 해당 좌표 방문완료처리
        sum += adj[y][x];   // 총 식량에 해당 좌표의 식량 추가
        for(int i = 0; i < 4; i++) {    // 좌표가 동 남 서 북순으로 이동 (dy, dx배열 이용)
            int ny = y + dy[i]; // 다음 y좌표 ny
            int nx = x + dx[i]; // 다음 x좌표 nx
            if(checkRange(ny, nx) && !visit[ny][nx] && adj[ny][nx] != -1) { // 다음 좌표가 지도 이내의 좌표이며, 방문하지 않았고 바다가 아니라면
                dfs(ny, nx);    // 다음 좌표로 dfs 시작
            }
        }
    }

    public boolean checkRange(int ny, int nx) { // 해당 좌표가 지도 이내의 좌표인지 확인하는 메서드
        return ny >= 0 && nx >= 0 && ny < adj.length && nx < adj[0].length;
    }
}