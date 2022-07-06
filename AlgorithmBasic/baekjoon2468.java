// https://www.acmicpc.net/problem/2468
/*
브루트포스와 탐색문제가 혼합된 문제이다.
강수량에 따라 잠기지 않는 지역의 개수가 달라지며,
강수량마다 탐색을 하고 잠기지 않은 지역의 개수를 구해야 하고, 그 지역의 개수 중 최댓값을 구해야 한다.
강수량의 케이스를 구하기 위해 땅의 높이들을 지도에 저장하면서 Set에도 넣고,
이 Set에 저장된 값을 강수량의 케이스로 정했다.
(중복을 없애고 오름차순으로 정렬하기 위함이고, 굳이 오름차순으로 정렬하진 않아도 된다.)
그리고 이 강수량마다 탐색을 하여 잠기지 않은 지역의 개수들을 모두 구하고 최댓값을 구하면 된다.

주의해야 할 점이 있는데, 비가 아예 오지 않은 상황도 고려해야 한다.
처음에 이 예외 케이스를 찾지 못해 틀렸었다.
비가 아예 오지 않은 상황도 고려하기 위해 Set에 처음에 0을 추가해줬다.
DFS를 이용해 탐색을 했고, 좌표 이동을 위한 dx dy배열을 이용했다.
*/

import java.io.*;
import java.util.*;

public class baekjoon2468 {
    static boolean[][] visit;
    static int[][] arr;
    static int result;  // 최종 최대값을 저장할 result변수
    static int[] dx = {1, 0 ,-1, 0};    // 방향 순서는 동 남 서 북 순이다.
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 지도의 크기를 입력받음
        arr = new int[N][N];    // 땅의 높이들을 저장할 지도
        Set<Integer> set = new TreeSet<>(); // 강수량 케이스를 저장할 set 생성
        set.add(0); // 비가 오지 않은 케이스를 위해 0을 추가

        for(int i = 0; i<N; i++){ // 반복문을 통해 지도에 땅의 높이들을 저장하며, 강수량 케이스를 구함
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                int a = Integer.parseInt(st.nextToken());
                arr[i][j] = a;  // 땅의 높이들을 지도에 저장
                set.add(a); // 그 높이를 set에 저장함 (최종적으로 중복이 사라지고, 오름차순이 됨)
            }
        }

        for (Integer limit : set) { // 강수량 케이스마다 반복
            int count = 0;  // 잠기지 않은 지역의 개수를 count할 변수
            visit = new boolean[N][N];  // 방문 확인용 배열은 모두 false로 초기화
            for(int i = 0; i<N; i++){
                for(int j = 0; j<N; j++){
                    if(!visit[i][j]&&arr[i][j]>limit) { // 잠기지 않은 땅이고, 방문하지 않은 땅이면
                        dfs(i, j, limit);   // 탐색 시작
                        count++;    // 탐색 완료되면 잠기지 않은 지역 개수 +1
                    }
                }
            }
            if(result<count) result = count; // 현재 강수량에서, 잠기지 않은 지역의 개수가 result보다 크면 갱신
        }
        System.out.println(result); // 최종 출력
    }
    static void dfs(int y, int x, int limit){ // DFS 메서드
        visit[y][x] = true; // 방문 완료 처리
        for(int i = 0; i<dx.length; i++){   // 동 남 서 북으로 좌표를 이동하며
            int ny = y+dy[i];   // 다음 y좌표
            int nx = x+dx[i];   // 다음 x좌표
            if(ny>=0&&nx>=0&&ny<arr.length&&nx<arr.length){ //만약 다음 좌표가 지도 이내이며,
                if(!visit[ny][nx]&&arr[ny][nx]>limit){  // 방문하지 않은 땅이고, 잠기지 않은 땅이면
                    dfs(ny, nx, limit); // 해당 좌표로 탐색 시작
                }
            }
        }
    }
}