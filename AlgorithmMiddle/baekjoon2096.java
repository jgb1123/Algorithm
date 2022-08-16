// https://www.acmicpc.net/problem/2096
/*
난이도에 비해 간단한 dp문제였다.
나의 풀이 방법은 다음과 같다.
dp배열을 2개를 만들었으며, 최대 점수를 위한 dpMax배열과, 최소 점수를 위한 dpMin배열을 각각 만들었다.
dpMax[i][0] = arr[i][0]+Math.max(dpMax[i-1][0], dpMax[i-1][1]),
dpMax[i][1] = arr[i][1]+Math.max(dpMax[i-1][0], Math.max(dpMax[i-1][1], dpMax[i-1][2])),
dpMax[i][2] = arr[i][2]+Math.max(dpMax[i-1][1], dpMax[i-1][2]) 이 된다.
해당 점화식들을 통해 Bottom Up방식으로 dp배열을 채워나가면 된다.

dpMin도 비슷하게 max와 min만 바꿔가며 점화식을 만들면 된다.
dpMin[i][0] = arr[i][0]+Math.min(dpMin[i-1][0], dpMin[i-1][1]),
dpMin[i][1] = arr[i][1]+Math.min(dpMin[i-1][0], Math.min(dpMin[i-1][1], dpMin[i-1][2])),
dpMin[i][2] = arr[i][2]+Math.min(dpMin[i-1][1], dpMin[i-1][2]) 이 된다.

그리고 dpMax배열의 마지막줄 중에서 가장 큰 값과, dpMin배열의 마지막줄 중에서 가장 작은 값을 출력하면 된다.
*/

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 배열의 행 길이 (열 길이는 3으로 고정)
        int[][] arr = new int[N][3];    // 입력받은 값들을 저장할 2차원 배열 생성
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        int[][] dpMax = new int[N][3];  // 최대 점수를 위한 dpMax배열
        int[][] dpMin = new int[N][3];  // 최소 점수를 위한 dpMin배열

        dpMax[0] = arr[0];  // 첫줄은 arr배열과 같은 값으로 초기화
        dpMin[0] = arr[0];  // 첫줄은 arr배열과 같은 값으로 초기화

        for (int i = 1; i < N; i++) {   // 위에서 설명한 점화식들을 통해 dp배열을 채워 나간다.
            dpMax[i][0] = arr[i][0]+Math.max(dpMax[i-1][0], dpMax[i-1][1]);
            dpMax[i][1] = arr[i][1]+Math.max(dpMax[i-1][0], Math.max(dpMax[i-1][1], dpMax[i-1][2]));
            dpMax[i][2] = arr[i][2]+Math.max(dpMax[i-1][1], dpMax[i-1][2]);

            dpMin[i][0] = arr[i][0]+Math.min(dpMin[i-1][0], dpMin[i-1][1]);
            dpMin[i][1] = arr[i][1]+Math.min(dpMin[i-1][0], Math.min(dpMin[i-1][1], dpMin[i-1][2]));
            dpMin[i][2] = arr[i][2]+Math.min(dpMin[i-1][1], dpMin[i-1][2]);
        }

        int max = Math.max(dpMax[N-1][0], Math.max(dpMax[N-1][1], dpMax[N-1][2]));  // dpMax배열의 마지막 줄 요소 중 가장 큰값이 max값
        int min = Math.min(dpMin[N-1][0], Math.min(dpMin[N-1][1], dpMin[N-1][2]));  // dpMin배열의 마지막 줄 요소 중 가장 작은값이 min값
        System.out.println(max+" "+min);    // max값과 min값 출력
    }
}