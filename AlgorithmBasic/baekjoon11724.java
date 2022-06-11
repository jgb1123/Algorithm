// https://www.acmicpc.net/problem/11724
/*
처음에 탐색을 모두 진행해야 하고, dfs나 bfs 아무거나 사용해도 된다고 생각했기 때문에 나에게 좀 더 익숙한 dfs를 사용했다.
그래서 인접리스트와 재귀를 이용해 dfs를 구현하였고, count를 해야 하는 부분만 적당히 생각하면 됐다.
반복문을 통해 모든 정점에서 탐색을 시작하며,
이미 방문하지 않은 정점에서만 탐색을 시작하고 탐색이 완료되면 count++를 했다.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon11724 {
    static boolean[] visit; // 재귀에 사용할 방문확인 배열 전역변수로 선언
    static ArrayList<Integer>[] list; // 재귀에 사용할 인접리스트 전역변수로 선언
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;
        visit = new boolean[N+1];   // 방문확인용 배열 생성

        list = new ArrayList[N+1];  // 인접리스트 생성
        for(int i = 0; i<=N ; i++) list[i] = new ArrayList<>();
        for(int i = 0; i<M ; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i = 1; i <= N ; i++){   // 모든 정점에서 탐색을 시작하며
            if(!visit[i]) {             // 이미 방문하지 않은 정점에서만
                dfs(i);                 // 탐색을 시작하고
                count++;                // count++
            }
        }
        System.out.println(count);  // 최종 출력
    }
    static void dfs(int N){ // dfs를 구현한 메서드
        visit[N] = true;    // 방문 완료 확인
        for (int i = 0; i < list[N].size(); i++) {  // 해당 정점에서 갈수 있는 정점의 수만큼 반복
            if (!visit[list[N].get(i)]) {           // 만약 갈수 있는 정점이 방문하지 않은 정점이면
                dfs(list[N].get(i));                // 해당정점으로 dfs 재귀
            }
        }
    }
}