// https://www.acmicpc.net/problem/14503
/*
로봇이 동작하는 패턴을 천천히 이해하고 코드로 구현하면 생각보다 간단하게 풀린다.
간단하게 설명해보면, 우선 현재 위치를 청소한다.
그리고 바라보는 방향에서 왼쪽부터 탐색한다.
왼쪽에 청소하지 않은 공간이면 그쪽으로 이동하면 되고, 벽이거나 청소한 공간이면 또다시 왼쪽으로 돌면서 반복한다.
만약 4방향 다 벽이거나 청소한 공간이면, 처음 바라보던 방향 뒤로 한칸 움직이고 똑같이 다시 탐색을 시작한다.
만약 4방향 다 벽이거나 청소한 공간이고, 뒤가 벽이면 종료된다.

좌표의 이동을 위해 dx, dy배열을 이용했고, 입력으로 방향 d가 들어온다.
d는 0이면 북, 1이면 동, 2면 남, 3이면 서쪽이다. 따라서 x+dx[d], y+dy[d]가 다음 좌표가 된다.
왼쪽부터 탐색해야 하므로, 만약 방향이 북쪽을 바라고 있으면 서 남 동 북 순으로 탐색한다.
그중 만약 청소를 해야할 공간이 있으면 그 좌표로 이동하면 되고, 만약 없으면 뒤로 이동하면 된다. (만약 뒤가 벽이면 종료)
이렇게 계속 반복되면 로봇의 탐색이 끝난다.
*/

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon14503 {
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};    // 방향은 북 동 남 서 순
    static int[] dy = {-1, 0, 1, 0};    // 방향은 북 동 남 서 순
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 지도 세로크기
        int M = Integer.parseInt(st.nextToken());   // 지도 가로크기
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st2.nextToken());  //처음 y좌표
        int x = Integer.parseInt(st2.nextToken());  //처음 x좌표
        int d = Integer.parseInt(st2.nextToken());  //처음 방향, 0이면 북, 1이면 동, 2면 남, 3이면 서

        arr = new int[N][M];    // 지도 생성
        for (int i = 0; i < N; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st3.nextToken());
            }
        }

        count = 0;  // 청소한 공간 수
        recur(y, x, d); // 처음 위치에서, 처음 방향 d로 탐색 시작

        System.out.println(count);  // 청소한 공간 수 최종 출력

    }
    static void recur(int y, int x, int d){
        if(arr[y][x]==0){   // 청소해야 할 공간이면
            arr[y][x] = 2;  // 청소 하고(2로 표시)
            count++;    // 청소한 공간 수 +1
        }
        for (int i = d+3; i >= d ; i--) {   // 해당 뱡항에서 왼쪽으로 돌아야 하므로, d+3부터 d까지 반복 (d가 0이면 서 남 동 북 순이 됨)
            int ny = y+dy[i%4]; // 다음 y는 y+dy[i%4]가 됨 (d+3이 4보다 클 수 있으므로, 4로 나눈 나머지로 구함)
            int nx = x+dx[i%4]; // 다음 x는 x+dx[i%4]가 됨
            if(arr[ny][nx]==0){ //만약 청소해야할 공간이라면
                recur(ny, nx, i%4); // 해당 위치로 이동(다음 위치 좌표와 해당 방향으로 재귀 시작)
                break;  // 만약 이동했으면면 반복문 종료
            }
            if(i==d){   // 모든 방향을 다 돌았는데 갈 곳이 없었으면
                int by = y+dy[(d+2)%4]; // 현재 방향에서 뒤로 이동할 y좌표
                int bx = x+dx[(d+2)%4]; // 현재 방향에서 뒤로 이동할 x좌표
                if(arr[by][bx] == 1){   // 만약 벽이면 종료
                    return;
                }else{
                    recur(by, bx, d);   // 벽이 아니면 해당 위치와 방향으로 재귀 시작
                }
            }
        }
    }
}