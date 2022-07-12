// https://www.acmicpc.net/problem/1946
/*
어떠한 사람의 서류 성적 등수와 면접 성적 등수보다 등수가 모두 낮으면 면접에서 떨어지게 되는 문제이다.
입력값이 많기 때문에 시간복잡도를 어느정도 고려해가며 풀어야 했다.
접근 방식은 생각보다 간단하다.
일단 나는 서류성적을 기준으로 배열을 통해 정렬을 했다.
서류 성적 1등은 당연히 통과가 되므로, 서류성적 2등부터 판별을 해나가면 된다.
서류 성적 1등의 면접 성적 등수를 min값으로 잡는다.
그리고 서류성적 2등부터 반목문을 통해 판별을 시작하는데, 면접 성적의 등수가 min값보다 작으면 통과가 되면 된다.
이렇게 테스트 케이스마다 반복을 해서 통과하는 인원들의 수를 구하면 된다.
*/

import java.io.*;
import java.util.*;

public class baekjoon1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 수

        for(int t = 0; t<T; t++) {  // 테스트 케이스 수만큼 반복
            int N = Integer.parseInt(br.readLine());    // 지원자의 수

            int[] arr = new int[N+1];   // 입력받은 지원자들의 서류성적을 차례대로 정렬하기 위해 사용한 배열이다. arr[n]는 서류성적 n등이다
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            int count = 1;  // 서류성적 1등은 당연히 pass되므로 count는 1부터 시작하고
            int min = arr[1];   // 현재 면접 성적 등수 최솟값인 min 서류성적 1등의 면접성적 등수가 된다.
            for (int i = 2; i <= N; i++) {  // 서류성적 2등부터 판별해 나가면 된다.
                if(arr[i]<min){ // 만약 서류성적 i등의 면접 성적 등수가 min값보다 작으면
                    count++;    // count+1
                    min = arr[i];   // min값 갱신
                }
            }
            sb.append(count).append("\n");  // 판별 끝나고, 통과한 인원 StringBuilder에 저장
        }
        System.out.println(sb); // StringBuilder에 저장된 값들 최종 출력
    }
}