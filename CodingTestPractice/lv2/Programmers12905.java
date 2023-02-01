package lv2;// 가장 큰 정사각형 찾기(https://school.programmers.co.kr/learn/courses/30/lessons/12905)

class Programmers12905 {
    public int solution(int [][]board) {
        int max = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 1 && max == 0) max = 1;   // 해당 좌표가 1이고, max는 아직 0이면 max는 1
                if(checkRange(i-1, j-1, board) && board[i][j] == 1 && board[i-1][j-1] != 0 && board[i-1][j] != 0 && board[i][j-1] != 0) {
                    // board[i-1][j-1] 이 board 범위 내에 있으면서 board[i-1][j-1], board[i-1][j]. board[i][j-1] 이 0이 아니고 board[i][j]가 1이면
                    // board[i-1][j-1], board[i-1][j]. board[i][j-1]중 가장 작은 값의 + 1 이 board[i][j]가 됨
                    board[i][j] = Math.min(board[i-1][j-1], Math.min(board[i-1][j], board[i][j-1])) + 1;
                    if(board[i][j] > max) max = board[i][j];    // board[i][j]가 max보다 크면 갱신
                }
            }
        }
        return max * max;   // 넓이이므로 max * max 리턴
    }
    public boolean checkRange(int y, int x, int[][] board) {
        return y >= 0 && x >= 0;
    }
}