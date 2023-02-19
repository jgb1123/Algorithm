package lv2;// 쿼드압축 후 개수 세기(https://school.programmers.co.kr/learn/courses/30/lessons/68936)

class Programmers68936 {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        recur(0, 0, arr.length, answer, arr);  // 시작지점은 (0, 0) 길이는 arr.length로 재귀 시작
        return answer;  // 결과 리턴
    }

    public void recur(int y, int x, int len, int[] answer, int[][] arr) {
        int num = arr[y][x];    // 첫 글자
        for(int i = y; i < y + len; i++) {
            for(int j = x; j < x + len; j++) {
                if(num != arr[i][j]) {  // 첫 글자랑 다른 글자가 발견되면
                    recur(y, x, len / 2, answer, arr);  // 시작지점 (y, x), len /= 2 로 재귀
                    recur(y, x + len / 2, len / 2, answer, arr);  // 시작지점 (y, x + len / 2), len /= 2 로 재귀
                    recur(y + len / 2, x, len / 2, answer, arr);  // 시작지점 (y + len / 2, x), len /= 2 로 재귀
                    recur(y + len / 2, x + len / 2, len / 2, answer, arr);  // 시작지점 (y + len / 2, x + len / 2), len /= 2 로 재귀
                    return; // 리턴
                }
            }
        }
        answer[num] += 1;   // 첫글자랑 다른글자가 발견 안됬으면 해당 숫자의 수 + 1
    }
}