// https://www.acmicpc.net/problem/15649
/*
간단한 백트래킹 문제이다.
처음엔 요소가 들어있는 ArrayList를 변경해 가며 재귀를 도는 방식으로 구성을 해봤고 (맨아래 주석처리한 코드),
ArrayList를 계속 수정해가며 재귀를 돌게 되어 실행시간이 길어졌다.
그래서 그냥 방문확인을 위한 boolean배열을 이용해서 다시 풀기로 했고,
그 결과 실행 시간이 많이 짧아졌다.
*/

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon15649 {
    static StringBuilder sb;
    static boolean[] visit;
    static int[] arr;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 수열에 들어갈 수 있는 요소들의 개수(요소들은 1~N까지의 자연수)
        int M = Integer.parseInt(st.nextToken());   // 수열의 길이
        sb = new StringBuilder();    // Stringbuilder를 전역변수로 생성
        arr = new int[N];            // 수열에 들어갈 수 있는 요소들을 담을 배열
        result = new int[M];         // 수열을 저장할 배열
        visit = new boolean[N];      // 방문확인을 위한 boolean배열
        for (int i = 0; i < N; i++) {   // arr배열에 수열에 들어갈 수 있는 요소들을 집어넣음 (1~N까지의 자연수들)
            arr[i] = i+1;
        }
        recur(0);   // 재귀 index 0부터 시작
        System.out.println(sb); // 최종 출력

    }
    static void recur(int index){
        if(index<result.length) {   // 만약 현재 index가 수열의 길이보다 작으면
            for (int i = 0; i < arr.length; i++) {  //
                if(!visit[i]) { // 사용되지 않은 수이면
                    result[index] = arr[i]; // 수열에 그 수를 담고
                    visit[i] = true;    // 방문 완료 처리
                    recur(index + 1);   // 다음 인덱스로 재귀시작
                    visit[i] = false;   // 재귀가 다 돌고나면 방문 완료처리한 걸 미방문으로 원복
                }
            }
        } else {    // 만약 현재 index가 수열의 길이 이상이 되면 (같아지면)
            for(int i : result){    // 수열의 요소들을 StringBuilder에 추가
                sb.append(i).append(" ");
            }
            sb.append("\n");    // 추가 다했으면 줄바꿈
        }
    }
}


/*
public class baekjoon15649 {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }
        recur(list, result, M);
        System.out.println(sb);

    }
    static void recur(ArrayList<Integer> list, ArrayList<Integer> result, int M){
        if(M>0) {
            for (int i = 0; i < list.size(); i++) {
                ArrayList<Integer> nextList = new ArrayList<>(list);
                ArrayList<Integer> nextResult = new ArrayList<>(result);
                nextResult.add(nextList.remove(i));
                recur(nextList, nextResult, M - 1);
            }
        } else {
            for(int i : result){
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
    }
}
*/