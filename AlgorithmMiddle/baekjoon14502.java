// https://www.acmicpc.net/problem/14502
/*
이전까지 너무 문제들을 절차지향적으로 주르륵 짠 것 같아서, 조금 더 자바에 어울리도록 코드를 짰다.
앞으로는 좀 더 객체 지향적으로 문제를 푸는 것을 연습해야겠다.

브루트포스와 탐색이 필요한 문제이다.
BFS를 이용하여 탐색을 진행했다. 사실 DFS로 해도 상관은 없었던 문제 같다.

벽을 3개를 세울 수 있는데, 이 벽을 세울때 브루트포스를 이용해야 했다. (지도의 최대 크기가 크지 않아 브루트포스로 풀이 가능)
for문 3개로 벽을 세울 케이스들을 정했고, 그 케이스마다 BFS를 돌며 전염되는 구역을 구했다.
(벽을 세우는 케이스를 정할 때 for문 -> 재귀 메서드 사용으로 변경해봤는데 속도가 많이 느려졌다. 아마 재귀메서드를 좀 잘못 짜서 그랬던 것 같다.)
BFS를 돌면서 전염되는 바이너스의 좌표들을 저장하기 위해 Virus class를 만들어 객체를 만들어 이용했다.
최종 안전지역을 count하기 위해, 기존 지도의 빈칸(안전지역) 개수 -3으로(기존 지도에서 벽 3개가 세워져야 됨) 안전했던 구역의 크기를 구하고(safeZoneBeforeBfs),
BFS를 돌며 전염되는 구역들의 크기를 구해서(infectionZoneAfterBfs) 두 개를 빼면 최종 안전 지역의 개수를 구할 수 있다.
그리고 벽을 세우는 케이스마다의 최종 안전 지역 개수 중 가장 큰 수를 출력하면 된다.
*/

import java.io.*;
import java.util.*;

public class baekjoon14502 {
    static int[] dx = {1, 0, -1, 0};    // 동 남 서 북 순으로 전염 좌표 이동
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];    // 지도 생성
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        int safeZoneBeforeBfs = countSafeZone();    // 기존 지도의 안전구역 개수를 구한다.

        int max=0;  // 최종 안전구역 크기의 최댓값은 0으로 초기화

        for (int i = 0; i < N*M-2; i++) {   // for문을 사용해 벽을 세울 케이스들을 구한다. 지도의 넓이만큼 반복하며
            int y1 = i/M;                   // y좌표는 i/M이 되고,
            int x1 = i%M;                   // x좌표는 i%M이 된다.
            if(arr[y1][x1]==0) arr[y1][x1] = 1; // 그리고 해당 좌표가 빈칸이면 벽을 세운다.
            else continue;                      // 해당 좌표가 빈칸이 아니면 continue
            for (int j = i+1; j < N*M-1; j++) {     // 2개째 벽을 세운다
                int y2 = j/M;
                int x2 = j%M;
                if(arr[y2][x2]==0) arr[y2][x2] = 1;
                else continue;
                for (int k = j+1; k < N*M; k++) {   // 3개째 벽을 세운다.
                    int y3 = k/M;
                    int x3 = k%M;
                    if(arr[y3][x3]==0) {
                        arr[y3][x3] = 1;    // 3개째 벽을 세우고
                        visit = new boolean[N][M];  // 방문확인을 위한 boolean배열을 false로 초기화한다.
                        int infectionZoneAfterBfs = bfs();  // bfs를 통해 감염되는 지역의 크기를 구한다.
                        int finalSafeZone = safeZoneBeforeBfs - infectionZoneAfterBfs;  //기존 지도의 안전구역 개수 - bfs후 감염된 지역의 개수를 구하면 최종 안전구역의 크기가 된다.
                        if(finalSafeZone>max) max = finalSafeZone;  // 만약 현재 최종안전구역의 크기가 max보다 크면 갱신
                        arr[y3][x3] = 0;    // 3번째 벽 다시 빈칸으로 변경
                    }
                }
                arr[y2][x2] = 0;    // 2번째 벽 다시 빈칸으로 변경
            }
            arr[y1][x1] = 0;    // 1번째 벽 다시 빈칸으로 변경
        }
        System.out.println(max);    // 최종 max값 출력
    }

    private static int bfs() {  // bfs 구현 메서드
        int infectionCount = 0; // 감염되는 지역의 크기를 count할 변수
        Queue<Virus> Q = new LinkedList<>();    // bfs탐색에 필요한 Queue를 생성하고, Queue에는 Virus객체가 들어간다. (좌표가 들어있음)

        for (int i = 0; i < arr.length; i++) {  // 반복문을 통해 Queue에 기존 바이러스의 좌표를 모두 집어 넣는다.
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 2) {
                    Q.offer(new Virus(i, j));
                }
            }
        }
        while (Q.size() > 0) {  // Queue의 size가 0이될때까지 반복
            Virus curVirus = Q.poll();  // Queue에서 바이러스좌표를 하나 뺴온다
            for (int i = 0; i < dx.length; i++) {   // 해당 바이러스 좌표에서 동 남 서 북으로 이동하며
                int ny = curVirus.y + dy[i];
                int nx = curVirus.x + dx[i];
                if (ny >= 0 && nx >= 0 && ny < arr.length && nx < arr[0].length){   // 만약 지도 이내의 좌표이며,
                    if(arr[ny][nx] == 0&&!visit[ny][nx]) {  // 빈칸이고, 방문하지 않은 좌표이면
                        Q.offer(new Virus(ny, nx)); // Queue에 모두 저장
                        visit[ny][nx] = true;   // 방문 완료 처리
                        infectionCount++;   // 감염 지역 크기 +1
                    }
                }
            }
        }
        return infectionCount;  // 감염지역의 크기를 return한다.
    }
    static int countSafeZone(){ // 기존 지도의 안전지역(빈칸)개수를 count한다
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) count++;
            }
        }
        return count-3; // 벽이 3개 세워져야 하므로 -3해서 return
    }
    static class Virus{ // 바이러스 좌표를 위한 객체로 사용될 Virus 클래스
        int y, x;
        public Virus( int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}