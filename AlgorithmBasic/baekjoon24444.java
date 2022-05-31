import java.io.*;
import java.util.*;

public class baekjoon24444 {
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

        for(int i = 1; i<=N; i++) Collections.sort(list[i]);    // 인접리스트 생성 후, 방문 기준을 오름차순으로 하기위해 정렬

        forSb = new int[N+1];   // 각 정점의 방문 순서를 위한 배열 생성
        isVisited = new boolean[N+1];   // 방문 여부 확인을 위한 배열 생성
        bfs(V); //bfs 시작
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i<= N ; i++){
            sb.append(forSb[i]).append("\n");   // 각 정점의 방문 순서들을 StringBuilder에 추가
        }
        System.out.println(sb); // 최종 출력

    }public static void bfs(int V){
        Queue<Integer> Q = new LinkedList<>();  //bfs에 사용할 Queue 생성
        Q.offer(V); // 첫 방문 정점 Queue에 저장
        isVisited[V] = true;    // 방문 완료 확인
        forSb[V] = inForSb;     // 각 정점의 방문 선수를 위한 배열에 방문 순서 입력
        inForSb++;  // 방문 순서 +1
        while(Q.size()>0){  // Queue에 남은 요소가 있으면 반복
            int cur = Q.poll(); // Queue에서 빼낸 값이 현재 정점이 됨.
            for(int i = 0; i<list[cur].size() ; i++){   // 현재 정점에 연결된 정점 수 만큼 반복
                if(!isVisited[list[cur].get(i)]) {  // 이동할 정점이 아직 방문하지 않은 정점이면
                    Q.offer(list[cur].get(i));  // Queue에 저장
                    isVisited[list[cur].get(i)] = true; // 방문 완료 확인
                    forSb[list[cur].get(i)] = inForSb;  // 각 정점의 방문 순서를 위한 배열에 방문 순서 입력
                    inForSb++;  // 방문 순서+1
                }
            }
        }
    }
}