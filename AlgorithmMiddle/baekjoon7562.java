// https://www.acmicpc.net/problem/7562
/*
간단한 bfs 문제이다.

나의 풀이 방법은 다음과 같다.
dy, dx배열을 통해 나이트가 움직일 수 있는 8가지 방향으로 좌표가 이동할 수 있도록 구현을 했다.
bfs에 사용할 Queue에 좌표를 저장 시 편의를 위해 Location class를 하나 만들었고, 해당 클래스에는 y좌표, x좌표, 현재 이동 수의 정보가 담긴다.
그리고 bfs시 반복문과 dy dx배열을 이용해 나이트가 갈 수 있는 다음 좌표들을 구하고, 조건(다음 좌표가 체스판 내에 있고, 방문하지 않은 좌표)이 맞으면 Queue에 저장하면 된다.

옛날(약 4달전)을 생각하면 이런 문제도 한참은 고민해서 겨우 풀었던 것 같은데, 이제 이정도 문제는 정말 쉽게 풀린다.
많이 성장했다는 것을 느낀다.
*/

import java.io.*;
import java.util.*;

public class baekjoon7562 {
    static boolean[][] visit;

    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int N, startY, startX, targetY, targetX;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {   // 테스트 케이스 수만큼 반복
            N = Integer.parseInt(br.readLine());    // 체스판 길이
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            startY = Integer.parseInt(st.nextToken());  // 시작 y좌표
            startX = Integer.parseInt(st.nextToken());  // 시작 x좌표
            st = new StringTokenizer(br.readLine());
            targetY = Integer.parseInt(st.nextToken()); // 목표 y좌표
            targetX = Integer.parseInt(st.nextToken()); // 목표 x좌표

            visit = new boolean[N][N];  // 방문 확인용 배열 생성

            bfs();  // bfs 구현 메서드

        }


    }
    static void bfs(){  // bfs 구현 메서드
        Queue<Location> Q = new LinkedList<>(); // bfs에 사용할 Queue 생성, Location 객체가 들어감
        Q.offer(new Location(startY, startX, 0));   // Queue에 시작 좌표와 현재 이동횟수 0 저장
        visit[startY][startX] = true;   // 시작좌표 방문 완료 처리

        while(Q.size()>0) { // Queue가 빌 때까지 반복
            Location now = Q.poll();    // poll한 값이 현재 Location
            if(now.y == targetY && now.x == targetX){   // 현재 좌표가 목표 목표와 동일하면
                System.out.println(now.count);  // 해당 이동 수 출력
                return; // 탐색 종료
            }
            for (int i = 0; i < 8; i++) {   // dy, dx배열을 이용한 나이트가 이동할 수 있는 8가지 방향 모두 고려
                int ny = now.y + dy[i]; // 다음 y좌표
                int nx = now.x + dx[i]; // 다음 x좌표
                if (ny >= 0 && nx >= 0 && ny < N && nx < N && !visit[ny][nx]) { // 다음 좌표가 체스판 안에 있고, 방문하지 않은 좌표면
                    Q.offer(new Location(ny, nx, now.count+1)); // Queue에 다음 좌표와 현재count + 1로 저장
                    visit[ny][nx] = true;   // 다음좌표 방문 완료 처리
                }
            }
        }
    }
    static class Location{  // bfs에 사용할 Location class
        int y;  // y좌표
        int x;  // x좌표
        int count;  // 이동 수
        public Location(int y, int x, int count){
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }
}