// https://www.acmicpc.net/problem/2606

import java.io.*;
import java.util.*;

public class baekjoon2606 {
    static boolean[] isVisited; // 방문 여부 확인을 위한 배열
    static ArrayList<Integer>[] list;   // 인접 리스트 선언(인접 행렬 사용하면 메모리 너무 많이 차지함)
    static int count = 0;   // 카운팅을 위한 변수 초기화
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];  // 인접 리스트 생성
        for(int i = 1; i<=N; i++) list[i] = new ArrayList<>();
        for(int i = 0; i<M ; i++ ){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i = 1; i<=N; i++) Collections.sort(list[i]); // 방문 기준을 위한 sort 사용 (해당문제는 사실 기준 필요 없음)

        isVisited = new boolean[N+1];   // 방문 여부 확인을 위한 배열 생성
        bfs(1); // 시작 정점을 1로 bfs 시작

        System.out.println(count);  // 방문한 수 입력

    }public static void bfs(int n){
        Queue<Integer> Q = new LinkedList<>();  // bfs에 사용할 Queue 생성
        Q.offer(n); // 첫 정점 Queue에 저장
        isVisited[n] = true;    // 방문 완료 확인
        while(Q.size()>0){  // Queue에 남은 요소가 있으면 반복
            int cur = Q.poll(); // Queue에서 빼온 정점이 현재 정점
            for(int i = 0; i<list[cur].size() ; i++){   // 현재 정점에 연결된 간선 수만큼 반복
                if(!isVisited[list[cur].get(i)]) {  // 방문하지 않았으면
                    Q.offer(list[cur].get(i));      // Queue에 저장하고
                    isVisited[list[cur].get(i)] = true; // 방문 완료 확인
                    count++;    // 방문 했으니 count++
                }
            }
        }
    }
}