// https://www.acmicpc.net/problem/15652
/*
baekjoon15649문제와 동일한 방법으로 풀었고,
중복이 허용되므로 방문확인용 배열이 필요 없고,
재귀함수에 start변수를 추가하여 재귀함수를 돌 때 for문의 시작 값만 잘 설정해주면 된다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon15652 {
    static StringBuilder sb;
    static boolean[] visit;
    static int[] arr;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = new int[M];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }
        recur(0, 0);
        System.out.println(sb);

    }
    static void recur(int index, int start){
        if(index<result.length) {
            for (int i = start; i < arr.length; i++) {
                result[index] = arr[i];
                recur(index + 1, i);
            }
        } else {
            for(int i : result){
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
    }
}