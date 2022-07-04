// https://www.acmicpc.net/problem/4963
/*
지도에서 섬의 개수를 구하는 문제이고, 은근 비슷한 문제들을 풀어본 적이 있어서 쉽게 풀 수 있었다.
조금 다른 점은 인접한 대각선방향의 땅으로도 이동할 수 있고, 그러면 하나의 섬으로 본다는 것이다.
그래서 dx, dy배열을 이용해 차례대로 인접한 12시방향 땅부터 시계방향으로 총 8방향으로 이동할 수 있도록 만들었다.
또한 입력 조건은 지도의 가로세로 크기가 모두 0으로 입력받으면 입력이 종료된다.
그래서 여러 지도들을 while문을 통해 입력받으며 각 지도들의 섬의 개수를 구하다가,
지도의 가로세로의 크기가 만약 모두 0을 입력받으면 while문을 빠져나오도록 구현했다.
최근 DP문제들을 많이 풀어보느라 DFS문제가 오랜만이이라 까먹었을까봐 걱정이 됬지만,
예전에 많이 풀어둔게 도움이 됐는지 생각보다 쉽게 풀렸다. 계속해서 조금씩 성장하는게 느껴진다.
*/

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon4963 {
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};  // x좌표의 이동 방향, 12시방향부터 시계방향으로 8방향
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};  // y좌표의 이동 방향, 12시방향부터 시계방향으로 8방향
    static int[][] arr;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) { // while문을 통해 지도들의 섬의 수들을 구함
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());   // 지도의 가로크기
            int Y = Integer.parseInt(st.nextToken());   // 지도의 세로크기
            if(X==0&&Y==0) break;   // 만약 지도의 가로 세로크기가 모두 0이면 while문을 빠져나온다.
            arr = new int[Y][X];    // 지도를 입력할 배열
            visit = new boolean[Y][X];  // 방문확인을 위한 배열

            for (int i = 0; i < Y; i++) {   // 입력을 받아 지도에 저장
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for (int j = 0; j < X; j++) {
                    arr[i][j] = Integer.parseInt(st2.nextToken());
                }
            }

            int count = 0; // 섬의 개수를 count할 변수
            for (int i = 0; i < Y; i++) {   // 지도의 각 모든지점에서부터 dfs 시작
                for (int j = 0; j < X; j++) {
                    if (!visit[i][j] && arr[i][j] == 1) {   // 땅이면서, 방문하지 않은 땅이면
                        dfs(i, j);  // 탐색 시작
                        count++;    // 탐색 완료되면 섬의 개수 +1
                    }
                }
            }
            sb.append(count).append("\n");  // 모든 좌표에서 dfs탐색이 끝나면 count StringBuilder에 저장
        }
        System.out.println(sb); // while문 종료되면 StringBuilder 최종 출력
    }
    static void dfs(int Y, int X){  // dfs 구현 메서드
        visit[Y][X]=true;   // 해당 땅 방문 완료 처리
        for(int i = 0; i<dx.length; i++){   // 현재 위치에서 인접한 각 8방향의 땅으로 움직이며
            int nX = X+dx[i];
            int nY = Y+dy[i];
            if(nY < arr.length && nY >= 0 && nX < arr[0].length && nX >= 0){    // 만약 지도 내의 있는 좌표이며,
                if(!visit[nY][nX]&&arr[nY][nX]==1) {    // 땅이고, 방문하지 않은 땅이면
                    dfs(nY, nX);    // 해당 좌표로 dfs시작
                }
            }
        }
    }
}