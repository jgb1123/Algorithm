// https://www.acmicpc.net/problem/15686
/*
백트래킹과 브루트포스를 사용해야 하는 구현 문제이다.
N*N 지도에 치킨집과 집이 있다.
M개의 치킨집만 남겼을때, 각 집에서 치킨집까지의 가까운 거리들을 합산 한 도시치킨거리라는 것을 구하면 된다 된다.
M개의 치킨집을 남기는 케이스들을 백트래킹을 통해 구현 했고,
해당 케이스들에서 도시키친거리가 가장 작은 케이스에서의 도시키친거리를 구하면 된다.

arr 1 2 0
    0 2 1
    1 2 1
지도가 위와 같다면 위에서 부터 0 1 2 3 4 5 6 7 8 라고 번호를 정하고,
치킨집이 있는 번호를 chicken 배열에 넣고, ([1, 4, 7]이 된다)
집이 있는 번호를 house배열에 넣었다. ([0, 5, 6, 8]이 된다)
(만약 4번에 치킨집이 있으면 그 치킨집의 좌표 (y,x)는 (4/3, 4%3)과 같이 구할 수 있다. (여기서 3은 지도의 크기)

치킨집을 없애는 케이스들을 chicken배열과 백트래킹을 통해 구하고, (없애면 chicken배열에 -1로 표시함)
해당 케이스들 마다 chiceken과 house의 거리를 구한다. (거리는 |집 y - 치킨 y| + |집 x - 치킨 x|로 구하면 된다.)
각 집에서 치킨집들 까지의 거리중 가장 작은 값을 도시치킨거리 변수에 더하면서 도시치킨거리를 구했고, result라는 ArrayList에 넣었다.
최종적으로 result 중 가장 작은 값을 구하면 된다.

푸는 시간보다 설명을 적으며 정리하는게 더 오래걸렸다.
누가 내 풀이를 보고 참고할 일은 없을 것 같으니, 이정도로 넘어가야겠다.
*/

import java.io.*;
import java.util.*;

public class baekjoon15686 {
    static int N, M, shutdownNum;
    static int[][] arr;
    static ArrayList<Integer> list1, list2;
    static Integer[] chicken, house;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 지도 크기
        M = Integer.parseInt(st.nextToken());   // 남길 치킨집 수

        arr = new int[N][N];    // 지도 생성
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }


        makeHouseAndChickenArray(); // 위에서 설명한 치킨집의 번호 배열(chicken)과 집의 번호 배열(house)을 생성하는 메서드


        shutdownNum = list1.size() - M; // 없애야 하는 치킨집의 수
        result = new ArrayList<>(); // 케이스마다의 도시치킨거리를 저장할 result
        recur(0, 0);   // 반복문의 시작 index는 0, 백트래킹의 depth는 0으로 백트래킹 시작

        System.out.println(Collections.min(result));    // result중 가장 작은 값 출력
    }

    public static void makeHouseAndChickenArray() { // chicken과 house배열을 만드는 메서드
        list1 = new ArrayList<>();  // chicken배열을 위한 list1
        list2 = new ArrayList<>();  // house배열을 위한 list2
        int num = 0;    // 번호 0으로 초기화

        for (int i = 0; i < N; i++) {   // 반복문을통해 지도를 순회하며
            for (int j = 0; j < N; j++) {
                if(arr[i][j]==2){   // 만약 2이면
                    list1.add(num); // list1에 해당 번호 add
                }
                if(arr[i][j]==1){   // 만약 1이면
                    list2.add(num); // list2에 해당 번호 add
                }
                num++;  // 반복할때마다 번호 + 1
            }
        }
        chicken = new Integer[list1.size()];    // 치킨집의 번호를 저장한 list1을 chicken배열로 변환
        list1.toArray(chicken);

        house = new Integer[list2.size()];      // 집의 번호를 저장한 list2를 house배열로 변환
        list2.toArray(house);                   // 치킨집은 없앤 치킨집을 -1로 바꾸면서 백트래킹을 해야해서 배열로 변환했는데,
                                                // 사실 집은 배열로 굳이 안바꿔도 되지만 코드의 가독성을 위해 변경했다.
    }

   public static void recur(int index, int depth){ // 백트래킹 반복문 시작 값인 index, 백트래킹 깊이인 depth
        if(depth < shutdownNum) {   // depth가 없애야하는 치킨집 수보다 작으면
            for (int i = index; i<chicken.length; i++) {    // 반복문을 통해
                int pre = chicken[i];   // 다시 되돌릴 수 있도록 이전의 값을 pre로 저장해두고
                chicken[i] = -1;    // 해당 치킨집 -1로 변경 (치킨집을 없앰)
                recur(i+1, depth + 1);  // index+1, depth+1로 재귀
                chicken[i] = pre;   // 위 재귀메서드 종료 후 다시 이전값으로 원복
            }
        } else {
            int cityChickenDistance = 0;    //도시치킨거리 0으로 초기화

            for (Integer i : house) {   // 브루트 포스를 통해 해당 케이스에서의 도시치킨거리를 구함
                int min = Integer.MAX_VALUE;
                for (Integer j : chicken) {
                    if (j != -1) {  // 없앤 치킨집이 아니면
                        int chickenDistance = Math.abs(i/N - j/N) + Math.abs(i%N - j%N);    // 왼쪽 식은 |집 y - 치킨집 y| + |집 x - 치킨집 x|와 같다.
                        min = Math.min(min, chickenDistance);   // 반복문을 돌며 가장 가까운 거리를 구함
                    }
                }
                cityChickenDistance += min; // 도시치킨거리에 가장 가까운 치킨집의 거리를 저장함
            }
            result.add(cityChickenDistance);    // 도시치킨거리를 result에 add
        }
    }
}