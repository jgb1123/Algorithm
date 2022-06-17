// https://www.acmicpc.net/problem/2178
/*
이전에 몇번 풀어봤던, 지도에서 인접한 이동가능한 좌표가 있으면 이동하면서 탐색하는 문제이다.
(이전에 baekjoon1012, baekjoon2667에서 비슷한 문제를 풀어봄)
저번에 풀고 나서 다른사람들의 코드를 보니 dx dy 배열을 이용해 푸는걸 확인했고,
다음엔 저런 방법으로 풀어봐야겠다고 생각을 해서 이번엔 그렇게 풀어봤다.

아직 dfs가 편하고 익숙해서 별 생각 없이 dfs로 풀어봤는데,
최단거리의 길 뿐만 아니라 모든 갈수있는 길의 거리를 다 구해야 됐고,
또 그 중 가장 작은 값을 찾아 출력해야했다.
따라서 굉장히 비효율적인 코드가 되어 시간초과까지 됐다. (맨아래 주석처리한 코드가 dfs로 푼 코드)
그래서 bfs로 풀이방식을 바꿨으며, bfs로 바꾸니 시간초과 없이 잘 통과했다.
bfs로 다시 푸느라 시간을 많이 썻고, 또 마지막에 거리를 count 하는 방법을 찾아내느라 시간을 또 많이 썼다.
다음부턴 탐색 관련 문제가 나오면 어떠한 탐색 방법을 이용해야 할지 꼭 고민해보고 풀어야 겠다.
*/

import java.io.*;
import java.util.*;

public class baekjoon2178 {
    static int[][] arr;
    static int[] dx;
    static int[] dy;
    static boolean[][] visit;
    static int[][] countArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];     // 입력받을 지도 를 저장할 2차원배열 생성
        visit = new boolean[N][M];  // 방문 확인을 위한 2차원배열 생성
        countArr = new int[N][M];   // 그 지점까지의 최단거리를 저장할 2차원배열 생성
        dx = new int[]{1, 0, -1, 0}; // x축 이동시 사용할 배열 생성
        dy = new int[]{0, 1, 0, -1}; // y축 이동시 사용할 배열 생성

        for(int i = 0; i < N; i++){ // 지도에 입력
            String str = br.readLine();
            for(int j = 0; j<M; j++){
                arr[i][j] = str.charAt(j)-'0';
            }
        }
        bfs(0,0);   // bfs 시작
        System.out.println(countArr[N-1][M-1]); // 최종 목표지점까지의 최단거리 거리 출력
    }
    static void bfs(int x, int y){

        Queue<int[]> Q = new LinkedList<>();    // bfs에 사용할 Queue 생성
        Q.offer(new int[]{x,y});    // Queue에 시작 좌표를 배열로 입력
        visit[y][x] = true; // 방문 완료 처리
        countArr[y][x] = 1; // 시작 좌표까지의 거리는 1부터 시작
        while(Q.size()>0) { // Queue에 저장된 데이터가 있으면 계속 반복
            int[] current = Q.poll();   // 현재 좌표를 Queue에서 poll한 값으로 설정
            int cx = current[0];    // 배열의 첫 요소가 현재 x좌표가 됨
            int cy = current[1];    // 배열의 두번째 요소가 현재 y좌표가 됨

            for (int i = 0; i < 4; i++) {   // dx, dy 배열에 저장된 값에 의해 반복문을 통해 좌표가 동 남 서 북 방향으로 이동함
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (ny >= 0 && ny < arr.length && nx >= 0 && nx < arr[y].length) { // 만약 지도를 벗어나지 않고
                    if (arr[ny][nx] == 1 && !visit[ny][nx]){    // 다음 좌표가 갈수 있는 좌표이며, 방문하지 않은 좌표면
                        Q.offer(new int[]{nx, ny}); // Queue에 다음에 갈 좌표를 저장하고
                        visit[ny][nx] = true;   // 방문 완료 처리
                        countArr[ny][nx] = countArr[cy][cx] +1; // 다음에 갈 좌표까지의 거리는 현재좌표까지의 거리 +1
                    }
                }
            }
        }
    }
}


/*
public class Main {
    static int[][] arr;
    static int[] dx;
    static int[] dy;
    static boolean[][] visit;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visit = new boolean[N][M];
        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};
        list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j<M; j++){
                arr[i][j] = str.charAt(j)-'0';
            }
        }
        dfs(0 , 0, 0);
        System.out.println(Collections.min(list));
    }
    static void dfs(int x, int y, int c){
        visit[y][x] = true;
        int count = c+1;
        if(y==arr.length-1&&x==arr[y].length-1){
            list.add(count);
        }else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (ny >= 0 && ny < arr.length && nx>= 0 && nx < arr[y].length){
                    if(arr[ny][nx] == 1 && !visit[ny][nx]) dfs(nx, ny, count);
                }
            }
        }
        visit[y][x] = false;
    }
}
*/