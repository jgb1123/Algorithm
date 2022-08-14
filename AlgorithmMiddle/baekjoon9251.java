// https://www.acmicpc.net/problem/9251
/*
dp문제로 접근해야 한다는 것을 알아내고, 어찌저찌 겨우 풀어낸 문제이다.
dp배열은 다음과 같이 채워진다.
각 알파벳까지 사용했을 때, 부분수열이 되는 수열중 가장 긴 길이를 의미한다.
풀이할 때 접근 방식은 예시를 이용하여 점화식을 찾는 방식으로 접근했다.
   arrA A  C  A  Y  K  P
arrB
C       0  1  1  1  1  1
A       1  1  2  2  2  2
P       1  1  2  2  2  2
C       1  2  2  2  2  2
A       1  2  3  3  3  3
K       1  2  3  3  4  4

예시의 경우 위와같이 dp배열이 채워지며, 여기서 점화식을 찾으면 된다.
여기서 점화식을 찾아보면,
만약 arrB[i]와 arrA[j]가 같으면, dp[i][j] = dp [i-1][j-1]+1이 된다.
그 외의 경우에는, dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1])이 된다.
해당 점화식을 통해 코드를 구현하면 된다.
코드를 구현할 때 index만 조금 고려해서 구현하면 어렵지 않게 구현할 수 있다.
*/
import java.io.*;

public class baekjoon9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arrA = br.readLine().toCharArray();  // 첫번째 입력문자열을 char배열로
        char[] arrB = br.readLine().toCharArray();  // 두번째 입력문자열을 char배열로

        int[][] dp = new int[arrB.length+1][arrA.length+1]; // 두 arrA, arrB배열의 길이만큼 dp배열 생성 (index를 고려하여 각 length+1로 생성)

        for (int i = 1; i < arrB.length+1; i++) {   // 1부터 arrB의 길이까지 반복
            for (int j = 1; j < arrA.length+1; j++) {   // 1부터 arrA의 길이까지 반복
                if(arrB[i-1] == arrA[j-1]) dp[i][j] = dp[i-1][j-1]+1;   // 위 설명에서 찾은 점화식으로, index만 조금 고려하여 구현하면 된다.
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);   // 위 설명에서 찾은 점화식
            }
        }
        System.out.println(dp[arrB.length][arrA.length]);   // dp배열의 마지막 요소 최종 출력
    }
}