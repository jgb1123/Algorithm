// https://www.acmicpc.net/problem/10159
/*
가중치가 없는 플로이드 워셜을 사용하면 되는 문제이다.
이 문제는 플로이드 워셜을 사용하면 된다는 것만 알게 되면 크게 어렵지 않게 풀 수 있다.

나의 풀이 방법은 다음과 같다.
우선 인접행렬을 만들고, 가중치가 없는 플로이드 워셜을 통해 각 정점과 모든 정점간의 연결 여부를 확인한다.
그리고 2중 for문을 통해 다른 정점과의 연결 여부를 확인하면 된다.
i정점에서 j정점으로 갈 수 있거나, j정점에서 i정점으로 갈 수 있으면 두 정점은 비교가 가능한 정점이 된다.
위 내용을 토대로 코드를 구현하면 되고, 자세한 구현 방법은 아래 코드를 참고하면 된다.

생각보다 가중치가 없는 플로이드워셜 문제가 많이 보이는 것 같다.
나는 당연히 난이도가 높아질수록 가중치가 있는 플로이드 워셜 문제가 많이 나올거라 생각했는데, 착각이었다.
확실히 많이 풀어보면서 다양한 유형의 문제들을 접해보는 것이 중요한 것 같다.
*/

import java.io.*;
import java.util.*;

public class baekjoon10159 {
    static int[][] adj;
    static int V, E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        getAdjArr(br);  // 인접행렬 생성 메서드

        floyd();    // 가중치가 없는 플로이드 워셜 구현 메서드

        print();    // 최종 출력을 위한 메서드
    }

    static void getAdjArr(BufferedReader br) throws IOException {   // 인접행렬 생성 메서드

        adj = new int[V][V];
        for (int i = 0; i < V; i++) {
            Arrays.fill(adj[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj[start - 1][end - 1] = 1;
        }
    }

    static void floyd() {   // 가중치가 없는 플로이드 워셜 구현 메서드이다.
        for (int k = 0; k < V; k++) {   // 경유지
            for (int i = 0; i < V ; i++) {  // 출발지
                for (int j = 0; j < V; j++) {   // 도착지
                    if(adj[i][k] == 1 && adj[k][j] == 1){   // k를 경유해서 갈 수 있는 길이 있으면
                        adj[i][j] = 1;  // 해당 길은 있는 것으로 변경
                    }
                }
            }
        }
    }

    static void print() {   // 최종 출력을 위한 메서드
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < V; i++) {   // i정점을 기준으로
            int count = 0;  // i정점과 연결된(비교 가능한) 정점들을 카운팅할 변수
            for(int j = 0; j < V; j++) {
                if(adj[i][j] == 1 || adj[j][i] == 1){   // 만약 i에서 j로 가는길이 있거나 j에서 i로 가는길이 있으면 비교가 가능 한 것이므로
                    count++;    // count +1
                }
            }
            sb.append(V-1-count).append("\n");  // 비교 불가능한 정점의 수 = 정점의 수 - 1 - count 이 된다. (자기 자신은 뺴야하므로 -1 함)
        }
        System.out.println(sb); // 최종 출력
    }
}