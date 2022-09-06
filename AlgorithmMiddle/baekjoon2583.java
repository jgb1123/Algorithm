// https://www.acmicpc.net/problem/2583
/*
좀만 생각해보면 간단하게 풀 수 있는 탐색 문제이다.
그나마 좀 힘들었던 부분은, 나는 기존에 좌표를 볼때 지도 왼쪽 위가 (0,0)이고 (y,x)로 푸는게 편해서 그렇게 풀어왔는데, 이번 문제에서 대놓고 (x,y)로 풀라고 제시를 해서 그렇게 한번 풀어봤다.
(물론 이 문제조차 (y,x)로 풀 수 있긴 하지만, 예시 지도 그림부터 왼쪽 아래가 (0,0)으로 시작하며 (x,y)로 보라고 해놓았다.)
갑자기 바꿀라고 하니까 약간 헷갈리는 부분이 있어 신중하게 풀 수밖에 없었고, 물론 문제 자체는 어려운 문제는 아니였다.

풀이 방법은 간단하다.
우선 주어진 직사각형의 왼쪽 아래 꼭지점 좌표와, 오른쪽 위 꼭지점 좌표를 받아와 해당 직사각형 내에 해당하는 좌표는 모두 1로 처리를 한다.
(2중 for문을 이용하면 간단하게 구현할 수 있으며, 아래 코드 참고)

그리고 2중 for문으로 모든 좌표를 순회하며, 0(1이 아님)이면서 방문하지 않은 좌표면 해당 좌표로 dfs를 통한 탐색을 시작한다.
해당 좌표로 탐색이 끝나면 count(구역 수)+1을 하고, 탐색 중 다음 좌표로 넘어갈 수 있는 조건이 되면 area(넓이)+1를 한다.
탐색 시 다음좌표는 dy, dx 배열을 통해 인접한 좌표로 이동할 수 있도록 구현하였다.

최종적으로 count(구역 수)와 area(넓이)들을 출력하면 된다.
*/

import java.io.*;
import java.util.*;

public class baekjoon2583 {
    static boolean[][] visit;
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int M, N, K, area;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());   // Y좌표 길이
        N = Integer.parseInt(st.nextToken());   // X좌표 길이
        K = Integer.parseInt(st.nextToken());   // 직사각형 수

        visit = new boolean[N][M];  // 방문 확인용 배열
        arr = new int[N][M];    // 지도를 저장할 배열

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());  // 왼쪽 아래 꼭지점의 x좌표
            int y1 = Integer.parseInt(st.nextToken());  // 왼쪽 아래 꼭지점의 y좌표
            int x2 = Integer.parseInt(st.nextToken());  // 오른쪽 위 꼭지점의 x좌표
            int y2 = Integer.parseInt(st.nextToken());  // 오른쪽 위 꼭지점의 y좌표

            for (int j = x1; j < x2; j++) { // 왼쪽아래 꼭지점의 x좌표 부터 오른쪽 위 꼭지점의 x좌표 이전까지
                for (int k = y1; k < y2; k++) { // 왼쪽 아래 꼭지점의 y좌표 부터 오른쪽 위 꼭지점의 y좌표 이전까지
                    arr[j][k] = 1;  // 해당 좌표는 직사각형 내에 있는 좌표이므로 1로 처리
                }
            }
        }

        int count = 0;  // 구역 수
        ArrayList<Integer> list = new ArrayList<>();    // 구역의 넓이를 저장할 list
        for (int i = 0; i < N; i++) {   // 모든 좌표들을 순회하며
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 0 && !visit[i][j]){ // 0이면서 방문하지 않은 좌표면
                    area = 1;   // 넓이 수는 1로,
                    dfs(i, j);  // 해당 좌표로 dfs 시작
                    count++;    // 탐색 끝나면 구역 수 + 1
                    list.add(area); // 넓이 list에 저장
                }
            }
        }
        Collections.sort(list); // 구역의 넓이들 오름차순으로 정렬
        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");  // 구역 수와
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(" "); // 구역의 넓이들 SB에 저장
        }
        System.out.println(sb); // 최종 출력
    }
    static void dfs(int x, int y){  // dfs 구현 메서드
        visit[x][y] = true; // 해당 좌표 방문 완료처리
        for (int i = 0; i < 4; i++) {   // 다음 갈 좌표들은 dy, dx 배열을 통해 인접한 좌표로 이동하도록 구현
            int nx = x + dx[i]; // 다음 x좌표
            int ny = y + dy[i]; // 다음 y좌표
            if(nx>=0 && ny>=0 && nx<N && ny<M && arr[nx][ny] == 0 && !visit[nx][ny]){   // 지도 이내의 좌표이며, 0이면서 방문하지 않은 좌표이면
                area++; // 넓이 수 +1
                dfs(nx, ny);    // 다음좌표로 dfs
            }
        }

    }
}