// https://www.acmicpc.net/problem/1107
/*
브루트 포스 문제라는 걸 파악하게 되면 생각보다 어렵지 않게 풀 수 있는 문제인 것 같다.
나의 풀이 방법은 간단하다.
고장나지 않은 버튼들로 만들 수 있는 수를 모두 만들며,
목표 채널 N과의 차이인 |N - 만든 수|를 구하고 list에 저장하면 된다.
이때 주의해야 할 점이 있는데, 예를 들면 5자리 수를 만들었으면 |N - 만든 수| + 5가 list에 들어가야 한다. (5자리 수를 만드려면 버튼 5번 눌러야 함)
또 추가로 주의해야 할 점이 시작 채널이 100이라는 부분이다. 그래서 제일 먼저 |N - 100| 을 list에 저장해주었다.
최종적으로 list에 저장된 수 들중 가장 작은 수를 출력하면 된다.

물론 풀고나니 효율적인 코드라는 생각이 안했다. 
당연히 더 세세하게 코드를 짜면 더 효율적인 코드를 짤 수 있을 것이지만, 우선 풀었다는 것에 의의를 두고 넘어가려고 한다. 
실제로 성능이 더 좋았던 정답 코드들을 보니, 성능을 올리기 위해 코드가 굉장히 복잡해지는 것을 확인 했고,
내 풀이 방법도 문제의 시간 제한에 비해 굉장히 빠른 시간으로 넉넉하게 통과했기 때문에 넘어가고자 한다.
*/

import java.io.*;
import java.util.*;

public class baekjoon1107 {
    static int N, M;
    static boolean[] broken;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 목표 채널
        M = Integer.parseInt(br.readLine());    // 고장난 버튼 수
        checkBroken(br);  // 고장난 버튼 확인용 배열을 생성하는 메서드

        list = new ArrayList<>();   // 지금 만들어진 채널에서 목표 채널과의 차이 + 지금까지 누른 버튼 수를 저장할 list (위 설명 참고)
        list.add(Math.abs(N-100));  // 첫 채널이 100이므로, 목표 채널과 100과의 차이를 list에 저장

        recur(0, 0);    // 재귀함수는 처음 수 0, 자릿수 0으로 시작

        System.out.println(Collections.min(list));  // list에 저장된 수 중 가장 작은 수 출력
    }

    static void checkBroken(BufferedReader br) throws IOException {
        broken = new boolean[10];   // 버튼은 0~9까지 boolean배열로 고장 여부 확인
        if(M>0) {   // 고장난 버튼 수가 1개 이상이라면
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;    // 고장난 버튼을 입력받아 true로 처리
            }
        }
    }

    static void recur(int next, int n){ // 재귀를 통한 브루트 포스 구현 (결국 고장나지 않은 버튼들로 만들 수 있는 모든 수를 1~6자리수까지 만듬)
        for (int i = 0; i < 10; i++) {
            if(!broken[i]) {    // 고장난 버튼이 아니라면
                int cur = next + i * (int) Math.pow(10, n); // 지금 값은 (이전의 값) + (지금의 버튼) * 10^(현재 자릿수를 정할 n)
                list.add(Math.abs(N - cur)+n+1);    // 해당 값과 목표 채널의 차이 + 해당 값을 만들기 위해 누른 버튼 수 list에 저장
                if (n < 5) {    // n이 5 미만이면 (5자리수 이하이면) 
                    recur(cur, n + 1);  // 자릿수를 1개 늘려서 다시 재귀
                }
            }
        }
    }
}