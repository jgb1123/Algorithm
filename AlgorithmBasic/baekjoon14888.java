// https://www.acmicpc.net/problem/14888
/*
문제의 시간복잡도를 고려해보니 브루트포스로 접근해도 충분히 여유가 있을 것 같아서 브루트포스로 접근했다.
백트래킹을 이용해 구현했으며, 구현 방법은 아래와 같다.
우선 arr 배열에 수열을 저장한다.
oper 배열에 각 연산자들의 개수를 저장한다. (+, -, *, / 순이다)
그리고 재귀를 통해 모든 연산자들의 경우의 수를 고려해 연산을 했고,
마지막 연산까지 끝났을때의 값들을 max, min값들과 비교해가며 최종적인 max, min값을 구했다.
자세한 내용은 아래 코드를 보면 쉽게 이해할 수 있을 것이다.

문제의 난이도는 어렵지 않았고, 금방 풀 수 있었다.
 */

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon14888 {
    static int[] arr, oper;
    static int max, min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        makeArr(br, N); // 입력된 값들을 배열로 만드는 메서드
        makeOper(br);   // 연산자 개수를 저장할 배열을 만드는 메서드

        max = Integer.MIN_VALUE;    // max값 초기화
        min = Integer.MAX_VALUE;    // min값 초기화
        recur(1, arr[0]);   // index는 1, cur값은 arr[0]으로 재귀 시작
        System.out.println(max);    // max값 출력
        System.out.println(min);    // min값 출력
    }

    static void makeArr(BufferedReader br, int N) throws IOException {  // 입력된 값들을 배열로 만드는 메서드
        StringTokenizer st;
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void makeOper(BufferedReader br) throws IOException {    // 연산자 개수를 저장할 배열을 만드는 메서드
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        oper = new int[4];
        for (int i = 0; i < oper.length; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void recur(int index, int cur){  // 백트래킹용 재귀 메서드
        if(index == arr.length){    // 만약 끝까지 연산이 끝났으면
            if(max<cur) max = cur;  // 그 값을 max값과 비교 후 더 크면 max값 갱신
            if(min>cur) min = cur;  // 그 값을 min값과 비교 후 더 작으면 min값 갱신
            return; // 메서드 종료
        }
        for (int i = 0; i < oper.length; i++) {
            int next = cur; // 다음 값인 next 현재의 값으로 초기화
            if (i == 0 && oper[i]>0) {  // +일때,
                oper[i]-=1; // 해당 연산자의 횟수 -1
                next += arr[index]; // arr에 저장된 값 더해줌
                recur(index+1, next);   // arr에 사용될 index +1, 현재 next값으로 재귀
                oper[i] += 1;   // 재귀 종료 후 해당 연산자의 횟수 다시 +1
            } else if (i == 1 && oper[i]>0) {   // -일때
                oper[i]-=1;
                next -= arr[index];
                recur(index+1, next);
                oper[i] += 1;
            } else if (i == 2 && oper[i]>0) {   // *일때
                oper[i]-=1;
                next *= arr[index];
                recur(index+1, next);
                oper[i] += 1;
            } else if (i == 3 && oper[i]>0) {   // /일때
                oper[i]-=1;
                next /= arr[index];
                recur(index+1, next);
                oper[i] += 1;
            }
        }
    }
}