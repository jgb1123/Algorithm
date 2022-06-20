// https://www.acmicpc.net/problem/15650
/*
baekjoon15649문제와 동일한 방식으로 풀었고,
재귀함수에 start변수를 추가하여 재귀함수를 돌 때 반복문의 시작 값만 잘 설정해주면 된다.

*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon15650 {
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
    static void recur(int index, int start){    // 매개변수로 start를 추가하여
        if(index<result.length) {
            for (int i = start; i < arr.length; i++) {  // 반복문의 시작 값을 start부터 시작하도록 설정
                if(!visit[i]) {
                    result[index] = arr[i];
                    visit[i] = true;
                    recur(index + 1, i + 1);    // 다음 재귀함수를 시작할때 start값을 현재 i의값+1로 하면 된다.
                    visit[i] = false;
                }
            }
        } else {
            for(int i : result){
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
    }
}