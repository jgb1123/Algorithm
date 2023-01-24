// 크레인 인형뽑기 게임

import java.util.*;

public class Programmers64061 {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int top = 0;    // stack 맨 위 인형번호
        int answer = 0; // 터트린 인형 수
        for(int i = 0; i < moves.length; i++) {
            for(int j = 0; j < board.length; j++) {
                int num = moves[i] - 1; // 현재 크레인 위치
                if(board[j][num] != 0) {    //  0이 아니라면(인형이 있으면)
                    int doll = board[j][num];   // 현재 뽑은 인형 번호
                    if(top == doll) {   // stack 맨 위 인형 번호와 현재 뽑은 인형 번호가 같으면
                        stack.pop();    // stack 맨 위 인형을 빼고
                        answer += 2;    // 터트린 인형 수 +2
                        if(stack.size() == 0) { // stack이 비어있으면
                            top = 0;    // 맨 위 인형 번호는 0
                        } else {    // stack이 비어있지 않으면
                            top = stack.peek(); // 맨 위 인형 번호는 stack.peek();
                        }
                    } else {    // stack의 맨 위 인형 번호와 현재 뽑은 인형 번호가 다르면
                        stack.push(doll);   // stack에 현재 인형 번호 push
                        top = doll; // stack의 맨 위 인형번호는 현재 뽑은 인형 번호
                    }
                    board[j][num] = 0;  // 해당 위치의 인형을 뽑았으니 0으로 변경
                    break;  // 가장 가까운 반복문을 탈출하고 다음 반복문 시작(다음 크레인 위치에서 다시 뽑기 시작)
                }
            }
        }
        return answer;  // 최종 반환
    }
}
