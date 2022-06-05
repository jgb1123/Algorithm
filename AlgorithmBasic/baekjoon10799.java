// https://www.acmicpc.net/problem/10799

import java.io.*;
import java.util.*;

public class baekjoon10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();
        int count = 0;  // 잘린 막대기 수
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i)=='('){         // 만약 '('면
                stack.add(str.charAt(i));   // stack에 추가
            }
            else if(str.charAt(i)==')'&& str.charAt(i-1)=='(') { // 만약 ')'고, 바로 이전에 '('이였으면
                stack.pop();                                     // stack에서 빼오고
                count += stack.size();                           //  count에 + stack의 크기
            }
            else{
                stack.pop();    // 그냥 ')'면
                count +=1;      // count에 +1
            }
        }
        System.out.println(count);  // 최종 출력
    }
}