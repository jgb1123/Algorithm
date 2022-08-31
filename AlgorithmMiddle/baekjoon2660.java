// https://www.acmicpc.net/problem/2660
/*
팀 프로젝트로 인해 오랜만에 푸는 알고리즘 문제였다.
역시 알고리즘은 자주 풀어야 되는 것 같다. 그새 기억이 가물가물해졌다.
그래도 이전에 많이 풀어봤던 플로이드 워셜 문제였기 때문에 풀 순 있었다.
플로이드 워셜 문제는 다양한 유형들을 풀어본 것 같고 이정도면 충분하다고 생각된다.
다른 알고리즘 유형들도 잘 기억하고 있는지 틈 날때마다 한번씩 풀어봐야겠다.
*/

import java.io.*;
import java.util.*;

public class baekjoon2660 {
    static int[][] adj;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        getAdjArray(br);    // 인접행렬 생성 메서드

        floyd();    // 플로이드 워셜 구현 메서드

        printResult();  // 최종 출력 메서드
    }

    static void getAdjArray(BufferedReader br) throws IOException { // 인접행렬 생성 메서드
        adj = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(adj[i], 10000); // 사람 수가 최대 50이기 때문에, 최대로 긴 거리는 49이다. 때문에 초기값을 적당히 10000으로 해주었다.
        }
        for (int i = 0; i < N; i++) {
            adj[i][i] = 0;  // 자기 자신은 0으로 설정
        }
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a==-1 && b == -1) break; // -1 -1이 들어오면 입력 종료

            adj[a-1][b-1] = 1;  //양방향이기 때문에 양방향 설정(인덱스 고려)
            adj[b-1][a-1] = 1;

        }
    }

    static void floyd() {   // 플로이드 워셜 구현 메서드
        for(int k = 0 ; k < N ; k++){
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(adj[i][j] > adj[i][k] + adj[k][j]) adj[i][j] = adj[i][k] + adj[k][j];
                }
            }
        }
    }

    static void printResult() { // 최종 출력 메서드
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int max = 0;    // 각 인원별 가장 먼 친구의 거리를 저장할 변수
            for (int j = 0; j < N; j++) {
                if(adj[i][j] > max) max = adj[i][j];    // 만약 max값보다 크면 max 갱신
            }
            result.add(max);    // result List에 max값 저장
        }
        int min = Collections.min(result);  // result List중 가장 작은 값 구함 (회장 후보가 될 수 있는 점수)

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb1.append(min).append(" "); // SB1에 회장 후보가 될 수 있는 점수 저장
        int count = 0;  // 회장이 될 후보의 수
        for (int i = 0; i < N; i++) {
            if(result.get(i) == min){   // result List를 순회하며 만약 가장 작은 값과 같다면
                sb2.append(i+1).append(" ");    // SB2에 i+1 저장 (인덱스 고려)
                count++;    // 후보 수 + 1
            }
        }
        sb1.append(count);  // SB1에 회장 후보 수 저장
        System.out.println(sb1);    //최종 회장 후보가 될 수 있는 점수와, 후보 수 출력
        System.out.println(sb2);    // 최종 회장 후보들 출력
    }
}