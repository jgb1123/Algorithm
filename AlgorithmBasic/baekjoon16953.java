// https://www.acmicpc.net/problem/16953
/*
bfs를 활용하면 되는 최단거리 문제이다.
탐색 시 현재의 위치와, 현재까지의 이동횟수를 저장할 Node라는 객체를 만들어서 사용했고,
지금까지 많이 풀어본 그냥 단순한 bfs문제이므로, 딱히 설명할게 없어보인다.

자세한 풀이 방법은 아래 코드를 확인하면 된다.
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());   // 시작 지점
        int target = Integer.parseInt(st.nextToken());  // 목표 지점
        Queue<Node> Q = new LinkedList<>(); // bfs에 사용할 Queue로, Node객체가 들어가며 Node객체에는 현재의 위치와 현재까지의 이동횟수가 들어간다.
        Q.offer(new Node(start, 1));    // 시작지점에서 count는 1로 시작
        boolean found = false;  // 목표지점 발견 여부 확인을 위한 boolean 변수이다.
        while (Q.size()>0) {
            Node cur = Q.poll();
            if (cur.num == target) {    // 만약 현재의 위치가 목표 지점이면
                System.out.println(cur.count);  // 현재 이동횟수를 출력하고
                found = true;   // 목표지점 발견 여부 true 처리
                break;  //   반복문 탈출
            }
            if (cur.num*2<=target) {  // 현재의 위치*2가 목표 지점보다 작으면
                Q.offer(new Node(cur.num*2, cur.count+1));  // 해당 지점 탐색을 위해 Queue에 offer, count는 +1
            }
            if (cur.num*10+1<=target) { // 현재의 위치 * 10 + 1이 목표지점보다 작으면
                Q.offer(new Node(cur.num*10+1, cur.count+1));   // 해당 지점 탐색을 위하 Queue에 offer, count는 +1
            }
        }
        if(!found) System.out.println(-1);  // 목표지점을 발견하지 못했으면 -1출력
    }
    static class Node{  //탐색에 사용할 Node객체
        long num;   // 위치
        int count;  // 지금까지의 이동 횟수
        public Node(long num, int count){
            this.num = num;
            this.count = count;
        }
    }
}