package lv2;

import java.util.*;

class Programmers154539 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length]; // 리턴할 배열 answer
        Arrays.fill(answer, -1);    // 배열 answer를 -1로 채움
        Stack<Integer> stack = new Stack<>();   // stack 생성 (index들을 차례대로 저장함)
        for(int i = 0; i < numbers.length; i++) {   // numbers를 순회하며
            while(stack.size() > 0 && numbers[i] > numbers[stack.peek()]) { // 만약 stack이 비어있지 않고, 해당 인덱스의 값이 peek한 인덱스의 값보다 크면 반복
                answer[stack.peek()] = numbers[i];  // answer[stack.peek()]은 numbers[i] (peek()한 인덱스의 값 뒤에있는 값 중, 크면서 가장 가까운 값은 인덱스 i의 값이 됨)
                stack.pop();    // pop해서 해당 인덱스 빼냄
            }
            stack.push(i);  // stack에 해당 인덱스 저장

        }
        return answer;  // 최종 리턴
    }
}
