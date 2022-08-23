// https://www.acmicpc.net/problem/1956
/*
플로이드 워셜 문제이다.
한 시작점에서 시작해 다시 시작점까지 돌아올 수 있는 최단거리를 구하면 되는 문제이다.
사실 플로이드 워셜을 사용하면 되겠다고 생각만 할 수 있으면 어렵지 않게 풀 수 있는 문제이다.
풀이 방법은 다음과 같다.
우선 플로이드 워셜을 통해 모든 정점에서 모든 정점까지의 최단거리를 구한다.
그리고 2중 for문을 통해 (i에서 j로 가는 최단거리 + j에서 i로가는 최단거리)가 최솟값인 값을 구하면 된다.

자세한 코드는 아래를 참고하면 된다.
오늘 문제는 딱 보고 플로이드 워셜 문제구나라는게 바로 보이지는 않았다.
플로이드 워셜 문제는 코드 구현은 간단하지만, 플로이드 워셜 문제라는 것만 잘 파악할 수 있는 수준이 되면 될 것 같다.
*/

import java.io.*;
import java.util.*;

public class baekjoon1956 {
    static int[][] adj;
    static int V, E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());   // 정점 수
        E = Integer.parseInt(st.nextToken());   // 간선 수
        getAdjArr(br);  // 인접행렬 생성 메서드

        floyd();    // 플로이드 구현 메서드

        print();    // 최종 출력 메서드
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
            int weight = Integer.parseInt(st.nextToken());
            adj[start - 1][end - 1] = weight;
        }
        for (int i = 0; i < V; i++) {   // 자기 자신까지 가는 거리는 0으로 설정
            adj[i][i] = 0;
        }
    }

    static void floyd() {   // 플로이드 워셜 구현 메서드
        for (int k = 0; k < V; k++) {   // 경유지
            for (int i = 0; i < V ; i++) {  // 출발지
                for (int j = 0; j < V; j++) {   // 도착지
                    if(!isINF(adj[i][k]) && !isINF(adj[k][j]) &&adj[i][j] > adj[i][k] + adj[k][j]){ // 만약 i에서 k로 가는 길과, k에서 j로 가는 길이 있고, 그 거리의 합이 i에서 j로 가는 거리보다 작으면
                        adj[i][j] = adj[i][k] + adj[k][j];  // i에서 j로 가는 최단거리는 (i에서 k로 가는 거리 + k에서 j로 가는 거리)
                    }
                }
            }
        }
    }

    static void print() {   // 최종 출력 메서드
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < V; i++) {   // 모든 케이스를 고려하여
            for (int j = i+1; j < V; j++) {
                if(!isINF(adj[i][j]) && !isINF(adj[j][i]) && min > adj[i][j] + adj[j][i])   // i에서 j로 가는 길과 j에서 i로 가는 길이 있는경우, 그 거리의 합이 현재의 min값보다 작으면
                    min = adj[i][j] + adj[j][i];    // min 갱신
            }
        }
        if (min == Integer.MAX_VALUE) System.out.println(-1);   // min이 여전히 Integer.MAX_VALUE이면 -1 출력
        else System.out.println(min);   //아니면 min값 출력
    }
    static boolean isINF(int a){    // 그 수가 Integer.MAX_VALUE 인지 확인하는 간단한 메서드
        if(a == Integer.MAX_VALUE) return true;
        return false;
    }
}