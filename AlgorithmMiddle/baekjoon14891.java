// https://www.acmicpc.net/problem/14891
/*
문제를 정확히 이해하고 천천히 구현해 나가면 생각보다 쉽게 풀리긴 한다.
하지만 코드가 길기 때문에 조금씩 실수를 해서 그 잘못된 부분을 찾느라 시간이 좀 걸렸다.

일단 톱니바퀴를 4개의 LinkedList로 구현했다. 12시를 index 0으로 잡고, 시계방향으로 index가 증가한다.
톱니바퀴의 오른쪽은 index가 2이고, 톱니바퀴의 왼쪽은 index가 6이다.
ArrayList와 LinkedList의 차이는 ArrayList는 조회가 빠르고, LinkedList는 index가 변경되는 데이터 변경에 빠르다.
뭘 써야할지 고민을 해봤는데, 이 문제에서는 조회도 필요하고 데이터 변경도 필요하다.
또 별로 연산 수가 많지도 않아, 크게 고려하지 않아도 될 것 같아서 그냥 LinkedList로 구현해봤다.
구현 방법은 간단하다. 처음 돌리는 톱니바퀴가 돌아가게 되면 왼쪽, 오른쪽에 있는 톱니바퀴들도 조건이 맞으면 그 반대방향으로 돌게 된다.
조건은 왼쪽에 있는 톱니바퀴의 오른쪽 톱니의 극과, 오른쪽 톱니바퀴에 있는 왼쪽 톱니의 극이 다르면 돌아가게 된다.
톱니바퀴가 오른쪽으로 돌면 LinkedList를 한칸씩 오른쪽으로 밀면 되고, 왼쪽으로 돌면 왼쪽으로 한칸씩 밀면 된다. (메서드로 만듬)
그리고 예를들면, 1번째 톱니바퀴가 돌면서 2번째 톱니바퀴도 조건이 맞으면 반대방향으로 돌아가고,
또 2번째 톱니바퀴와 3번째 톱니바퀴도 조건이 맞으면 3번째 톱니바퀴까지 돌아가는 것이다.
따라서 어느 톱니바퀴까지 같이 돌아가야 하는지에 대한 부분은 재귀로 구현을 했다.
재귀로 돌 때 신경쓴 부분은, 재귀를 모두 돌고 나서 나올때 회전에 따른 톱니바퀴들의 데이터를 변경을 해줬다. (변경하면서 재귀를 돌면, 조건이 꼬이게 됨)

리팩토링이 좀 더 필요한 코드인 것 같긴 하지만, 우선 풀었다는 것에 의의를 두고 넘어가야겠다.
다른 공부도 해야한다..
자세한 설명은 아래 코드를 보면 된다.
*/

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baekjoon14891 {

    static LinkedList<Integer>[] list;
    static boolean[] visit;
    static int rightIndex = 2;
    static int leftIndex = 6;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new LinkedList[4];   // 2차원 배열을 통해 LinkedList로 톱니바퀴 생성
        for (int i = 0; i < list.length; i++) {
            list[i] = new LinkedList<>();   // 4개의 LinkedList 생성
        }
        for (int i = 0; i < list.length; i++) {
            insertData(br, list[i]);    // 각 LinkedList에 데이터 입력 (아래 insertData 메서드 참고)
        }
        int K = Integer.parseInt(br.readLine());    // 동작 반복 횟수

        for (int i = 0; i < K; i++) {   // 동작 반복 횟수만큼 반복
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken())-1; // 돌릴 톱니바퀴 번호로, index를 0부터 만들어 사용했기 때문에 입력받은 데이터에 -1을 해준다.
            int dir = Integer.parseInt(st.nextToken()); // 방향으로, 1이면 오른쪽, -1이면 왼쪽으로 돈다
            visit = new boolean[4]; // 재귀에 사용할 방문 확인용 배열
            visit[N]= true; // 처음 톱니바퀴 방문 완료 처리
            recur(N, dir);  // 재귀 시작
            if(dir==1) turnRight(N);    // 재귀 다 돌고나서 만약 dir이 1이였으면 해당 톱니바퀴 오른쪽으로 회전
            else turnLeft(N);   // dir이 1이 아니였으면 해당 톱니바퀴 왼쪽으로 회전
        }
        int result = getResultPoint();  // 최종 점수 구하는 메서드
        System.out.println(result); // 최종 점수 출력


    }

    static void recur(int N, int dir){  // 톱니바퀴의 번호와, 방향을 입력으로 받아오는 재귀메서드
        if(dir==1){ // 해당 톱니바퀴가 만약 오른쪽으로 돌면
            if(N-1>=0 && !visit[N-1] && list[N-1].get(rightIndex)!=list[N].get(leftIndex)){ // 왼쪽 톱니바퀴가 있고, 아직 방문안한 톱니바퀴며, 왼쪽 톱니바퀴의 오른쪽 극과 해당 톱니바퀴 왼쪽 극이 다르면
                visit[N-1] = true;  // 방문처리하고
                if(N-2>=0 && !visit[N-2]) { // 왼쪽 톱니바퀴의 왼쪽에 톱니바퀴가 또 있으면
                    recur(N - 1, -1); // 왼쪽 톱니바퀴의 번호와, 왼쪽 방향으로 재귀
                }
                turnLeft(N-1);  // 재귀 다돌고나면 왼쪽 톱니바퀴 왼쪽으로 돌림
            }
            if(N+1<4 && !visit[N+1] && list[N+1].get(leftIndex)!=list[N].get(rightIndex)){  // 오른쪽 톱니바퀴가 있고, 아직 방문 안한 톱니바퀴며, 오른쪽 톱니바퀴의 왼쪽 극과 해당 톱니바퀴의 으론쪽 극이 다르면
                visit[N+1] = true;  // 방문처리하고
                if(N+2<4&&!visit[N+2]) {    // 오른쪽 톱니바퀴의 오른쪽에 톱니바퀴가 또 있으면
                    recur(N + 1, -1);   // 오른쪽 톱니바퀴의 번호와, 왼쪽 방향으로 재귀
                }
                turnLeft(N+1);  // 재귀 다 돌고나면 오른쪽 톱니바퀴 왼쪽으로 돌림
            }
        }else{  // 위의 톱니바퀴가 오른쪽으로 돌때의 코드와 방향만 다르고 구현 방식은 같다.
            if(N-1>=0 && !visit[N-1] && list[N-1].get(rightIndex)!=list[N].get(leftIndex)){
                visit[N-1] = true;
                if(N-2>=0&&!visit[N-2]) {
                    recur(N-1, 1);
                }
                turnRight(N-1);
            }
            if(N+1<4 && !visit[N+1] && list[N+1].get(leftIndex)!=list[N].get(rightIndex)){
                visit[N+1] = true;
                if(N+2<4&&!visit[N+2]) {
                    recur(N + 1, 1);
                }
                turnRight(N+1);
            }
        }
    }

    static void insertData(BufferedReader br, LinkedList<Integer> list) throws IOException {    // 각 LinkedList에 데이터를 저장하는 메서드
        String str = br.readLine(); // 입력을 받아오고
        for (int i = 0; i < str.length(); i++) {   // 입력으로 받은 8글자를
            list.add(str.charAt(i)-'0');    // list에 저장함
        }
    }
    static void turnLeft(int N){    // 톱니바퀴 왼쪽으로 돌리는 메서드
        list[N].add(list[N].remove(0)); // 맨 왼쪽 요소를 빼서 맨 뒤에 붙임
    }
    static void turnRight(int N){   // 톱니바퀴를 오른쪽으로 돌리는 메서드
        list[N].add(0, list[N].remove(7));  // 오른쪽 요소를 빼서 맨 왼쪽에 붙음
    }
    static int getResultPoint() {   // 최종 점수를 구하는 메서드
        int result = 0; // result값 0으로 초기화
        int[] point = new int[]{1, 2, 4, 8};    // 각 톱니바퀴들의 할당 점수
        for (int i = 0; i < list.length; i++) {   // 모든 톱니 바퀴들을 돌며
            if(list[i].get(0)==1){  // 해당 톱니바퀴의 12시방향 톱니인 0번째 톱니가 1이면
                result += point[i]; // 해당 톱니바퀴에 할당된 점수 result에 더함
            }
        }
        return result;  // result반환
    }
}