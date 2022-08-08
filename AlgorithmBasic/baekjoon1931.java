// https://www.acmicpc.net/problem/1931
/*
정렬이 필요한 그리디 문제이다.
해당 회의실에서 하루동안 가장 많은 회의를 할 수 있도록 회의들의 시간을 고려해서 회의들을 골라야 한다.
난이도에 비해 생각보다 어렵게 풀었으나, 풀고나니 간단한 문제였다.
풀이 방법은 다음과 같다.
우선 회의들을 회의가 끝나는 시간을 기준으로 정렬을 하면 된다.
제일 먼저 종료되는 회의를 회의실에 배정하여 집어넣는다.
다음 회의들을 순회하며, 이전에 배정되어 집어넣은 회의의 종료 시간보다 회의 시작시간이 같거나 늦으면 해당 회의를 집어넣는 식으로 진행하면 된다.
이런식으로 쭉 순회를 하면 해당 회의실에 가장 많은 회의를 배정할 수 있다.
자세한 코드는 아래를 참고하면 된다.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 회의 수

        ArrayList<Node> list = new ArrayList<>();   // 회의들의 시작시간과 종료시간을 저장할 list 생성
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Node(start, end));
        }

        Collections.sort(list); // list 정렬

        int count = 0;   // 회의 수
        int preEnd = 0; // 배정 완료된 이전 회의의 종료 시간
        for (int i = 0; i < N; i++) {   // 모든 회의들을 순회하며
            Node cur = list.get(i);
            if(preEnd<=cur.start){  // 만약 이전 회의의 종료시간보다 지금의 회의의 시작시간이 같거나 늦으면
                preEnd = cur.end;   // 이전 회의의 종료시간을 해당 회의의 종료시간으로 변경
                count++;    // count +1
            }
        }

        System.out.println(count);  // count 최종 출력
    }
    static class Node implements Comparable<Node>{  // 각 회의의 시작시간과 종료시간을 저장할 때 이용할 Node객체이다.
        int start;
        int end;
        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override   // Comparable을 구현하여 compareTo메서드 Override
        public int compareTo(Node o) {
            if(this.end == o.end) return this.start-o.start;    // 회의 종료 시간이 같으면 회의 시작 시간을 기준으로 정렬
            else return this.end - o.end;   // 회의 종료 시간이 같지 않으면 회의 종료시간 기준으로 정렬
        }
    }
}