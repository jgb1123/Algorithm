// https://www.acmicpc.net/problem/10819
/*
솔직히 처음에 절대값 괄호를 그냥 괄호로 잘못봐서, 뭐지..? 왤케 쉽지..? 했었다..
물론 문제를 제대로 보고 나서도 막 어려운 문제는 아니였다.
입력이 적기 때문에, 그냥 모든 케이스를 다 확인해보면 되겠다 라고 생각했다.
그래서 그냥 브루트포스 문제구나 라고 생각을 했고, 재귀메서드를 만들어 백트래킹 방식을 통해 문제를 풀었다.
재귀메서드를 만들 때 파라미터들을 적당히 잘 지정하니 별 문제 없이 풀 수 있었다.
*/


import java.io.*;
import java.util.StringTokenizer;

public class baekjoon10819 {
    static boolean[] visit;
    static int[] arr;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        visit = new boolean[N]; // 백트래킹에 이용할 중복 확인용 배열 생성
        max = 0; // 연산의 최대값을 저장할 변수
        arr = new int[N];   // 입력 데이터를 저장할 배열 생성
        for(int i = 0; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<arr.length; i++){  // 재귀 메서드의 첫 시작을 arr[0]부터 arr[N-1]까지 반복
            visit[i]=true;  // 해당 수를 사용처리를 하고
            recur(0, arr[i], 0);    // 연산횟수는 0, 현재 숫자는 arr[i], 현재 합은 0으로 재귀 메서드 시작
            visit[i]=false; // 재귀함수 종료 되면 다시 미사용 처리
        }
        System.out.println(max);    // 최종 출력 (식의 최댓값)

    }
    static void recur(int count, int pre, int preSum){  // 이전까지의 연산 횟수, 이 전의 값, 이 전의 총합을 파라미터로 받아옴
        if(count<arr.length-1) {    // 연산횟수가 N-2이하(최종 연산 횟수는 N-2가 되야 함)이면 아직 할 연산이 남아있으므로, 아래 연산을 위한 로직 실행
            for (int i = 0; i < arr.length; i++) {  // arr에 저장된 수들을 모두 반복하며
                if (!visit[i]) {    // 사용되지 않은 수라면
                    visit[i] = true;    // 사용 처리를 하고
                    int sum = preSum + Math.abs(pre - arr[i]);  // 그 수와 이전 값과의 차를 절대값으로 구한 후 최종 합에 더해줌
                    recur(count+1, arr[i], sum);    // 연산횟수+1, 현재 값, 현재 합의 값으로 재귀 메서드 다시 시작
                    visit[i] = false;   // 재귀메서드 끝나면 다시 미사용 처리
                }
            }
        }
        else{   // 연산을 다 한 상태라면,
            if(max<preSum) max = preSum; // 현재 max값과 파라미터로 받은 합을 비교하고, max보다 크면 max값 갱신
        }
    }
}
