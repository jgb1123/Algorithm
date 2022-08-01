// https://www.acmicpc.net/problem/2630
/*
간단한 분할정복 문제이다.
구현 방식은 다음과 같다.
우선 arr의 첫 요소를 기준으로 잡고 2중 for문을 통해 모든 요소를 탐색한다.
1) 지금의 기준 값과 다른게 나온다면 arr(종이)를 4개로 잘라서 재귀를 돌면 된다. (잘린 arr를 왼쪽 위부터 1,2,3,4번이라고 함)
잘린 arr의 길이는 N의 절반인 N/2(half)가 된다
그 잘린 arr들의 첫 좌표와, 잘린 arr의 길이를 통해 2중 for문을 통해 잘린 arr들을 다시 탐색을 하면 된다.
예시로 자르기 전 종이의 시작좌표를 y, x라고 하면,
1번종이의 시작 좌표는 (y, x), 2번종이의 시작좌표는 (y, x+half), 3번 종이의 시작 좌표는 (y+half, x), 4번종이의 시작 좌표는 (y+half, x+half)가 된다.
따라서 재귀메서드에 파라미터로 잘린 arr의 길이와, 시작좌표들을 넘겨주면서 재귀를 돌면 된다.

2) 만약 탐색을 모두 했는데도 처음에 기준으로 정해놓은 기준 값과 다른 값이 발견이 안되면,
기준값이 1(파란색)이면 파란색종이 개수 +1, 기준값이 0(하얀색)이면 하얀색종이 개수 +1을 해주면 된다.

저번에 분할정복문제를 하나 풀어봐서 그런지 생각보다 간단하게 풀렸다.
이번에도 느끼는 거지만 글로 설명하는게 더힘든거같다.
근데 조금 어려운 분할정복 문제가 나오면 풀기 굉장히 복잡해질 것 같다는 생각이 든다.
*/

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon2630 {
    static int[][] arr;
    static int countW, countB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        getArray(br, N);    // 입력받은 값을 arr에 저장하는 메서드
        countW=0;   // 하얀색 종이 개수
        countB=0;   // 파란색 종이 개수
        recur(N, 0, 0); // 현재 종이길이 N, 시작좌표는 (0, 0)으로 재귀메서드 시작

        System.out.println(countW); // 하얀색 종이 개수 출력
        System.out.println(countB); // 파란색 종이 개수 출력
    }
    static void recur(int N, int startY, int startX){   // 분할정복을 위한 재귀메서드
        int ref = arr[startY][startX];  // 현재 종이의 시작 좌표를 기준값으로 정함 (현재 종이의 첫 좌표는 재귀함수 파라미터로 받아옴)
        int half = N/2; // 현재 종이길이의 절반
        for (int i = 0; i < N; i++) {   //현재 종이의 길이만큼 이중for문으로 탐색
            for (int j = 0; j < N; j++) {
                if(arr[i+startY][j+startX]!=ref){   // 시작 좌표를 고려하여 탐색을 하며, 만약 기준값과 다른 값이 발견되면
                    recur(half, startY, startX);    // 1번종이의 길이와 시작좌표로 재귀
                    recur(half, startY, startX+half);   // 2번종이의 길이와 시작좌표로 재귀
                    recur(half, startY+half, startX);   // 3번종이의 길이와 시작좌표로 재귀
                    recur(half, startY+half, startX+half);  // 4번종이의 길이와 시작좌표로 재귀
                    return; // 자른 종이로 재귀 다 돌면 종료
                }
            }
        }
        // 2중for문을 다 돌고도 종료되지 않았으면(기준값과 다른값이 발견되지 않음)
        if(arr[startY][startX]==1) countB++;    // 만약 기준값이 1이였으면 파란색종이 +1
        else countW++;  // 기준값이 0이였으면 하얀색종이 +1
    }
    static void getArray(BufferedReader br, int N) throws IOException { // 입력받은 값을 arr에 저장하는 만드는 메서드
        arr = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}