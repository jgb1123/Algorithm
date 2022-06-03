// https://www.acmicpc.net/problem/7568

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());    // 입력 갯수 N
        int[][] arr = new int[N][]; // 키와 몸무게 값을 집어넣을 2차원 배열 생성
        for(int i=0; i<N; i++){ // 입력값을 2차원배열에 넣음
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
        int[] rank = new int[N];    // 각각의 덩치 순위를 나타낼 배열
        Arrays.fill(rank, 1);   // 처음은 모두 1등으로 시작
        for(int i = 0; i<N; i++){
            for(int j = 0 ; j<N; j++){
                if(arr[i][0]<arr[j][0]&&arr[i][1]<arr[j][1]){ // 만약 자신보다 키와 몸무게 모두 큰 요소가 있으면
                    rank[i] +=1;                              // 덩치순위 +1
                }
            }
        }
        for(int i : rank){  // 덩치 순위 StringBuilder에 입력
            sb.append(i).append(" ");
        }
        System.out.println(sb); // 최종 출력
    }
}