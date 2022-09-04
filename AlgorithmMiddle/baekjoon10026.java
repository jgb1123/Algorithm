// https://www.acmicpc.net/problem/10026
/*
그래프 탐색 문제로, 어느정도 풀이 방식만 이해하면 어렵지 않게 풀 수 있는 문제이다.
탐색의 경우, 이 문제는 dfs, bfs 둘중 뭐로 풀든 크게 상관 없을 것 같아서, 최근에 그나마 덜 사용해본 dfs로 풀어봤다.

나의 풀이 방법은 다음과 같다.
우선 모든 좌표들을 순회하며, 모든 좌표에서 조건에 따라 탐색을 시작한다.
해당 좌표가 만약 탐색하지 않은 좌표이고, 'R'이면 해당 좌표로 탐색을 시작하고, 탐색이 완료되면 countR++(R의 구역 개수)를 한다.
해당 좌표가 탐색하지 않은 좌표면서 'G'인경우와 'B'인경우도 똑같이 구하면 최종적으로 R의 구역 개수와, G의 구역 개수, B의 구역 개수를 구할 수 있다.
적록색약이 아닌 경우의 총 구역 수는 (R의 구역개수 + G의 구역개수 + B의 구역개수)가 된다.
그리고 방문확인용 배열을 초기화 하고, 똑같이 모든 좌표들을 순회하며 방문하지 않은 좌표이고, R이나 G인 경우에 탐색을 시작한다.
탐색이 완료되면 countRG++(RG가 합쳐진 구역의 개수)를 한다.
최종적으로 적록색약인 경우의 총 구역 수는 (RG가 합쳐진 구역의 개수 + 처음에 구한 B의 구역 개수)가 된다.
자세한 풀이는 아래 코드를 참고하면 된다.

생각보다 간단하게 풀 수 있는 문제였고, 코드를 더 리팩토링하면 좀 더 깔끔하게 구현할 수 있을 것 같지만 그냥 넘어가려고 한다.
*/

import java.io.*;

public class baekjoon10026 {

    static char[][] arr;
    static boolean[][] visit;
    static int[] dy = {0, -1, 0, 1};    // 동 남 서 북순으로 탐색
    static int[] dx = {1, 0, -1, 0};    // 동 남 서 북순으로 탐색
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        getMap(br, N);
        int countR = 0; // R의 구역 개수
        int countG = 0; // G의 구역 개수
        int countB = 0; // B의 구역 개수
        int countRG = 0;    // R과 B가 합쳐진 구역 개수
        visit = new boolean[N][N];  // 방문확인용 배열
        for (int i = 0; i < N; i++) {   // 모든 좌표를 순회하며
            for (int j = 0; j < N; j++) {
                if(!visit[i][j] && arr[i][j] == 'R'){   // 방문하지 않은 좌표이고, 'R'이면
                    dfs('R', i, j); // 해당좌표로 dfs탐색
                    countR++;   // R의 구역 개수 +1
                }
                if(!visit[i][j] && arr[i][j] == 'G'){   // 방문하지 않은 좌표이고, 'G'면
                    dfs('G', i, j); // 해당좌표로 dfs탐색
                    countG++;   // G의 구역 개수 +1
                }
                if(!visit[i][j] && arr[i][j] == 'B'){   // 방문하지 않은 좌표이고, 'B'면
                    dfs('B', i, j); // 해당좌표로 dfs탐색
                    countB++;   // B의 구역 개수 +1
                }
            }
        }
        visit = new boolean[N][N];  // 방문확인용 배열 다시 초기화
        for (int i = 0; i < N ; i++) {  // 모든 좌표를 순회하며
            for (int j = 0; j < N; j++) {
                if(!visit[i][j] && (arr[i][j] == 'R' || arr[i][j] == 'G')){ // 방문하지 않은 좌표이고, 'R'이나 'G'이면
                    dfsRG(i, j);    // 해당 좌표로 dfs탐색 시작
                    countRG++;  // R과 G가 합쳐진 구역 개수 +1
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(countR+countG+countB).append(" ").append(countRG+countB); // 적록색약이 아닌 경우 (R의 구역 개수+G의 구역 개수+B의 구역 개수),
        // 적록색약인 경우 (RG의 구역 개수 + B의 구역 개수)
        System.out.println(sb); //최종 출력

    }

    private static void getMap(BufferedReader br, int N) throws IOException {   // 입력받은 지도를 저장
        arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
    }

    static void dfs(char c, int y, int x){  // 색(c)을 기준으로 탐색하는 dfs 구현 메서드
        visit[y][x] = true;  // 해당 좌표 방문 완료 처리
        for (int i = 0; i < 4; i++) {
            int ny = y+dy[i];   // 다음 y좌표
            int nx = x+dx[i];   // 다음 x좌표
            if(ny>=0 && nx>=0 && ny<arr.length && nx<arr.length && !visit[ny][nx] && arr[ny][nx] == c){ // 다음 좌표가 지도 안에 있으면서, 방문하지 않은 좌표고 탐색을 시작한 색이라면
                dfs(c, ny, nx); // 다음 좌표로 dfs
            }
        }
    }
    static void dfsRG(int y, int x){    // 'R' or 'G'인 경우를 탐색하는 dfs 구현 메서드
        visit[y][x] = true; // 해당 좌표 방문 완료 처리
        for (int i = 0; i < 4; i++) {
            int ny = y+dy[i];   // 다음 y좌표
            int nx = x+dx[i];   // 다음 x좌표
            if(ny>=0 && nx>=0 && ny<arr.length && nx<arr.length && !visit[ny][nx] && (arr[ny][nx] == 'R' || arr[ny][nx] == 'G')){ // 다음 좌표가 지도 안에 있으면서, 방문하지 않은 좌표고 'R' or 'G'라면
                dfsRG(ny, nx);  // 다음 좌표로 dfs
            }
        }
    }
}