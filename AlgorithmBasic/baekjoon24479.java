// https://www.acmicpc.net/problem/24479

import java.io.*;
import java.util.*;

public class baekjoon24479 {
    static boolean[] isVisited; // 방문 여부 확인을 위한 배열 선언
    static ArrayList<Integer>[] list;   // 인접 리스트 선언(인접 행렬 사용하면 메모리 너무 많이 차지함)
    static int[] forSb; // 각 정점의 방문 순서를 위한 배열 선언
    static int inForSb = 1; // 방문 순서
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 정점 수
        int M = Integer.parseInt(st.nextToken());   // 간선 수
        int V = Integer.parseInt(st.nextToken());   // 시작 정점

        list = new ArrayList[N+1];  // 인접 리스트 생성
        for(int i = 1; i<=N; i++) list[i] = new ArrayList<>();
        for(int i = 0; i<M ; i++ ){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i = 1; i<=N; i++) Collections.sort(list[i]); // 인접리스트 생성 후, 방문 기준을 오름차순으로 하기위해 정렬

        forSb = new int[N+1];   // 각 정점의 방문 순서를 위한 배열 생성
        isVisited = new boolean[N+1];   // 방문 여부 확인을 위한 배열 생성
        dfs(V); // dfs 시작
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i<= N ; i++){
            sb.append(forSb[i]).append("\n");   // 각 정점의 방문 순서들을 StringBuilder에 추가
        }
        System.out.println(sb); // 최종 출력

    }public static void dfs(int V){
        isVisited[V] = true;    // 방문 완료 확인
        forSb[V] = inForSb;     // 각 정점의 방문 선수를 위한 배열에 방문 순서 입력
        inForSb++; // 방문 순서 +1
        for(int i = 0; i<list[V].size() ; i++){
            if(!isVisited[list[V].get(i)]){   // 이동할 정점이 아직 방문하지 않은 정점이면
                dfs(list[V].get(i));          // dfs 재귀
            }
        }
    }
}