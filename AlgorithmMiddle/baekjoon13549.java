// https://www.acmicpc.net/problem/13549
/*
가중치가 있는 bfs문제이다.
저번에 1697번 문제와 거의 비슷하지만, 현재 index에서 index * 2로 순간이동 하는 경우에는 시간이 0초가 걸린다.
한마디로 이 부분을 가중치를 활용해 풀어나가면 되고, 가중치에 따라 탐색을 할 수 있도록 Queue대신 PriorityQueue를 활용했다.
PriorityQueue에는 Node라는 객체가 들어가고, Node 객체에는 위치인 index와, 걸린 시간인 count가 들어간다.
또한 Node는 CompareTo를 구현해서 비교 기준이 count가 되도록 만들었다.
그리고 bfs탐색 시 PriorityQueue에서 count가 낮은 Node부터 탐색을 진행하게 된다.

자세한 구현 방법은 아래 코드를 참고하면 된다.
*/
import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon13549 {
    static int N, K, start, end;
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 시작 index
        K = Integer.parseInt(st.nextToken());   // 목표 index
        start = 0;  // 인덱스의 시작 값
        end = 100000;   // 인덱스의 마지막 값
        visit = new boolean[end+1]; // 방문확인용 배열 생성
        arr = new int[end+1];   // 걸린 시간을 저장하기위한 arr배열 생성

        bfs();  // bfs 메서드
    }

    private static void bfs() {
        PriorityQueue<Node> PQ = new PriorityQueue<>();  // bfs에 사용할 PriorityQueue
        PQ.offer(new Node(N, 0));   // PQ에 시작 지점 저장
        visit[N] = true;    // 해당 지점 방문 완료처리
        while(PQ.size()>0){ // PQ의 요소가 비어있을때까지 반복
            Node cur = PQ.poll();   // poll한 node가 현재 node
            visit[cur.index] = true;    // 해당 노드의 index 방문 완료처리
            if(cur.index== K) { // 만약 index가 K면
                System.out.println(cur.count);  // 지금의 count 출력 후
                return; // 종료
            }
            else {
                if (cur.index - 1 >= start && !visit[cur.index - 1]) {  // 왼쪽으로 한칸 이동할 경우
                    PQ.offer(new Node(cur.index - 1, cur.count+1)); // index -1, count +1
                }
                if (cur.index + 1 <= end && !visit[cur.index + 1]) {    // 오른쪽으로 한칸 이동할 경우
                    PQ.offer(new Node(cur.index+1, cur.count+1));   // index +1, count +1
                }
                if (cur.index * 2 <= end && !visit[cur.index * 2]) {    // 순간이동할 경우
                    PQ.offer(new Node(cur.index * 2, cur.count));   // index*2, count는 그대로
                }
            }
        }
    }
    static class Node implements Comparable<Node>{  // index와 count를 저장할 Node로 Comparable 구현
        int index;  // 위치
        int count;  // 걸린 시간

        public Node(int index, int count) {
            this.index = index;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {  // 비교기준을 count가 되도록 설정
            return count - o.count;
        }
    }
}