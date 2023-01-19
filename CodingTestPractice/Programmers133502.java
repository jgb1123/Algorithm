// 햄버거 만들기(https://school.programmers.co.kr/learn/courses/30/lessons/133502)
import java.util.*;

class Programmers133502 {
    public int solution(int[] ingredient) {
        Stack<Integer> stack1 = new Stack<>();  // stack 2개 사용
        Stack<Integer> stack2 = new Stack<>();
        int answer = 0; // 햄버거 총 수
        int count = 0;  // 1 2 3 1 순서대로 진행 되고 있을 때의 마지막 숫자로, 순서대로 진행되고 있지 않으면 0임.
        for(int i = 0; i<ingredient.length; i++) {
            int now = ingredient[i];    // 지금 숫자
            stack1.push(now);   // stack1에 지금 숫자 저장
            if(now == 2 && count == 1) {    // 만약 2인데 count가 1이면
                count = now;    // count는 now
            } else if(now == 3 && count == 2) { // 만약 3인데 count가 2이면
                count = now;    // count는 now
            } else if(now == 1 && count == 3) { // 만약 1인데 count가 3이면 햄버거 완성
                stack1.pop();   // stack1에서 4개를 pop
                stack1.pop();
                stack1.pop();
                stack1.pop();
                answer++;   // 햄버거 수 + 1
                count = getCount(stack1, stack2);   // 현재 count값을 다시 구함
            } else if(now == 1) {   // 만약 1이면
                count = now;    // count는 now
            } else {    // 그 외에는
                count = 0;  // count 0으로 (순서대로 진행되지 않은 케이스이므로)
            }
        }
        return answer;  // 햄버거 총 수 리턴
    }
    int getCount(Stack<Integer> stack1, Stack<Integer> stack2) {    // 햄버거 완성 시 다시 그 전 재료들로 count를 구하는 메서드
        int count = 0;
        for(int j = 0; j < 3; j++) {    // 최대 3개까지만 다시 뺌
            if(stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }
        int repeat = stack2.size();
        for(int j = 0; j < repeat; j++) {   // 다시 count를 구함
            int now = stack2.pop();
            stack1.push(now);
            if(now == 1) {
                count = now;
            } else if(now == 2 && count == 1) {
                count = now;
            } else if(now == 3 && count == 2) {
                count = now;
            } else {
                count = 0;
            }
        }
        return count;
    }
}
