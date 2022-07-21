// https://www.acmicpc.net/problem/11497
/*
인접한 통나무의 높이의 차들을 가작 작게 만들 수 있도록 통나무를 정렬하면 되는 문제이다.

풀이 방식은 간단하다.
일단 입력으로 통나무들의 높이를 모두 arr 배열에 저장하고, 오름차순으로 정렬을 한다.
조금 조심해야 할 부분은, 통나무를 원 모양으로 세우기 때문에, 그냥 오름차순으로만 정렬하고 최종 결과로 만들면 안된다.
(맨 처음 통나무와 맨 마지막 통나무도 그 높이의 차를 구해야 하기 때문에 오름차순으로 바로 끝내면 가장 Worst한 케이스가 되버린다.)
정렬된 arr를 최종 통나무의 순서를 담을 result 배열에 다시 저장을 하는데,
이때 맨 앞, 맨 뒤, 맨 앞에서 2번째, 맨뒤에서 2번째 이런식으로 저장해야 인접한 통나무의 높이의 차들이 가장 작게 만들 수 있다.
(이 저장 방법은 반복문을 통해 나름 간단하게 구현할 수 있다.)
그리고 그렇게 저장된 result의 인접한 요소들의 차를 구하면 되는데,
맨 앞통나무와 맨 뒤 통나무도 이어져 있기 때문에 이 차이도 구해야 한다.
이 부분은 그냥 맨 앞 통나무의 높이를 배열 맨 뒤에 하나 더 추가해서 연산을 할 수 있도록 만들었다.

역시나 풀이보다 설명이 어렵다.
아래 코드를 참고하면 더 이해가 쉬울 것이다.
*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 개수
        for (int i = 0; i < T; i++) {   // 테스트 케이스만큼 반복
            int N = Integer.parseInt(br.readLine());    // 통나무 수 가져옴

            int[] arr = getSortedInputArr(br, N);   // 통나무들의 높이를 입력받아 정렬하는 메서드

            int[] result = getResultArr(N, arr);    // 최종 통나무의 순서가 정렬된 배열을 만드는 메서드

            int max = Integer.MIN_VALUE;    // 높이 차이의 max값
            for (int j = 1; j < N; j++) {
                int dif = Math.abs(result[j-1]-result[j]);  // 이전요소와 지금의 요소의 차의 절대값이
                if(dif>max) max = dif;  // max값보다 크면 갱신
            }
            sb.append(max).append("\n");    // 해당 max값 StringBuilder에 저장
        }
        System.out.println(sb); // StringBuilder에 저장된 값들 출력

    }

    static int[] getSortedInputArr(BufferedReader br, int N) throws IOException {   // 통나무들의 높이를 입력받아 정렬하는 메서드
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int j = 0; j < N; j++) {
            arr[j]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);   // Arrays.sort()를 이용해 정렬
        return arr;
    }

    static int[] getResultArr(int N, int[] arr) {   // 최종 통나무의 순서가 정렬된 배열을 만드는 메서드
        int[] result = new int[N +1];   // 맨 뒤 요소에 맨 앞 요소를 하나 더 넣어주기 위해 N+1로 생성 (높이 차를 편하게 구하기 위함)
        result[0] = arr[0]; // 맨 앞과
        result[N] = arr[0]; // 맨 뒤는 arr의 가장 작은 값인 arr[0]
        int a = 0;  // result의 요소가 8개라면 result에 0 7 1 6 2 5 3 4 순으로 arr의 값이 저장되야 한다. 맨 앞, 맨 뒤, 맨 앞에서 2번째, 맨 뒤에서 2번째.... 순이다
                    // 여기서 규칙을 찾아보면 인덱스의 앞뒤 요소의 차는 +7 -6 +5 -4 +3 -2 +1 인것을 알 수 있고,
                    // 그 순서를 구하기 위해 a와 b라는 변수를 만들어 활용했다.
        int b = N -1;   // 위 예시에서 보면 +(N-1)부터 시작해야 함. b는 인덱스의 앞뒤 요소의 차이의 절대값이다
        for (int j = 1; j < N; j++) {   // j는 1부터
            if(j%2==0){ // 만약 j가 짝수면
                a -= b; // -를,
            }else{      // j가 홀수면
                a += b ; // +를 하면 된다
            }
            result[a]= arr[j];
            b--;    // 한번 돌고 b--를 해야 위 규칙이 성립됨
        }
        return result;
    }
}