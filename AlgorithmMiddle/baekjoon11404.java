// https://www.acmicpc.net/problem/11404
/*
다익스트라 관련 문제는 많이 풀어봐서 플로이드 워셜 문제들을 좀 풀어보려고 한다.
이전에 정점간 가중치가 없고, 각 정점끼리 갈 수 있는지만 확인하는 플로이드 워셜 문제를 푼 적이 있다.
가중치가 생겨도 크게 어려워지는 부분은 없는 것 같다.
조금 더 고려해야 했던 부분은 다음과 같다.
i에서 j로 가는 거리의 경우 경유지를 k라 하면,
adj[i][j]는 기존 값인 adj[i][j]와, adj[i][k] + adj[k][j]중 작은 값을 저장하면 되고,
이때 adj[i][k], adj[k][j] 모두 경로가 있는 경우에만 위의 식이 성립되도록 하면 된다.
나머지는 거의 비슷하게 풀었다.
자세한 풀이 방법은 아래 코드를 참고하면 된다.

플로이드 워셜도 다익스트라 처럼 문제의 유형이 눈에 딱 보이기 때문에,
몇문제만 더 풀어서 플로이드 워셜에 익숙해지면 다른 유형의 알고리즘 문제들로 넘어가려고 한다.

*/


import java.io.*;
import java.util.*;

public class baekjoon11404 {
    static int[][] adj;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        getAdjArr(br);  // 인접행렬 생성 메서드

        floyd();    // 플로이드 워셜 구현 메서드

        print();     // 최종 출력 메서드
    }

    static void getAdjArr(BufferedReader br) throws IOException {   // 인접행렬 생성 메서드
        adj = new int[N][N];
        for (int i = 0; i < N; i++) {   // 인접행렬을 우선 Integer.MAX_VALUE값으로 fill
            Arrays.fill(adj[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(adj[start-1][end-1]>weight) {    // index때문에 -1씩 했고, 시작도시와 도착도시를 연결하는 노선은 하나가 아닐 수 있기 때문에,
                adj[start - 1][end - 1] = weight;   // if문을 통해 더 작은 가중치를 갖는 노선을 인접행렬에 저장한다.
            }
        }
        for (int i = 0; i < N; i++) {   // (1,1) (2,2) 등 정점 자기 자신까지의 거리는 0이므로, 0으로 변경
            adj[i][i] = 0;
        }
    }

    static void floyd() {   // 플로이드 워셜 구현 메서드
        for (int k = 0; k < N; k++) {   // 경유 정점
            for (int i = 0; i < N ; i++) {  // 시작 정점
                for (int j = 0; j < N; j++) {   // 도착 정점
                    if(adj[i][k] != Integer.MAX_VALUE && adj[k][j] != Integer.MAX_VALUE) {  // 경유해서 가는 값이 Integer.MAX_VALUE가 아니면
                        adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]); // adj[i][j]는 기존 adj[i][j]와 (adj[i][k] + adj[k][j])중 작은 수가 된다.
                    }
                }
            }
        }
    }

    static void print() {   // 최종 출력 메서드
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(adj[i][j] == Integer.MAX_VALUE){ // 갈수 없는 경로의 경우 0으로 출력해야 하므로,
                    adj[i][j] = 0;  // 여전히 Integer.MAX_VALUE면 0으로 변경
                }
                sb.append(adj[i][j]).append(" ");   // 그리고 sb에 해당 값 저장
            }
            sb.append("\n");
        }
        System.out.println(sb); // 최종 sb출력
    }
}