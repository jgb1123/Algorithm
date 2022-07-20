// https://www.acmicpc.net/problem/3190
/*
뱀이 지도를 이동하면서, 사과를 먹으면 길이가 늘어나고, 벽이나 꼬리에 부딪히면 게임이 종료되는 게임이다.
천천히 구현해 나가면 문제 없이 구현은 가능하나, 구현한 코드가 굉장히 길었고, 리팩토링 하는 과정이 좀 오래 걸렸다.
여전히 리팩토링 할 부분은 많지만, 다른 공부도 해야하니 적당히 마무리하고 끝냈다.

우선 방향 이동을 위한 dx dy 배열을 이용했다.
arr에 지도를 만들고, 그 만들어진 지도에 사과의 위치를 저장했다.
뱀의 위치는 1로, 사과가 있는 위치는 2로 표시했다.

좌표의 정보가 담기는 Location 클래스를 만들었다. (간단하게 y좌표 x좌표만 있음)
그리고 방향 전환 정보가 담기는 TurnInfo 클래스도 만들었다.(간단하게 방향 전환되는 시간과, 방향에 대한 정보만 있음)
그 방향 정보를 갖고 있는 객체들 데이터를 입력받아 만들고, 차례대로 ArrayList에 저장했다.

일단 좌표는 뱀의 머리의 좌표와, 꼬리의 좌표 2개를 만들었다.
뱀의 머리 좌표는 카운트가 1 증가할 때 현재의 방향으로 움직이고,
만약 이동한 곳에 사과가 있다면 꼬리의 좌표는 변하지 않는다. (길이가 1 증가되었기 때문)
만약 사과가 없는 좌표로 이동했을 때에는 현재 꼬리의 위치는 0이 되고(빈칸) 꼬리의 좌표는 그 다음 좌표가 된다.
이때 꼬리의 다음 좌표를 어떤식으로 구현해서 구할까 고민을 해봤는데, Queue를 이용했다.
Queue에 머리의 이동 좌표들을 차례대로 저장해 놓고, 꼬리의 다음 좌표가 필요할때 Queue에서 poll()을 해서 얻어내면 된다.

방향 변경과 관련해서는, dx dy 배열을 이용했는데, dx dy 배열은 동 남 서 북순으로 이동하도록 만들었다.
정리하면 방향 값이 0이면 오른쪽으로 이동하고, 3이면 위쪽으로 이동한다.
방향을 오른쪽으로 전환하고 싶으면 지금의 방향값에서 1 증가시키면 된다.(dx dy의 인덱스는 0~3까지인데 4가 될 수 있으니 %4를 한 값을 구함)
방향을 왼쪽으로 전환하고 싶으면 지금의 방향 값에서 -1을 하면 된다.(dx dy의 인덱스는 0~3까지인데 -1이 될 수 있으니 -1이 되면 3으로 변경)
한가지 조심해야 할 부분은 마지막 방향 전환 후에도 시간이 지날 때마다 계속 그 방향으로 진행해야 한다.
이 부분을 어떻게 구현할까 고민을 했다가, 가장 간단하게 10000초후에 한번 더 아무방향으로나 방향 전환하는 것으로 추가해줬다.
(지도의 크기가 100*100이므로 10000초후면 무조건 게임이 끝남)

더 자세한 설명은 아래 코드를 참고하면 된다.

항상 느끼는 거지만 코드를 짜는것보다 설명하는게 더 힘든 것 같다.
구현 문제들은 난이도가 올라갈수록 확실히 코드가 길어지는 것 같다.
물론 실력이 더 늘어나면 같은 문제라도 더 빠르고 간단하게 구현할 수 있겠지만, 지금은 풀 수 있다는 것에 의의를 두자.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon3190 {
    static int[] dx = {1, 0, -1, 0};    // 방향은 동 남 서 북 순이다
    static int[] dy = {0, 1, 0, -1};    // 방향은 동 남 서 북 순이다
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        arr = new int[N][N];    // 지도 생성
        arr[0][0] = 1;  // 뱀은 맨 왼쪽 맨 위에서 시작하므로, arr[0][0]은 1로 설정

        makeApple(br, K);   // 지도에 사과를 추가하는 메서드

        int L = Integer.parseInt(br.readLine());    // 방향 전환 정보의 수

        ArrayList<TurnInfo> list = getTurnInfoList(br, L);  // 방향 전환 정보들을 모두 list에 저장하는 메서드

        Location headLocation = new Location(0, 0); // 뱀의 머리 위치는 맨 왼쪽 맨 위에서 시작
        Location tailLocation = new Location(0, 0); // 뱀위 꼬리 위치도 맨 왼쪽 맨 위에서 시작
        int curDir = 0; // 시작 방향은 오른쪽이므로 현재 방향은 0으로 초기화
        Queue<Location> Q = new LinkedList<>(); // 뱀의 머리가 이동하는 좌표들을 저장할 Queue
        int count = 0;  // 시간을 count할 변수
        int preTime = 0; // 반복문 내에서, 해당 뱡항으로 이동할 횟수를 구하기 위해 생성
                        // 예를 들면 3초, 6초 ,7초에 방향을 전환한다고 하면
                        // 지금의 방향들로 3번, 3번, 1번씩 이동하고 방향을 전환 하는데,
                        // 이 이동 수를 구하기 위해 필요한, 이전의 방향 전환 시간을 저장해놓기 위한 변수임
        
        for (int i = 0; i < list.size(); i++) { // 방향 변환 정보가 들어있는 list의 수만큼 반복
            int time = list.get(i).time;  // list에 i번째 객체의 방향 전환해야 할 시간 값을 가져옴
            char turnDir = list.get(i).turnDir; // list에 i번째 객체의 돌아야 할 방향 정보를 가져옴
            for (int j = 0; j < time-preTime; j++) {  //  지금의 방향으로, 현재 시간 - 이전의 시간 만큼 반복해서 이동
                Q.offer(new Location(headLocation.y, headLocation.x));  // 현재의 머리 좌표를 Queue에 저장
                count++;    // count + 1
                headLocation.y += dy[curDir];   // 다음의 머리 y좌표는 해당 방향으로 이동
                headLocation.x += dx[curDir];   // 다음의 머리 x좌표는 해당 방향으로 이동

                boolean validIndexResult = validIndex(headLocation.y, headLocation.x);  // 좌표가 지도 안에 있는지 확인해주는 메서드
                if(!validIndexResult){  // 이동한 좌표가 만약 지도 밖이라면 머리가 벽에 부딛힌 것이므로,
                    System.out.println(count);  // 현재 시간을 출력하고
                    return; // 종료
                } else{ // 이동한 좌표가 지도 안쪽이라면
                    if(arr[headLocation.y][headLocation.x]!=2){ // 이동한 좌표에 만약 사과가 없으면
                        arr[tailLocation.y][tailLocation.x] = 0;    // 지금 꼬리의 좌표는 빈 공간으로 변경
                        Location savedLocation = Q.poll();  // Queue에 저장되어 있던 머리의 이동 좌표들 중 가장 처음 저장된 좌표 정보를 꺼내서
                        tailLocation.y = savedLocation.y;   // 다음 꼬리의 좌표로 설정
                        tailLocation.x = savedLocation.x;
                    }
                    if(arr[headLocation.y][headLocation.x]==1){ // 만약 이동한 좌표에 뱀의 몸통이 있으면
                        System.out.println(count);  // 현재 시간을 출력하고
                        return; // 종료
                    }else{
                        arr[headLocation.y][headLocation.x]=1;  // 이동한 곳의 좌표가 벽도 아니고 뱀의 몸통도 아니면 뱀의 좌표로 설정
                    }
                }
            }
            curDir = getNextDir(curDir, turnDir);   // 방향을 변경하는 메서드로, 해당 방향으로 반복문을통해 모두 이동했으면 방향을 바꾼다.
            preTime = time;   // 이전의 방향 전환 시간은 지금의 방향 전환 시간으로 변경
        }
    }

    static void makeApple(BufferedReader br, int K) throws IOException {    // 사과의 위치를 지도에 저장하는 메서드
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int appleY = Integer.parseInt(st.nextToken())-1;
            int appleX = Integer.parseInt(st.nextToken())-1;
            arr[appleY][appleX] = 2;    // 사과가 있는 좌표는 2로 표시
        }
    }

    static ArrayList<TurnInfo> getTurnInfoList(BufferedReader br, int L) throws IOException {   // 방향 전환 정보 리스트를 만들어주는 메서드
        StringTokenizer st;
        ArrayList<TurnInfo> list = new ArrayList<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            char turnDir = st.nextToken().charAt(0);
            list.add(new TurnInfo(num, turnDir));
        }
        list.add(new TurnInfo(10000, 'C')); // 마지막에 10000초후의 방향 전환 정보도 추가함. 그래야 주어진 마지막 방향 전환 이후에도 그 방향으로 계속 이동가능해짐
        return list;
    }

    static int getNextDir(int curDir, char turnDir) {   // 방향을 전환하는 메서드
        if(turnDir =='L') { // 왼쪽으로 돌아야 되면
            if(curDir == 0) curDir = 3; // 현재방향의 값이 0이면 3으로 변경
            else curDir = curDir -1;    // 현재방향의 값이 0이 아니면 -1을 함
        }
        else curDir = (curDir +1)%4;    // 오른쪽으로 돌아야 되면 현재방향의 값에 1을 더하고 4로 나눈 나머지를 구함
        return curDir;
    }

    static boolean validIndex(int y, int x){    // 지도 안에 있는 좌표인지 확인해주는 메서드
        if(y<0 || y>arr.length-1 || x<0 || x> arr.length-1){
            return false;
        }
        return true;
    }
    static class Location { // 좌표 정보를 담을 Location class
        int y;
        int x;

        public Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static class TurnInfo { // 방향 전환 정보를 담을 TurnInfo class
        int time;    // 방향이 바뀌는 시간 횟수
        char turnDir;   // 바뀌는 방향

        public TurnInfo(int time, char turnDir) {
            this.time = time;
            this.turnDir = turnDir;
        }
    }
}