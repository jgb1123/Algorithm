// https://www.acmicpc.net/problem/1043
/*
그래프 탐색을 이용하면 되는 문제이다.

나의 풀이 방법은 다음과 같다.
사실을 알고있는 사람들을 list로 만들고, (known)
각 파티에 참석하는 인원들도 list로 만든다. (partyList)
그리고 각 파티에 참석하는 인원들을 이용하여 인접행렬을 만든다음에,
반복문을 통해 사실을 알고있는 사람들을 시작으로 탐색을 하며 visit배열을 사용해 방문완료처리를 한다. (dfs 사용함)
결국 visit배열에 true가 된 사람들은 사실을 알게된 사람들이고 이 정보를 통해 partyList들을 순회하며 거짓말할 수 있는 파티를 카운팅하면 된다.

코드가 길어서 복잡할 수 있지만, 생각보다 별 문제없이 간단하게 풀었다.
자세한 구현 방법은 아래 코드를 참고하면 된다.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon1043 {
    static int N, M, knownNum;
    static ArrayList<Integer>[] partyList;
    static int[][] arr;
    static ArrayList<Integer> known;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 사람 수
        M = Integer.parseInt(st.nextToken());   // 파티 수
        getKnownList(br);   // 알고있는 사람 리스트 생성 메서드
        getPartyList(br);   // 파티 리스트 생성 메서드
        getAdj();   // 인접행렬 생성 메서드
        visit = new boolean[N+1];   // 방문 확인 배열 (true면 사실을 알게 됨)
        if(knownNum>0) {
            for (int i = 0; i < knownNum; i++) {    // 반복문을 통해 사실을 알고있는 사람들로 탐색 시작
                visit[known.get(i)] = true;
                dfs(known.get(i));
            }
        }

        int count = 0;  // 거짓말 할 수 있는 파티 수
        for (int i = 0; i < M; i++) {
            boolean contain = false;    // 해당 파티에 사실을 알고있는 사람이 있는지 확인 용 변수
            for (int j = 0; j < partyList[i].size(); j++) {
                if (visit[partyList[i].get(j)]) {   // 파티에 해당 인원이 사실을 알고있으면
                    contain = true; // contain true처리
                    break;
                }
            }
            if(!contain) count++;   // 파티에 사실을 알고있는사람이 없었으면 count+1
        }
        System.out.println(count);  // 최종 count 출력

    }

    static void dfs(int n){ // dfs 메서드

        for (int i = 1; i < arr.length; i++) {
            if(arr[n][i]==1 && !visit[i]){
                visit[i] = true;
                dfs(i);
            }
        }
    }

    static void getKnownList(BufferedReader br) throws IOException {    // 사실을 알고있는 사람을 입력받아 리스트로 만드는 메서드
        StringTokenizer st = new StringTokenizer(br.readLine());
        knownNum = Integer.parseInt(st.nextToken());
        if (knownNum == 0) return;

        known = new ArrayList<>();
        for (int i = 0; i < knownNum; i++) {
            known.add(Integer.parseInt(st.nextToken()));
        }
    }

    static void getPartyList(BufferedReader br) throws IOException {    // 파티의 참여인원을 입력받아 파티 리스트를 만드는 메서드
        partyList = new ArrayList[M];

        for (int i = 0; i < M; i++) {
            partyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                partyList[i].add(Integer.parseInt(st.nextToken()));
            }
        }
    }

    static void getAdj() {  // 각 파티의 정보를 통해 인접행렬을 만드는 메서드
        arr = new int[N+1][N+1];    // 인접행렬 생성
        for (int i = 0; i < M; i++) {
            int num = partyList[i].size();
            if(num >=2){    // 파티 인원이 2명 이상이면
                for (int j = 0; j < num - 1; j++) { // 2중 for문을 통해 해당 파티의 모든 인원끼리의 인접행렬을 만든다.
                    for (int k = j+1; k < num; k++) {
                        arr[partyList[i].get(j)][partyList[i].get(k)] = 1;  // 정방향과 역방향 모두 1처리
                        arr[partyList[i].get(k)][partyList[i].get(j)] = 1;
                    }
                }
            }
        }
    }
}