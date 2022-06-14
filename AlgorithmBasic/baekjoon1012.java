// https://www.acmicpc.net/problem/1012
/*
기존에 풀었던 baekjoon2267번 문제와 비슷한 접근방식으로 풀었다.
(https://github.com/jgb1123/Algorithm/blob/main/AlgorithmBasic/baekjoon2667.java)
같은 코드에서 중간 중간에 좌표들과, 반복문만 조금 신경써 주면 되었다.
다 풀고 다른 사람들이 푼 코드를 보니, dx배열과 dy배열을 통해 좀더 간결하게 푸는 걸 확인했다.
다음에 이런 방식의 문제가 또 나오면, dx배열과 dy배열을 이용해 좀 더 간결하게 순회하는 방식으로 풀어봐야겠다.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon1012 {
    static int[][] arr; // 지도를 저장할 2차원 배열 선언
    static boolean[] visit; // 방문 확인을 위한 배열 선언
    static ArrayList<Integer>[] list;   // 인접리스트 선언
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스
        for(int r = 0; r<T; r++) {  // 테스트 케이스만큼 반복
            StringTokenizer st = new StringTokenizer(br.readLine());    // M과 N과 K를 입력받음
            int M = Integer.parseInt(st.nextToken());   // 지도 가로크기
            int N = Integer.parseInt(st.nextToken());   // 지도 세로크기
            int K = Integer.parseInt(st.nextToken());   // 배추 개수
            int Count = 0;  // 모여있는 배추 집단의 개수
            visit = new boolean[N * M]; // 방문 확인을 위한 배열 생성
            arr = new int[N][M];    // 지도를 저장할 2차원 배열 생성

            for (int i = 0; i < K; i++) {   // 배추의 위치를 입력받아 지도에 저장
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());
                arr[y][x] = 1;
            }

            list = new ArrayList[N * M];    // 인접리스트 생성
            for (int i = 0; i < N * M; i++) {
                list[i] = (new ArrayList<>());
            }
            for (int i = 0; i < N; i++) {   // 2중 for문을 통해 지도를 순회하며
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 1) {   // 지도에서 만약 배추가 있으면
                        int a = i * M + j;  // 그 집의 번호는 i*M+j
                        if (i + 1 < N && arr[i + 1][j] == 1) {  // 그 배추 아래에 배추가 있으면
                            int b = (i + 1) * M + j;    // 그 배추의 번호는 (i+1)*M+j가 됨
                            list[a].add(b); // 인접리스트에 저장
                        }
                        if (i - 1 >= 0 && arr[i - 1][j] == 1) { // 그 배추 위에 배추가 있으면
                            int b = (i - 1) * M + j;    // 그 배추의 번호는 (i-1)*M+j가 됨
                            list[a].add(b); // 인접리스트에 저장
                        }
                        if (j + 1 < M && arr[i][j + 1] == 1) {  // 그 배추 오른쪽에 배추가 있으면
                            int b = i * M + j + 1;  // 그 배추의 번호는 i*M+j+1가 됨
                            list[a].add(b); // 인접리스트에 저장
                        }
                        if (j - 1 >= 0 && arr[i][j - 1] == 1) { // 그 배추 왼쪽에 배추가 있으면
                            int b = i * M + j - 1;  // 그 배추의 번호는 i*M+j-1가 됨
                            list[a].add(b); // 인접리스트에 저장
                        }
                    }
                }
            }
            for (int i = 0; i < N; i++) {   // 2중 for문으로 지도를 순회하며
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 1 && !visit[i * M + j]) {  //만약 배추가 있고, 아직 방문하지 않은 배추이면
                        dfs(i * M + j); // 탐색 시작
                        Count++;    //탐색 끝나면 모여있는 배추 집단의 개수 ++
                    }
                }
            }

            sb.append(Count).append("\n");  // StringBuilder에 모여있는 배추 집단의 개수 저장
        }
        System.out.println(sb); // 최종 출력
    }
    static void dfs(int num){   // dfs 메서드
        visit[num] = true;  // 방문 완료 확인
        for(int i = 0; i<list[num].size() ; i++){   // 현재 배추에서 갈수 있는 배추들의 개수만큼 반복
            if(!visit[list[num].get(i)]){   // 만약 방문하지 않은 배추이면
                dfs(list[num].get(i));  // 탐색 시작
            }
        }
    }
}