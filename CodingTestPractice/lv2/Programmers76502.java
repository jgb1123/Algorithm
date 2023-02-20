package lv2;

import java.util.*;

class Programmers76502 {
    public int solution(String s) {
        int count = 0;  // 올바른 괄호 문자열 수
        String shift = s;   // 한칸씩 이동되는 문자열
        for(int i = 0; i < s.length(); i++) {
            if(check(shift)) count++;  // 올바른 괄호 문자열이면 count + 1
            shift = shift.substring(1, s.length()) + shift.charAt(0);   // 문자열 한칸씩 왼쪽으로 이동
        }
        return count;  // 최종 리턴
    }

    public boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '[') {  // '['면
                stack.add('['); // stack에 추가
            } else if(c == ']') {   // ']'면
                if(stack.size() == 0 || stack.peek() != '[') return false;  // stack이 비어있거나 peek한값이 '['가 아니면 false리턴
                stack.pop();    // pop
            } else if(c == '{') {   // 괄호만 다르고 위와 같음
                stack.add('{');
            } else if(c == '}') {
                if(stack.size() == 0 || stack.peek() != '{') return false;
                stack.pop();
            } else if(c == '(') {   // 괄호만 다르고 위와 같음
                stack.add('(');
            } else if(c == ')') {
                if(stack.size() == 0 || stack.peek() != '(') return false;
                stack.pop();
            }
        }
        return stack.size() == 0;   // stack이 비어있으면 true리턴
    }
}

