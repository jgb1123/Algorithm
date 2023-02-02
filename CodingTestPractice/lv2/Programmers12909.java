package lv2;// 올바른 괄호(https://school.programmers.co.kr/learn/courses/30/lessons/12909)

import java.util.*;

class Programmers12909 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>(); // 풀이에 사용될 stack

        for(int i = 0; i < s.length(); i++) {   // 문자열의 길이만큼 반복
            char c = s.charAt(i);
            if(c == '(') {  // 해당 문자가 '('이면
                stack.push(c);  // stack에 c저장
            } else if(stack.size() > 0 && c == ')') {   // stack이 비어있지 않고, )라면
                if(stack.peek() != '(') {   // 만약 stack의 맨 위 값이 '('라면
                    return false;   // false 리턴
                } else {    //  stack의 마지막 글자가 ')'라면
                    stack.pop();    // stack의 맨 위 값 빼오기
                }
            } else {    // 그 외 조건에는
                return false;   // false 리턴
            }
        }
        return stack.size() == 0;   // 검증이 끝난 후에 stack이 비어있으면 true반환, 비어있지 않으면 false 반환
    }
}
