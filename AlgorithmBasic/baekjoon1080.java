// https://www.acmicpc.net/problem/1080
/*
생각보다 간단한 문제이다.

일단 입력으로 뒤집어가면서 바꿔나갈 arr 배열과, 최종 목표배열인 target배열을 만든다
3*3 크기씩 뒤집을 수 있기 때문에, 만약 배열의 길이가 3보다 작고 arr와 target가 다른 배열이면
arr를 뒤집을 수 없으므로 target으로 만들 수 없다. (-1 출력)
배열의 길이가 3이상이면 차례대로 요소들을 비교해가며 뒤집으면서 target배열과 같이 만들면 된다.

조금만 생각해보면, 앞에서부터 차례대로 비교해가며 뒤집는게 최소로 뒤집을 수 있는 방법이란 걸 알 수 있다.
좀더 간단하게 가로로 3개씩만 뒤집는 케이스로 생각해보면,
10011 에서 01011을 만들어야 하는 경우 01111, 01000, 01011 처럼 앞에서부터 차례대로 바꾸는게 제일 적게 뒤집을 수 있다.
왜냐면 괜히 뒤의 요소를 먼저 뒤집었다가 앞에 요소도 뒤집어야 해서 다시 뒤집으면 뒤에 요소는 다시 뒤집어져 또다시 뒤집어야 하는 상황이 생길 수 있다.

그래서 arr[0][0] ~ arr[N-3][M-3]까지 반복문을 통해 차례대로 target과 비교를 하며 뒤집어가면 된다.
만약 arr[0][0]이 result[0][0]과 다르면, 
오른쪽으로 3칸, 아래쪽으로 3칸인 arr[2][2]까지 9개 뒤집으면 되고 뒤집은 수를 1 카운팅 해준다. (count + 1)
그다음 다시 arr[0][1]부터 arr[N-3][M-3]까지 같은 방식으로 반복하면 된다.
3*3의 크기씩 뒤집어야 하기 때문에 비교 마지막 요소는 arr[N-3][M-3]이 되어야 한다.

작업을 모두 완료하고 최종적으로 arr와 target이 다르면 arr로 target은 만들 수 없으므로 -1을 출력하고,
arr와 target이 같으면 뒤집은 수인 count값을 출력하면 된다.

항상 느끼는 거지만 생각보다 간단한 문제여도, 글로만 설명하려고 하면 힘든 경우가 많은 것 같다.
*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];    // arr 배열
        int[][] target = new int[N][M]; // target 배열

        for (int i = 0; i < N; i++) {   // arr배열 입력받아서 생성
            String str1 = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str1.charAt(j)-'0';
            }
        }
        for (int i = 0; i < N; i++) {   // target배열 입력받아서 생성
            String str2 = br.readLine();
            for (int j = 0; j < M; j++) {
                target[i][j] = str2.charAt(j)-'0';
            }
        }
        int count = 0;  // 뒤집은 수
        if(N<3||M<3){   // 만약 길이가 3이하면 뒤집을 수 없기 때문에
            if(Arrays.deepEquals(arr, target)) System.out.println(count);   // arr와 target이 같으면 뒤집은 수 0 출력
            else System.out.println(-1);    // 다르면 -1출력
            return; // 종료
        }
        
        for (int i = 0; i < N-2; i++) { // arr[N-3][M-3]까지만 비교해야 함
            for (int j = 0; j < M-2; j++) { // arr[N-3][M-3]까지만 비교해야 함
                if(arr[i][j]!=target[i][j]){    // 만약 비교 결과 다르면
                    count++;    // 뒤집는 수 1 증가시키고
                    flip(arr, i, j);    // 오른쪽으로 3칸 아래쪽 3칸까지 총 9개 뒤집음
                }
            }
        }
        if(!Arrays.deepEquals(arr, target)){    // 여전히 arr와 target이 다르면 arr로는 target을 만들 수 없으므로 -1출력
            System.out.println(-1);
        }else {
            System.out.println(count); // arr와 target이 같으면 뒤집은 수 출력
        }

    }

    private static void flip(int[][] arr, int i, int j) {   // 뒤집는 메서드
        for (int k = 0; k < 3; k++) {   // 0~2까지    (아래쪽으로 3칸까지)
            for (int l = 0; l < 3; l++) {   // 0~2까지    (오른쪽으로 3칸까지)
                if(arr[i +k][j +l]==0){ // 만약 0이면 1로 변경
                    arr[i +k][j +l]=1;
                }else{  // 1이면 0으로 변경
                    arr[i +k][j +l]=0;
                }
            }
        }
    }
}