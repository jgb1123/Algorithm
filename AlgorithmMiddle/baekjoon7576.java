// https://www.acmicpc.net/problem/7576
/*
박스 안에 익은 토마토와, 안익은 토마토, 빈 칸이 있다.
안익은 토마토는 익은 토마토의 영향을 받아서 익는다. (익은 토마토가 옆에 있으면 하루가 지나면 익게 된다.)
박스안에 있는 토마토들이 모두 익을때까지 걸리는 일수를 구하는 문제이다.

하루가 지날때마다 익은 토마토들이 확장되어 가는 방식으로 탐색이 되야 하므로 BFS를 이용했다.
탐색문제들을 계속 접해보다 보니, 이제 DFS와 BFS중 뭘 써야 할지 감이 잡히는 것 같다.

좌표 이동을 위한 dx dy배열을 이용했다.
만약 근처의 토마토들이 안익은 토마토이면, Queue에 해당 좌표를 저장한다.
최종적으로 걸린 일 수를 어떻게 구할까 생각을 하다가, Queue에 좌표와 함께 depth를 같이 저장해서 구해봤다.
그리고 탐색을 모두 마쳤을때의 depth를 구했다.
(탐색을 하면서 안익은 토마토를 익은 토마토로 변경해줄 때 걸린 일 수로 저장하면서 해도 걸린 일 수를 구할 수 있다.)

최종적으로 안익은 토마토가 있으면 (빈칸에 둘러싸여있으면 안익음) -1을 출력하고,
안익은 토마토가 없으면 depth(걸인 일 수가 됨)를 출력했다.
*/

import java.io.*;
import java.util.*;

public class baekjoon7576 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());   // 박스 가로길이
        int N = Integer.parseInt(st.nextToken());   // 박스 세로길이

        int[] dx = {1, 0, -1, 0};   // 방향 순서는 동 남 서 북 순이다.
        int[] dy = {0, 1, 0, -1};

        int[][] arr = new int[N][M];    // 박스를 생성하고, 박스에 정보를 저장
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        Queue<int[]> Q = new LinkedList<>();    // BFS에 사용할 Queue를 생성하고, Queue에는 int형 배열이 들어간다. (y좌표, x좌표, 깊이)

        for (int i = 0; i < N; i++) {   // 처음에 익어있는 토마토들의 좌표를 Queue에 모두 저장한다. 이때 깊이는 0이다.
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    Q.offer(new int[]{i, j, 0});
                }
            }
        }

        int depth = 0;  // 최종 깊이는 0으로 초기화;
        while (Q.size() > 0) {
            int[] cur = Q.poll();
            int y = cur[0];
            int x = cur[1];
            for (int i = 0; i < dx.length; i++) {   // 지금의 좌표에서 동 남 서 북 순으로 좌표를 이동하며,
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny >= 0 && nx >= 0 && ny < N && nx < M && arr[ny][nx] == 0) {   // 해당 좌표가 박스 내의 좌표이고, 안익은 토마토이면
                    arr[ny][nx]=1;  // 익은 토마토로 처리를 하고
                    Q.offer(new int[]{ny, nx, cur[2] + 1}); // Queue에 해당 좌표와 깊이를 저장한다.
                }
            }
            if(Q.size()==0) depth = cur[2]; // 탐색을 모두 마치면 마지막 탐색 좌표의 깊이를 저장
        }
        if(containZero(N, M, arr)) System.out.println(-1);  // 만약 안익은 토마토가 아직 있으면 -1 출력
        else System.out.println(depth); // 토마토가 모두 익었으면 depth출력
    }

    static boolean containZero(int N, int M, int[][] arr){  // 안익은 토마토가 있는지 확인하는 메서드
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) return true;    // 안익은 토마토가 있으면 true 반환
            }
        }
        return false;
    }
}