// https://www.acmicpc.net/problem/2458
/*
주어진 키 비교 데이터를 통해 키의 등수를 알 수 있는 사람의 수를 확인하는 문제로,
가중치가 없고 길이 있는지만(연결되어 있는지) 확인하면 되는 플로이드워셜 문제이다.

나의 풀이 방법은 다음과 같다.
우선 가중치가 없고, 길이 있는지 여부만 확인하는 플로이드 워셜 알고리즘을 구현한다.
그러면 모든 사람들을 기준으로, 다른 모든 사람들과 연결되어 있는지를 알 수 있게 된다.
사람들을 기준으로, 다른 사람들과 모두 연결되어 있으면 자신의 순위를 알 수 있는 사람이다.
이부분을 확인할 때는 간단하며, 2중 for문을 이용하면 된다.
i에서 j로 갈 수 있으면 count+1, j에서 i로 갈 수 있으면 count+1씩 하면 되고,
최종적으로 count가 (사람 수 - 1)이 되면 자신의 순위를 알 수 있는 사람이 된다. (자기 자신은 제외하고 모든사람들과 연결되어 있음)
자세한 풀이는 아래 코드를 확인하면 된다.

좀 더 다양한 플로이드 워셜 문제들을 풀어봐야 겠다.
플로이드 워셜 알고리즘 구현은 굉장히 간단해서, 이 문제는 플로이드 워셜 문제구나라는 것만 한눈에 딱 보이는 수준이 되면 될 것 같다.
*/
import java.io.*;
import java.util.*;

public class baekjoon2458 {
    static int[][] adj;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 사람 수
        M = Integer.parseInt(st.nextToken());   // 키 비교 수
        getAdjArr(br);  // 인접 행렬 생성

        floyd();    // 플로이드 워셜

        int result = checkResult(); // 자신의 순위를 알고있는 사람 수 구함

        System.out.println(result); // 최종 출력
    }

    static void getAdjArr(BufferedReader br) throws IOException {   // 인접 행렬 생성 메서드
        adj = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(adj[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj[start - 1][end - 1] = 1;
        }
    }

    static void floyd() {   // 플로이드 워셜 구현 메서드 (가중치는 없고, 길이 존재하는지 여부만 확인)
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N ; i++) {
                for (int j = 0; j < N; j++) {
                    if(adj[i][k] == 1 && adj[k][j] == 1){
                        adj[i][j] = 1;
                    }
                }
            }
        }
    }

    static int checkResult() { // 최종적으로 자신의 키 순위를 알고있는 사람 수를 반환하는 메서드
        int result = 0; // 키 순위를 알고있는 사람 수
        for (int i = 0; i < N; i++) {   // i번째 사람을 기준으로
            int count = 0;  // 지금 사람과 연결되어있는 사람 수
            for (int j = 0; j < N; j++) {   // j번째 사람들과 비교
                if(adj[i][j] == 1) count++; // i에서 j로 갈 수 있으면 count+1
                if(adj[j][i] == 1) count++; // j에서 i로 갈 수 있으면 count+1
            }
            if(count == N-1) {  // 만약 모든 사람들과 연결되어 있으면
                result++;   // 키 순위를 알고있는 사람 수 +1
            }
        }
        return result;  // result 반환
    }
}