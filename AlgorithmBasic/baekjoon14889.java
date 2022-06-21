// https://www.acmicpc.net/problem/14889
/*
시간복잡도를 크게 고려하지 않고 풀어도 되는 문제였다.
그런데 풀다보니 재귀메서드 안에 또 다른 재귀메서드가 들어가도록 설계가 되었다.
문제를 풀면서 '이렇게 풀어도 되나.?' 싶었는데 입력값이 적기때문에 괜찮을 것 같아서 그냥 생각한대로 풀었다.
재귀메서드를 2개나 사용해야 되서 코드가 길어졌고 코드가 좀 복잡해지긴 했지만, 결과적으로는 성공했다.
*/

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon14889 {
    static boolean[] visit;
    static int[][] arr;
    static int[] team1;
    static int[] team2;
    static int min;
    static int sum1;
    static int sum2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];    // 입력된 능력치 표를 저장할 2차원 배열
        visit = new boolean[N]; // 팀을 나누기 위해 사용할 방문 확인을 위한 배열
        team1 = new int[N/2];   // 1팀의 인원이 들어갈 배열
        team2 = new int[N/2];   // 2팀의 인원이 들어갈 배열
        min = 10000;    // 가장 Worst Cace일땐 10000이 된다. (사실 단순하게 int값의 맥스값으로 설정해도 됨)
        for (int i = 0; i < N; i++) {   // 능력치 표를 입력받아 2차원 배열에 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0);    // 재귀 메서드 시작 (recur재귀메서드 안에 sum재귀메서드가 또 있음)
        System.out.println(min);    // 능력치 차이의 최소값 출력

    }
    static void recur(int index, int start){ // 팀을 나눌 재귀함수
        if(index<arr.length/2) {    // 현재 인덱스가 팀의 인원보다 작으면
            for (int i = start; i < arr.length; i++) {  // 반복문을 돌며
                team1[index] = i;   // 1팀에 현재 인덱스에 i 추가
                visit[i] = true;    // i방문 완료 처리
                recur(index + 1, i + 1);    // 현재 인덱스+1, 반복문의 시작 값을 현재 i+1로 재귀 다시 시작
                visit[i] = false;   // 재귀 끝나면 방문 완료처리 원복
            }
        }else{
            int team2Index = 0;  // 반복문 내에서 2팀 배열의 인덱스 값으로 사용될 변수
            sum1 = 0;   // 1팀의 총 능력치 0으로 초기화
            sum2 = 0;   // 2팀의 총 능력치 0으로 초기화
            for(int i = 0; i<arr.length; i++){  //반복문을 돌면서
                if(!visit[i]){  // 방문하지 않은(1팀에 들어가지 못한) 인원이면
                    team2[team2Index] = i;   // 팀 2에 저장
                    team2Index++;    // 팀2의 인덱스 ++
                }
            }
            sum(0); // sum 재귀메서드 시작
        }
    }
    static void sum(int now){   // 각 팀의 총 능력치를 구하고, 각 팀의 총 능력치의 차이 중 최소값을 구할 메서드
        if(now<arr.length/2) {  // 현재 인덱스가 팀의 인원보다 작으면
            for (int i = 0; i < team1.length; i++) {    // i가 팀의 인원보다 적을때까지 반복
                if(i != now) {  // i가 현재 인덱스와 다르면
                    sum1 += arr[team1[now]][team1[i]];  // 1팀의 총 능력치에 능력치를 더함
                    sum2 += arr[team2[now]][team2[i]];  // 2팀의 총 능력치에 능력치를 더함
                }
            }
            sum(now+1); // 현재 인덱스+1로 재귀 시작
        }else{  // 현재 인덱스가 팀의 인원보다 커지면
            int dif = Math.abs(sum1-sum2);  // 각 팀의 능력치의 차를 절대값으로 구함
            if(min>dif) min = dif;  // 만약 총 능력치의 차이가 min보다 작으면 min은 현재 능력치의 차이가 됨
        }
    }
}