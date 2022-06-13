// https://www.acmicpc.net/problem/2667
/*
단순하게 dfs로 순회를 하며 count 해줘야 하는 부분만 적당히 신경써주면 될거라 생각했는데, 그리 간단하진 않았다.
일단은 입력 데이터가 많지는 않아서 시간복잡도는 크게 고려를 안하고 풀었다.
먼저 지도를 2차원 배열에 모두 입력하고, 각 집마다 번호를 매긴다.(2중반복문 안에서 i*N(지도의 크기)+j가 된다)
그 집과 인접한 집이 있으면 인접리스트에 추가를 한 후, dfs를 이용하여 탐색하는 방식으로 진행했다.
만약 지도가 7*7 지도이면 집의 번호는 총 49개가 생긴다. (0번~48번)
Count용 변수는 총 2개로 하나는 단지 개수, 하나는 단지 내 집 개수를 카운팅한다.
*/

import java.io.*;
import java.util.ArrayList;

public class baekjoon2667 {
    static int[][] arr; // 지도를 입력할 2차원 배열 선언
    static boolean[] visit; // 방문 확인용 배열 선언
    static int houseCount;  // 단지 내 집의 개수를 카운팅할 변수 houseCount
    static ArrayList<Integer>[] list;   // 인접리스트 선언
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 지도의 크기 입력
        StringBuilder sb = new StringBuilder();
        int complexCount = 0;   // 단지의 개수
        visit = new boolean[N*N];   // 방문 확인용 배열 생성

        arr = new int[N][N];    // 지도를 입력할 배열 생성
        for (int i = 0; i<N; i++){
            String str = br.readLine(); // 1줄씩 입력받아서 배열에 저장
            for(int j = 0; j<N; j++){
                arr[i][j] = str.charAt(j)-'0';
            }
        }

        ArrayList<Integer> forHouseCount = new ArrayList<>(); // 집의 갯수를 저장할 ArrayList

        list = new ArrayList[N*N];  // 인접리스트 생성
        for(int i = 0; i<N*N; i++){
            list[i]=(new ArrayList<>());
        }

        for(int i = 0; i < N; i++) {    // 2중 for문을 통해 지도를 순회하며
            for (int j = 0; j < N; j++) {
                if(arr[i][j]==1) {  // 지도에서 만약 집이 있으면
                    int a = i * N + j;  // 그 집의 번호는 i*N+j
                    if (i + 1 < N && arr[i + 1][j] == 1) {  // 그 집 아래에 집이 있으면
                        int b = (i + 1) * N + j;    // 그 집의 번호는 (i+1)*N+j가 됨
                        list[a].add(b); // 인접리스트에 저장
                    }
                    if (i - 1 >= 0 && arr[i - 1][j] == 1) { // 그 집 위에 집이 있으면
                        int b = (i - 1) * N + j;    // 그 집의 번호는 (i-1)*N+j가 됨
                        list[a].add(b); // 인접리스트에 저장
                    }
                    if (j + 1 < N && arr[i][j + 1] == 1) {  // 그 집 오른쪽에 집이 있으면
                        int b = i * N + j + 1;  // 그 집의 번호는 i*N+j+1이 됨
                        list[a].add(b); // 인접리스트에 저장
                    }
                    if (j - 1 >= 0 && arr[i][j - 1] == 1) { // 그 집 왼쪽에 집이 있으면
                        int b = i * N + j - 1;  // 그 집의 번호는 i*N+j-1이 됨
                        list[a].add(b); // 인접리스트에 저장
                    }
                }
            }
        }
        for(int i = 0; i<N ; i++) { // 2중 for문을 통해 지도를 순회하며
            for(int j = 0; j<N; j++) {
                if (arr[i][j] == 1 && !visit[i * N + j]) {  // 좌표에 만약 집이 있고, 방문하지 않은 집이면
                    houseCount = 0; // 단지 내 집 개수를 0으로 초기화하고
                    dfs(i * N + j); // 탐색 시작
                    forHouseCount.add(houseCount);  // 집 개수를 저장하고
                    complexCount++; // 단지++
                }
            }
        }

        sb.append(complexCount).append("\n");   // 단지 개수 먼저 StringBuilder에 저장
        forHouseCount.sort(Integer::compareTo); // 단지 내 집 개수들은 오름차순으로 정렬 후
        for (Integer i : forHouseCount) {   // 차례대로 StringBuilder에 저장
            sb.append(i).append("\n");
        }
        System.out.println(sb); //최종 출력
    }
    static void dfs(int num){   // dfs 메서드
        visit[num] = true;  // 현재 집 방문 완료 확인
        houseCount++;   // 단지 내 집 개수 ++
        for(int i = 0; i<list[num].size() ; i++){   // 현재 집에서 갈수있는 집 개수만큼 반복
            if(!visit[list[num].get(i)]){   // 만약 방문하지 않은 집이면
                dfs(list[num].get(i));  // 탐색 시작
            }
        }
    }
}