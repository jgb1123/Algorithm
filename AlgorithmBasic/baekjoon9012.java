// https://www.acmicpc.net/problem/9012

import java.io.*;
import java.util.Stack;

public class baekjoon9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N; i++){   // 입력받은 반복 횟수만큼 반복
            String a = br.readLine();
            Stack<Character> stack = new Stack<>(); // stack 생성
            for(int j = 0; j<a.length(); j++){  // 입력받은 문자열의 길이만큼 반복
                if(stack.isEmpty()&&a.charAt(j)==')'){  // stack이 비어있는데 ')'로 닫히면 NO
                    sb.append("NO").append("\n");
                    break;
                }else if(a.charAt(j)==')'){     // ')'로 닫히면 stack.pop
                    stack.pop();
                }else{      // '('는 stack.push
                    stack.push(a.charAt(j));
                }
                if(j==a.length()-1){    // 다돌고
                    if(stack.size()==0)sb.append("YES").append("\n");   // stack이 제대로 비어있으면 YES
                    else sb.append("NO").append("\n");  // stack에 남은 '('가 있으면 NO
                }
            }

        }
        System.out.println(sb); // 결과 출력
    }
}