// https://www.acmicpc.net/problem/15903
/*
굉장히 간단한 문제였다.
그냥 가장 작은 두 수끼리 합치면서 진행하면 되는 문제이다.
주의할 점은 overflow때문에 long타입을 이용해야 한다. (이 부분을 고려하지 않아 한번 틀렸다.)

처음에는 카드들을 배열에 저장 후, 배열을 Arrays.sort()를 이용해 정렬을 하며 맨 앞 2개의 카드 값만 합치는 방법으로 진행했다.
무난하게 통과했고, 속도가 좀 느릴거라 예상은 했지만 다른사람들의 풀이에 비해 너무 느렸다. (코드 맨아래는 주석처리된 코드는 배열로 푼 풀이)
그래서 찾아보니 우선순위 큐라는걸 이용해서 풀었다.

우선순위 큐란 간단하게 얘기하면, 높은 우선순위의 요소를 먼저 꺼내서 처리하는 구조로 되어있으며, 우선순위의 비교 기준이 필요하다.
비교기준이 없으면 오름차순으로 우선순위가 부여되고, 변경하고 싶으면 생성 시 파라미터로 비교기준을 넣어주면 된다.

비교기준 없이 생성하면 기본적으로 오름차순으로 우선순위가 부여되니, poll()을 호출하면 가작 작은 수가 나오게 된다.
이걸 이용해서 풀었더니 속도가 많이 개선되었다.

문제는 간단했지만, 자료구조에 대한 공부를 좀 해야겠다고 느낀 문제이다.
 */

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 카드의 수
        int m = Integer.parseInt(st.nextToken());   // 카드의 값을 합칠 횟수

        PriorityQueue<Long> PQ = new PriorityQueue<>(); // 우선순위 큐 생성, 비교 기준은 default인 오름차순
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            PQ.offer(Long.parseLong(st2.nextToken()));
        }

        for (int i = 0; i < m; i++) {   // 입력받은 카드의 값을 합칠 횟수만큼 반복
            long a = PQ.poll(); // PQ에서 poll (가장 작은 값이 나옴)
            long b = PQ.poll(); // PQ에서 poll (그다음 작은 값이 나옴)
            PQ.offer(a+b);  // 두 값을 합친 값을 다시 offer함
            PQ.offer(a+b);  // 카드 2장을 뺏으니 합친 값으로 2장 넣어야 함
        }
        long sum = PQ.stream().mapToLong(i -> i).sum(); // stream을 이용해 간단하게 요소들의 합을 구함

        System.out.println(sum);    // sum 최종 출력
    }
}
/*
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        for (int i = 0; i < m; i++) {
            Arrays.sort(arr);
            long a = arr[0]+arr[1];
            arr[0] = a;
            arr[1] = a;
        }
        long sum = Arrays.stream(arr).sum();

        System.out.println(sum);

    }
}
*/