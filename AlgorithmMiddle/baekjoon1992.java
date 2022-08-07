// https://www.acmicpc.net/problem/1992
/*
간단한 분할정복 문제이다.
풀면서 딱히 어려운 부분은 없었고, 요즘 분할정복 문제를 많이 접하게 되었는데, 그래서 그런지 어렵지 않게 풀었다.
접근방식은 이렇다.
재귀 메서드를 통해 우선 for문을통해 모든 요소들을 확인하고 만약 첫 글자와 다른 글자가 발견되면,
왼쪽위, 오른쪽위, 왼쪽아래, 오른쪽아래 이렇게 4 면으로 나눠서 다시 재귀를 돌면 된다.
4면으로 나눠서 재귀를 돌기전에 괄호 "("를 StringBuilder에 추가하고, 4개의 재귀를 모두 돌고나서 ")"를 StringBuilder에 추가하면 된다.

비슷한 분할정복 문제는 꽤 풀어봤으니 이정도 설명만 하고 넘어가면 될 것 같다.
자세한 내용은 아래 코드를 참고하면 된다.
*/

import java.io.*;

public class baekjoon1992 {
    static int[][] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 배열의 길이
        sb = new StringBuilder();

        arr = new int[N][N];    // 입력받은 값 저장을 위한 arr 생성
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        recur(0, 0, N); // 기준좌표 (0, 0) 나뉜 배열의 크기는 N으로 재귀 시작
        System.out.println(sb); // 최종 출력
    }
    static void recur(int y, int x, int N){
        int half = N/2; // 절반 길이
        int a = arr[y][x];  // arr의 처음 값을 저장
        if(N>=2) {  // 2 이상일경우에만
            for (int i = y; i < y+N; i++) { //  for문을 돌면서 입력받아온 길이만큼만 고려하여 순회를 함
                for (int j = x; j < x+N; j++) {
                    if (arr[i][j] != a) {   // 만약 처음 저장한 값인 a와 다른 값이라면
                        sb.append("("); // 4가지 면으로 나눠서 재귀를 돌기 전 "(" 추가
                        recur(y, x, half);  // 왼쪽 위
                        recur(y, x + half, half);   // 오른쪽 위
                        recur(y + half, x, half);   // 왼쪽 아래
                        recur(y + half, x + half, half);    // 오른쪽 아래
                        sb.append(")"); // 재귀 다돌고 ")"추가
                        return;
                    }
                }
            }
        }
        // 만약 for문을 이슈없이 모두 마치고 나왔거나, 길이가 1이라면
        if (a == 1) sb.append(1);   // a가 1이면 1 추가
        else sb.append(0);  // a가 0이면 0 추가

    }
}