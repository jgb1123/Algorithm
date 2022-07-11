// https://www.acmicpc.net/problem/14500
/*
일단, 굉장히 무식하게 풀었다.
문제를 보고 브루트포스로 접근하면 제한 시간 내에 동작 가능하도록 충분히 풀 수 있겠다고 생각을 했다.
그래서 (0,0)을 기준으로, 테트로미노들의 좌표들을(간단한 location객체 이용) 모두 2차원 배열에 저장했다.
테트로미노들의 모든 방향과 대칭까지 고려해서 모두 19개가 되었고,
너무 무식하게 푼 것 같아서 '이렇게 풀어도 되나..' 싶으면서도 지금 내수준에선 이렇게밖에 못풀겠다 싶어서 그냥 그대로 진행했다.
이렇게 저장한 19개의 케이스들을 지도의 모든 좌표들을 순회하며, 해당 좌표에 테트로미노를 놓는 모든 케이스에 따라 합산 값을 구했다.
그 합산 값 중 가장 큰 수를 구했고, 결과적으로 통과할 수 있었다.

풀고 나서 다른 사람들의 풀이를 보니 내가 접근한 방식과 접근방식은 비슷하지만 더 효율적으로 코드를 짠 사람도 있었고,
DFS와 혼합해서 푼 사람도 있었다. (ㅜ모양 테트로미노를 제외하곤 DFS로 구하고, ㅜ모양은 예외케이스로 따로 구함)

무식하게 풀었지만, 풀었다는거에 의의를 두고 넘어가야겠다.
실력이 더 항샹되면 나도 더 다양한 방법으로 풀 수 있을것이다.
*/

import java.io.*;
import java.util.*;

public class baekjoon14500 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        HashMap<Integer, location> map = new HashMap<>();
        location[][] testCase = makeTestCase();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < testCase.length; k++) {
                    int sum = 0;
                    boolean outOfRange = false;
                    for (int l = 0; l < 4; l++) {
                        int y = i + testCase[k][l].y;
                        int x = j + testCase[k][l].x;
                        if(y>=0 && x>=0 && y<N && x<M){
                            sum += arr[y][x];
                        }else{
                            outOfRange = true;
                            break;
                        }
                    }
                    if(!outOfRange) result.add(sum);
                }
            }
        }
        System.out.println(Collections.max(result));
    }

    public static location[][] makeTestCase() {
        return new location[][]{
                // ㅡ 2방향
                {new location(0, 0), new location(0, 1), new location(0, 2), new location(0, 3)},
                {new location(0, 0), new location(1, 0), new location(2, 0), new location(3, 0)},
                // ㅁ 1방향
                {new location(0, 0), new location(0, 1), new location(1, 0), new location(1, 1)},
                // ㄴ 대칭 4방향
                {new location(0, 0), new location(1, 0), new location(2, 0), new location(2, 1)},
                {new location(0, 0), new location(0, 1), new location(0, 2), new location(1, 0)},
                {new location(0, 0), new location(0, 1), new location(1, 1), new location(2, 1)},
                {new location(0, 2), new location(1, 0), new location(1, 1), new location(1, 2)},
                // ㄴ 4방향
                {new location(0, 1), new location(1, 1), new location(2, 0), new location(2, 1)},
                {new location(0, 0), new location(0, 1), new location(0, 2), new location(1, 2)},
                {new location(0, 0), new location(0, 1), new location(1, 0), new location(2, 0)},
                {new location(0, 0), new location(1, 0), new location(1, 1), new location(1, 2)},
                // Z 대칭 2방향
                {new location(0, 0), new location(1, 0), new location(1, 1), new location(2, 1)},
                {new location(0, 1), new location(0, 2), new location(1, 0), new location(1, 1)},
                // Z 2방향
                {new location(0, 1), new location(1, 0), new location(1, 1), new location(2, 0)},
                {new location(0, 0), new location(0, 1), new location(1, 1), new location(1, 2)},
                // ㅜ 4방향
                {new location(0, 0), new location(0, 1), new location(0, 2), new location(1, 1)},
                {new location(0, 1), new location(1, 0), new location(1, 1), new location(2, 1)},
                {new location(0, 1), new location(1, 0), new location(1, 1), new location(1, 2)},
                {new location(0, 0), new location(1, 0), new location(1, 1), new location(2, 0)}
        };
    }

    public static class location{
        int x;
        int y;

        public location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}