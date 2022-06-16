// https://www.acmicpc.net/problem/11659
/*
시간복잡도를 고려하지 않고 풀면 그냥 단순하게 2중 for문을 이용하여 풀면 되는 아주 간단한 문제가 되지만,
입력 데이터가 100,000개 이고 복잡도가 O(N^2)이 되기 때문에  시간초과가 된다.
N개의 수가 주어지면 1번째 수 까지의 합, 2번째 수 까지의 합, ... N번째 수 까지의 합을 모두 배열에 저장하고,
만약 3번째 수 부터 N번째 수 까지의 합을 구해야 하면 (N번째 수 까지의 합) - (2번째 까지의 합)을 해주면 된다.
정리하면 A부터 B까지의 합을 구하려면 (B 까지의 합) - (A-1 까지의 합)이 된다.

*/
import java.io.*;
import java.util.StringTokenizer;

public class baekjoon11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 수의 개수 N
        int M = Integer.parseInt(st.nextToken());   // 합을 구해야 하는 횟수 M
        int[] arr = new int[N+1];   // index번째 숫자까지의 합을 저장할 배열 arr (인덱스를 편하게 쓰기 위해 1부터 이용함)
        int sum =0; // 합을 저장할 변수
        StringTokenizer st2 = new StringTokenizer(br.readLine());   // N개의 수들
        for(int i = 1; i<=N ;i++){ // 수의 개수만큼 반복
            sum += Integer.parseInt(st2.nextToken());   // 하나씩 sum에 더해가며
            arr[i] = sum;   // arr배열에 그 숫자까지의 sum을 저장
        }

        for(int i = 0; i<M; i++){
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st3.nextToken());
            int b = Integer.parseInt(st3.nextToken());
            sb.append(arr[b]-arr[a-1]).append("\n");    // a~b 까지의 합은 (b 까지의 합) - (a-1 까지의 합)
        }
        System.out.println(sb); // 최종 출력
    }
}