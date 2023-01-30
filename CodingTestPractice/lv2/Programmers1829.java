package lv2;// 카카오프렌즈 컬러링북

class Programmers1829 {
    static int[] dy = {0, 1, 0, -1};    // 동 남 서 북 순으로 이동
    static int[] dx = {1, 0, -1, 0};    // 동 남 서 북 순으로 이동
    static boolean[][] visit;   // 방문 확인용 배열
    static int count;   // 영역의 크기
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;   // 영역의 개수
        int maxSizeOfOneArea = 0;   // 가장 큰 영역의 크기

        visit = new boolean[picture.length][picture[0].length]; // 방문 확인용 배열 생성

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visit[i][j] && picture[i][j] != 0) {    // 아직 방문하지 않았고, 0이 아니라면
                    numberOfArea++; // 영역의 개수 + 1
                    int color = picture[i][j];  // 해당 위치의 색
                    count = 0;  // 영역의 크기 0으로 초기화
                    dfs(i, j, color, picture);  // dfs

                    if(count > maxSizeOfOneArea) maxSizeOfOneArea = count;  // 만약 count가 가장 큰 영역의 크기보다 크면 갱신
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;   // 최종 반환
    }

    public void dfs(int y, int x, int color, int[][] picture) {
        count++;    // 영역의 크기 +1
        visit[y][x] = true; // 방문 완료 처리
        for(int i = 0; i < dy.length; i++){ // 동 남 서 북순으로 이동
            int ny = y+dy[i];
            int nx = x+dx[i];
            if(checkRange(ny, nx, picture) && !visit[ny][nx] && picture[ny][nx] == color) { // 다음 좌표가 지도 범위 이내이고, 방문하지 않았고, 같은 색이면
                dfs(ny, nx, color, picture);   // 다음 좌표로 다시 dfs
            }
        }
    }

    public boolean checkRange(int y, int x, int[][] picture){   // 좌표가 지도 범위 이내인지 체크해주는 메서드
        return y >= 0 && x >= 0 && y < picture.length && x < picture[0].length;
    }
}
