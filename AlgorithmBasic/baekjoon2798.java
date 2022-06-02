// https://www.acmicpc.net/problem/2798

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());    // 카드 수와 목표 값을 받아옴
        StringTokenizer st2 = new StringTokenizer(br.readLine());   // 카드들을 받아옴
        int N = Integer.parseInt(st.nextToken());   // 카드 수
        int target = Integer.parseInt(st.nextToken());  // 목표 값
        int[] arr = new int[N]; // 카드들의 값을 저장할 배열
        for(int i = 0; i<N; i++){   // 배열에 카드 값들 저장
            arr[i]= Integer.parseInt(st2.nextToken());
        }
        int max=0;
        for(int i = 0; i<N-2; i++){             // 중복되지 않게
            for(int j = i+1; j<N-1; j++){       // 반복문 조건 설정 후
                for(int k = j+1; k<N ; k++){    // 반복문 실행
                    int sum = arr[i] + arr[j] + arr[k]; // 3카드의 합
                    if (sum == target) {    // 합이 목표 값이면 바로 return
                        System.out.println(target);
                        return;
                    } else if (sum < target && sum > max) { // 합이 목표값보다 작고 현재의 max값보다 크면
                        max = sum;                          // max값 변경
                    }
                }
            }
        }
        System.out.println(max); // 최종 출력
    }
}