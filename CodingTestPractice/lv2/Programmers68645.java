package lv2;

class Programmers68645 {
    public int[] solution(int n) {
        int max = n * (n + 1) / 2;  // 최고 숫자
        int[][] arr = new int[n][n];
        int y = 0;
        int x = 0;
        int num = 1;    // num은 1부터 시작
        arr[y][x] = num;    // 시작 지점은 1
        while(num < max) {  // num이 max값보다 작을때까지만 반복
            while(y + 1 < n && arr[y + 1][x] == 0) {    // 아래쪽으로 이동 시, 이동한 곳이 0이면
                num++;  // num + 1
                y++;    // 아래로 이동
                arr[y][x] = num;    // 이동한 좌표의 숫자는 num
            }
            while(x + 1 < n && arr[y][x + 1] == 0) {    // 오른쪽으로 이동 시, 이동한 곳이 0이면
                num++;  // num + 1
                x++;    // 오른쪽으로 이동
                arr[y][x] = num;    // 오른쪽으로 이동한 좌표의 숫자는 num
            }
            while(y - 1 >= 0 && x - 1 >= 0 && arr[y - 1][x - 1] == 0) { // 왼쪽위로 이동, 이동한 곳이 0이면
                num++;  // num + 1
                y--;    // 위쪽 이동
                x--;    // 왼쪽 이동
                arr[y][x] = num;    // 왼쪽 위로 이동한 좌표의 숫자는 num
            }
        }
        int[] answer = new int[max];    // int형 배열 answer의 길이는 max
        int index = 0;  // index는 0부터 시작
        for(int i = 0; i < n; i++) {    // 0 부터 n보다 작을때까지 반복
            for(int j = 0; j <= i; j++) {   // 0부터 i이하일때까지 반복
                answer[index] = arr[i][j];  // answer의 해당 인덱스 값은 arr[i][j]
                index++;    // index + 1
            }
        }
        return answer;  // answer 리턴
    }
}
