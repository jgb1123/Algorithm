package lv2;

import java.util.*;

class Programmers42626 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // pq에 scoville 요소들 저장
        for (int i : scoville) {
            pq.offer(i);
        }
        int count = 0;  // 섞은 수
        while(pq.peek() < K) {  // pq에서 가장 작은 값이 K보다 작을경우에만 반복
            int a = pq.poll();  // 제일 작은 값
            int b = pq.poll();  // 두번째로 작은 값
            if(pq.size() == 0 && a + 2 * b < K) return -1;  // 만약 현재 pq의 크기가 0이고(2개 빼온상태), a + 2 * b가 K보다 작으면 -1 리턴(불가능)
            pq.offer(a + 2 * b);    // pq에 a + 2 * b offer
            count++;    // count + 1
        }
        return count;   // count 리턴턴
   }
}
