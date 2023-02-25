package lv2;

import java.util.*;

class Programmers131704 {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;  // 현재 상자 실은 상자 수
        int next = order[count];    // 다음 실어야 할 상자의 번호는 order[count]
        for(int i = 0; i < order.length; i++) {
            stack.push(i + 1);  // stack에 i + 1저장

            while(stack.size() > 0) {   // 스택이 비어있지 않으면 반복
                if(stack.peek() == next) {  // peek한 값이 next와 같으면
                    stack.pop();    // pop
                    count++;    // count + 1
                    if(count < order.length) {  // count가 order의 길이보다 작으면
                        next = order[count];    // next는 order[count]
                    }
                } else {    // peek한 값이 next와 다르면
                    break;  // while문 탈출
                }
            }
        }
        return count;   // 실은 상자 수 리턴
    }
}