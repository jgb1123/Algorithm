// https://www.acmicpc.net/problem/2644
/*
탐색을 하며 시작 지점에서 목표 지점까지의 거리를 출력하면 되는 문제이다.
DFS를 이용하여 풀었고, 간단한 탐색 문제라 쉽게 풀 수 있었다.
인접리스트로 연결 관계를 받아오고 탐색을 시작하며,
탐색 거리가 늘어날때마다 count를 1씩 증가시키면서 해당 목표까지의 거리를 측정하면 된다.
최종 출력값인 result를 -1로 초기화 해놓고,
만약 시작지점에서 목표지점까지 도달할 수 있으면 그때의 count 값을 result에 저장하면 된다.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon2644 {
    static ArrayList<Integer>[] list;
    static boolean[] visit;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        visit = new boolean[N + 1]; // 방문 확인용 배열 생성

        list = new ArrayList[N + 1];    // 인럽리스트 생성
        for(int i = 0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i<M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        result = -1; // result -1로 초기화 (만약 목표지점 도달 못하면 그대로 -1로 출력)

        dfs(start, end, 0); // 탐색 시작

        System.out.println(result); // 최종 출력
    }
    static void dfs(int cur, int end, int count){   // DFS 구현 메서드
        visit[cur] = true;  // 현재 위치 방문 완료 처리
        if(cur==end) result = count;    // 만약 현재위치가 목표지점이면 result를 현재 count값으로 변경
        else {  // 목표지점이 아니면
            for (int i = 0; i < list[cur].size(); i++) {    // 탐색가능한 지점 확인 후
                if (!visit[list[cur].get(i)]) { // 만약 방문하지 않은 지점이면
                    dfs(list[cur].get(i), end, count + 1);  // 해당 지점으로 탐색 시작
                }
            }
        }
    }
}