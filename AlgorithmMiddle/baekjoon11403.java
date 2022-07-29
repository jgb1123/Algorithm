// https://www.acmicpc.net/problem/11403
/*
그냥 단순한 그래프 탐색문제인줄 알고 풀었다.
모든 노드에서 탐색을 해서 해당 노드로 갈수 있는지를 확인하는 방식으로 풀었고, 간단하게 성공했다.
하지만 다 풀고나니 다른사람들 풀이에 비해 성능이 굉장히 안좋다는 걸 확인했다.
그래서 확인을 해보니, 플로이드 워셜이라는 알고리즘을 적용해서 풀어야 했던 것이다.

관련해서 공부한 내용을 간단하게만 정리해보자면
다익스트라라는 알고리즘은 하나의 정점에서 모든 정점까지의 최단경로를 구하는 알고리즘이고,
플로이드 워셜 알고리즘이란 모든 최단경로를 구하는 알고리즘이다. (다익스트라와 달리 음의 간선도 사용 가능)
플로이드 워셜 알고리즘의 핵심 아이디어는 거쳐가는 정점을 기준으로 비교하는 것이다.
알고리즘의 구현은 각 각 경로(i->j)에서 새로운 중간노드로 사용할 수 있는 노드(k)를 선택하고,
더 짧은 길이를 선택하여 줄이는 과정을 반복하면 된다.

해당 문제에서는 가중치가 없는 플로이드 워셜 문제였기 때문에,
i에서 j로 이동시 k를 거쳐서 가는 경우가 있으면 1로 초기화 해주며 진행하면 된다.
해당 내용을 적용해서 다시 풀어봤는데 성능개선이 많이 되었다.
자세한 구현 방법은 아래 코드를 확인해 더 쉽게 이해할 수 있을 것이다.

아마 다음 더 높은 난이도로 가게 되면 가중치가 있는 플로이드 워셜 문제를 접할 수 있을 것 같다.
그래도 한번 배웠으니, 다음에 관련 문제가 나오면 '플로이드 워셜 문제같은데?'라는 생각정도만이라도 할 수 있었으면 좋겠다.
알고리즘의 종류가 정말 다양하다는걸 다시한번 느끼게 된 문제였다.
*/

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = getArr(br, N);
        floyd(N, arr);
        StringBuilder sb = getResult(N, arr);
        System.out.println(sb);
    }

    static int[][] getArr(BufferedReader br, int N) throws IOException {
        int[][] arr = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return arr;
    }

    static void floyd(int N, int[][] arr) {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(arr[i][k]==1 && arr[k][j]==1){
                        arr[i][j] = 1;
                    }
                }
            }
        }
    }

    static StringBuilder getResult(int N, int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb;
    }
}
/*
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[] visit;
    static int dfsResult;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        getArray(br);
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visit = new boolean[N];
                dfsResult = 0;
                dfs(0, i, j);
                result[i][j] = dfsResult;
            }
        }
        StringBuilder sb = getFinalResult(result);
        System.out.println(sb);
    }

    static void getArray(BufferedReader br) throws IOException {
        StringTokenizer st;
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static StringBuilder getFinalResult(int[][] result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb;
    }

    static void dfs(int depth, int cur, int end){
        if(depth!=0 && cur==end){
            dfsResult = 1;
        } else {
            for (int i = 0; i < N; i++) {
                if (arr[cur][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    dfs(depth+1, i, end);
                }
            }
        }
    }
}
*/
