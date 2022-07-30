// https://www.acmicpc.net/problem/1074
/*
그냥 단순한 재귀 문제겠거니 싶어서 그냥 시간복잡도도 고려하지 않고 풀었다가 다시풀었다.
입력 조건도 확인하지 않고 그냥 재귀로 풀었는데 당연히 시간초과였다.
그래서 문제를 다시 천천히 읽었고, 아 예전에 한번 본적이 있는 분할정복을 이용해야 하는구나 라는걸 깨달았다.

일단은 접근 방식은 이렇다.
0  1  4  5
2  3  6  7
8  9  12 13
10 11 14 15
예시로 좌표가 6번인 (1,2)에 있다고 가정을하고 접근을 해본다. (각 좌표의 값들은 해당 좌표의 방문 순서를 의미함)
여기서 규칙을 찾아보면 되고, 지금 배열의 길이를 length, 길이의 절반을 half라고 한다.
위와 같은 예시에서 2사분면의 시작은 0, 1사분면의 시작은 4, 3사분면의 시작은 8, 4사분면의 시작은 12라는 것을 알 수 있다.
여기서 식을 만들어 보면 각 사분면의 시작 값은 half * half * 해당사분면의 할당 값(2사분면 0, 1사분면 1, 3사분면 2, 4사분면 3)을 하면 된다.
예시의 지금의 좌표는 (y < half && x < length)일 경우인 1사분면에 속하게 된다.
이때의 1사분면의 시작 값(방문 순서)은 4로, half*half*1(1사분면 이기 때문)이다.
그다음 해당 사분면을 기준으로 그 사분면을 또 4사분면으로 나눠서 구하도록 재귀를 돌면서 구하면 된다.
(재귀를 돌때 해당 사분면을 기준으로 다시 재귀를 돌아야 하므로, 목표 좌표를 해당 사분면 기준으로 다시 맞춰서 재귀를 돌아야 한다. 코드참고)
글로 설명하려고 하니 힘든데, 코드를 확인해보면 더 쉽게 이해할 수 있을 것이다.

문제를 자세히 읽고 시간복잡도를 고려해보는 습관을 놓치지 않아야 겠다는걸 느꼈다.
또한 분할정복 문제를 많이 풀어보진 않아서, 해당 문제를 분할정복으로 다시 푸는데도 시간이 많이 걸렸다.
그래도 다음에 비슷한 문제가 나오면 더 쉽게 풀 수 있을것이다.
*/


import java.io.*;
import java.util.StringTokenizer;

public class baekjoon1074 {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 배열의 길이를 결정할 값 (배열의 길이는 2^N)
        int r = Integer.parseInt(st.nextToken());   // 목표 y좌표
        int c = Integer.parseInt(st.nextToken());   // 목표 x좌표
        count = 0;  // 최종 출력될 값
        int length = (int) Math.pow(2, N);  // 배열의 길이는 2^N이다.

        recur(r, c, length);    // 목표좌표들과 배열의 길이로 재귀

    }
    static void recur(int r, int c, int length){
        int half = length/2;
        if(length>1) {
            if (r < half && c < half) { // 목표 좌표가 왼쪽 위인 2사분면에 속하면
                recur(r, c, half);  // 목표좌표는 변함 없고, length는 절반으로 다시 재귀
            } else if (r < half && c < length) { // 목표 좌표가 오른쪽 위인 1사분면에 속하면
                count += half * half;   // 1사분면의 시작값(방문 순서)인 half*half*1을 count에 더해준다.
                recur(r, c-half, half); // 목표 좌표는 해당 사분면을 기준으로 다시 맞춰야 하므로 (r,c-half)로 재귀를 돌면 된다.
            } else if (r < length && c < half) {    // 목표 좌표가 왼쪽 아래인 3사분면에 속하면
                count += half * half * 2;   // 3사분면의 시작값(방문 순서)인 half*half*2을 count에 더해준다.
                recur(r-half, c, half); // 목표 좌표는 해당 사분면을 기준으로 다시 맞춰야 하므로 (r-half,c)로 재귀를 돌면 된다.
            } else if (r < length && c < length) {  // 목표 좌표가 오른쪽 아래인 4사분면에 속하면
                count += half * half * 3;   // 4사분면의 시작값(방문 순서)인 half*half*3을 count에 더해준다.
                recur(r-half, c-half, half);    // 목표 좌표는 해당 사분면을 기준으로 다시 맞춰야 하므로 (r-half,c-half)로 재귀를 돌면 된다.
            }
        } else {
            System.out.println(count);  // length가 1이 됐을때 count값을 출력하면 목표 좌표의 순서를 구할 수 있다.
        }
    }
}