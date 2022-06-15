// https://www.acmicpc.net/problem/4949
/*
stack을 사용하면 쉽게 풀리는 간단한 문제였다.
하지만 한 case를 고려하지 않아서 제출 시 몇번 틀렸다.
문자열을 모두 순회하고 stack의 사이즈가 0이면 yes를 저장했는데,
stack의 사이즈가 0이 아니면 no를 저장해야 하는걸 놓쳤다.
(만약 입력이 "("만 들어오면 no가 되야 됨)
그부분을 제외하곤 쉽게 풀었다.
*/

import java.io.*;
import java.util.Stack;

public class baekjoon4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {  // while문은 무한루프고 특정 조건 시 빠져나오도록 설정
            String str = br.readLine(); // 문자열을 받아옴
            Stack<Character> stack = new Stack<>(); // 괄호를 저장할 stack 생성
            if(str.length()==1&&str.charAt(0)=='.') break;  // 만약 "."가 들어오면 while문 종료 (그냥 equals쓰는게 나았을거 같음)
            for(int i = 0; i<str.length(); i++){    // for 문자열을 한글자씩 순회하면서
                if(str.charAt(i)=='('||str.charAt(i)=='['){ // 만약 '(' 나 '['면 stack에 저장
                    stack.push(str.charAt(i));
                }else if(str.charAt(i)==')'){   // 만약 ')'면
                    if(stack.size()==0||stack.get(stack.size()-1)!='('){    // 만약 stack에 저장된게 없거나, stack에 마지막 저장된게 '('가 아니면
                        sb.append("no\n");  // StringBuilder에 no 저장 후
                        break;  // 반복문 탈출
                    }else{
                        stack.pop();    // 마지막에 저장된게 '('면 빼냄
                    }
                }else if(str.charAt(i)==']'){ // ')'일때와 같은 동작원리
                    if(stack.size()==0||stack.get(stack.size()-1)!='['){
                        sb.append("no\n");
                        break;
                    }else{
                        stack.pop();
                    }
                }
                if(i==str.length()-1&&stack.size()==0) sb.append("yes\n"); // 만약 반복문을 마지막까지 돌고 stack의 사이즈가 0이면 yes 저장
                else if(i==str.length()-1&&stack.size()!=0) sb.append("no\n");  // 반복문을 다 돌고 stack의 사이즈가 0이 아니면 no 저장
            }
        }
        System.out.println(sb); // 최종 출력
    }
}