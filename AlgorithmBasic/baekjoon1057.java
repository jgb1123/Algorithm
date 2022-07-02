// https://www.acmicpc.net/problem/1057
/*
간단한 브루트포스 문제이고, 문제에 함정이 있다.
만약 서로 대결을 하지 않을때는 -1을 출력한다는데,
두 명이 토너먼트식 경기에서 계속 이기면 결승전에서라도 만나서 대결을 하게 된다.
그래서 저 조건은 신경쓰지 않아도 된다.
또 참가자 수 N이 주어지는데 사실 이 요소도 내가 접근한 풀이 방법에선 필요 없다.
풀이 방법은 간단하다. round 진행 수를 count라 정했다.
참가자수가 7명이고, 김지민이 4번, 임한수가 7번으로 출전한 경우를 생각하면 간단하다.
첫 경기가 끝나면 김지민은 2번이 되고, 임한수는 4번이 된다. (count +1, 임한수는 부전승)
두번째 경기가 끝나면 김지민은 1번이 되고, 임한수는 2번이 된다. (count +1)
세번째 경기가 끝나면 김지민은 1번이 되고, 임한수도 1번이 된다. (count +1)
만약 이렇게 번호가 같아지면, 같이 대결을 했다는 뜻이다.

정리해보면 라운드가 끝날때마다 (각자의 번호+1)/2를 해주고, count를 증가시킨다.
이렇게 해주면 각 경기에서 한명씩만 올라가고, 예시로 1번과 2번이 붙으면 누가 이기던 다음 라운드의 1번으로 된다.(마지막 홀수번째의 경우 부전승도 알아서 처리됨)
만약 그러다가 각자의 번호가 같아지게 되면 둘이 만나서 경기를 했다는 뜻이므로, 반복문을 종료하고 count를 출력하면 된다.
따라서 참가자 수 N은 이 문제에서 필요 없다.
*/

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken()); // 김지민의 번호
        int lim = Integer.parseInt(st.nextToken()); // 임한수의 번호
        int count = 0;  // 토너먼트 라운드 수 0으로 초기화
        while(kim != lim){ // 만약 각자의 번호가 같아지면 만나서 대결을 했다는 의미가 되므로, 반복문 종료
            kim = (kim+1)/2;    // 김지민의 다음 라운드 번호
            lim = (lim+1)/2;    // 임한수의 다음 라운드 번호
            count++;    // count +1
        }
        System.out.println(count);  // 반복문 종료 후 최종 출력
    }
}