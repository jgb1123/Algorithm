import java.io.*;
import java.util.*;

public class baekjoon1260 {
    static boolean[] isVisited; // 탐색 여부 확인을 위한 배열
    static int[][] arr; // 인접 행렬로 만들 배열
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 정점의 개수
        int M = Integer.parseInt(st.nextToken());   // 간선의 개수
        int V = Integer.parseInt(st.nextToken());   // 탐색을 시작할 정점의 번호
        arr = new int[N][N];

        for(int i = 0; i<M; i++){   // 간선의 정보를 인접 행렬로 만듬
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            arr[a-1][b-1] = 1;
            arr[b-1][a-1] = 1;
        }

        isVisited = new boolean[N+1]; // DFS 시작 전 새로운 boolean 배열 생성 (false로 초기화)
        dfs(V); // DFS 시작
        sb.append("\n");
        isVisited = new boolean[N+1]; // BFS 시작 전 새로운 boolean 배열 생성 (false로 초기화)
        bfs(V); // BFS 시작
        System.out.println(sb); // 최종 출력
    }
    static void dfs(int V){ // 재귀를 이용한 DFS 구현
        isVisited[V] = true;    // 해당 숫자 탐색 완료
       sb.append(V).append(" ");    // 탐색한 숫자 StringBuilder에 추가
        for(int i = 1; i<=arr.length; i++){ // arr[][i]값들 확인을 반복문
            if(!isVisited[i]&&arr[V-1][i-1]!=0) dfs(i); // 탐색할 숫자가 아직 탐색하지 않았고, 간선이 있을경우 재귀 시작
        }
    }
    static void bfs(int V){ // Queue를 이용한 BFS 구현
        Queue<Integer> Q = new LinkedList<>();  // BFS를 위한 Queue 생성
        Q.add(V); // Queue에 탐색한 숫자를 추가함
        isVisited[V] = true;  // 해당 숫자 탐색 완료
        while(Q.size()>0){ // Queue가 비어있지 않으면 반복
            int current = Q.poll(); // 현재 값은 Queue에서 빼온 값
            sb.append(current).append(" "); // 그 현재 값 출력
            for(int i = 1; i <= arr.length ; i++){ // arr[][i]값들 확인을 위한 반복문
                if(!isVisited[i]&&arr[current-1][i-1]!=0){ // 탐색할 숫자가 아직 탐색하지 않았고, 간선이 있으면
                    isVisited[i]=true;                     // 해당 숫자 탐색 완료
                    Q.add(i);                              // 탐색한 숫자 Queue에 저장
                }
            }
        }
    }
}