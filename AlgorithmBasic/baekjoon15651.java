// https://www.acmicpc.net/problem/15651
/*
baekjoon15649문제와 동일한 방식으로 풀었고,
이전에 사용했던 수도 중복상관없이 사용할 수 있으므로,
방문확인을 위한 배열을 사용하지 않으면 된다.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon15651 {
    static StringBuilder sb;
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
        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }
        recur(0);
        System.out.println(sb);

    }
    static void recur(int index){
        if(index<result.length) {
            for (int j : arr) { //방문확인 필요없으 그냥 향상된 for문으로 반복
                result[index] = j;
                recur(index + 1);
            }
        } else {
            for(int i : result){
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
    }
}