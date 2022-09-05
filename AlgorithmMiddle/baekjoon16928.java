// https://www.acmicpc.net/problem/16928
/*
얕봤다가 큰코다친 문제이다.
문제를 처음 봤을때 'dp나 bfs로 풀면 간단하겠는데?'라고 생각을 했다.
그래서 간단하게 구현이 될 것 같은 dp로 풀려고 했으나, 지도의 크기 등 입력값이 너무 작아 약간 의심을 했다.
입력 값이 작기 때문에, dp로 풀 문제 였으면 입력 값이 굳이 이렇게 작을 이유가 없을텐데.. 라는 생각을 하며 조금 찝찝했지만,
코드의 성능은 좋을수록 좋으니 그냥 dp로 풀기로 마음먹었다.
당연히 큰 착각이였고, 입력 예시의 경우 통과를 했지만, 제출하니 계속 실패가 되었다.
반례를 곰곰히 생각해보니, 뱀 사다리를 타고 내려갔다가 가는 경우가 더 빠를 수도 있는 것이다.
이 경우는 dp의 bottom up방식으로 풀 경우 풀 수 없는 상황이었다.
그래서 빠르게 bfs로 전환을 했다.
솔직히 문제 자체가 어려운 문제는 아니였기 때문에, bfs로 바꾸니 간단하게 pass가 되었다.

나의 풀이 방식을 간단하게 설명해보자면, 우선 사다리나 뱀사다리 등의 경우는 모두 HashMap에 넣었다. (map.put(from, to))
만약 가려고 하는 좌표에 사다리나 뱀사다리가 있으면(map.containsKey(next)) 사다리의 목표 지점(map.get(next))으로 가면 된다.
이러한 방식으로 bfs를 구현하면 어렵지 않게 풀 수 있는 문제이다.

자세한 풀이는 아래 코드를 참고하면 된다.
다음부턴 문제 풀기 전 좀더 고려해야할 사항들을 꼼꼼히 확인해보고, 어느정도 생각을 하고 문제풀이를 시작해야겠다.
*/

import java.io.*;
import java.util.*;

public class baekjoon16928 {
    static HashMap<Integer, Integer> map;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();  // 사다리들을 저장할 HashMap (from, to)
        for (int i = 0; i < N+M; i++) { // 사다리+뱀사다리 수만큼 반복
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map.put(from, to);  // HashMap에 (from, to)로 put
        }

        visit = new boolean[101];   // 방문 확인용 배열

        bfs();  // bfs 구현 메서드

    }
    static void bfs(){
        Queue<Location> Q = new LinkedList<>(); // bfs에 사용할 Queue
        Q.offer(new Location(1, 0));    // 시작 지점 Q에 저장
        visit[1] = true;    // 시작 지점 방문 완료 처리

        while(Q.size()>0){  // Q가 없을때까지 반복
            Location now = Q.poll();    // Q에서 poll한 객체는 now라 함
            if(now.location==100){  //  현재 위치가 100이면
                System.out.println(now.count);  // 현재 주사위 횟수를 출력하고
                break;  // bfs종료
            }

            for (int i = 1; i < 7; i++) {   // 주사위는 1~6까지
                int next = now.location+i;  // 다음 위치는 지금 위치 + 주사위 수
                if (next <= 100 && !visit[next]) {  // 다음 위치가 100이하이고, 방문하지 않은 위치면
                    visit[next] = true; // 방문 완료 처리
                    if (map.containsKey(next)) {    // 만약 사다리나 뱀사다리가 있고,
                        if(!visit[map.get(next)]) { // 사다리를 타고 가는 목적지가 방문하지 않은 위치라면
                            Q.offer(new Location(map.get(next), now.count + 1));    // 사다리의 목적지 Queue에 저장 (count는 현재 count+1로)
                            visit[map.get(next)] = true;    // 사다리 목적지 방문 완료 처리
                        }
                    } else {    // 사다리나 뱀사다리가 없으면
                        Q.offer(new Location(next, now.count + 1)); // 다음 위치를 Queue에 저장 (count는 현재 count+1)
                    }
                }
            }
        }
    }

    static class Location { // 현재 목적지에 대한 정보를 갖고있는 Class
        int location;   // 현재 위치
        int count;  // 현재 위치에 오기위해 굴린 주사위 수

        public Location(int location, int count) {
            this.location = location;
            this.count = count;
        }
    }
}