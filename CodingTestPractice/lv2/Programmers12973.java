package lv2;// 짝지어 제거하기

import java.util.*;

class Programmers12973 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));    // 첫 문자 stack에 저장
        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(stack.size() == 0 || stack.peek() != c) { // stack이 비어있거나, peek한 값과 문자가 다르면
                stack.push(c);  // 해당 문자 저장
            } else {  // 그 외(peek한 값과 문자가 같으면)
                stack.pop();    // pop
            }
        }
        if(stack.size() == 0) { // stack이 비어있으면 1리턴
            return 1;
        }
        return 0;   // 아니면 0리턴
    }
}