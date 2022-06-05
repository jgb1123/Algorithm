// https://www.acmicpc.net/problem/1935

import java.io.*;
import java.util.*;

public class baekjoon1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 입력 개수
        String str = br.readLine(); // 후위표기식
        double[] arr = new double[N];   // 값을 저장할 배열
        Stack<Double> stack = new Stack<>();    // 후위표기식 연산에 사용할 stack 생성

        for(int i = 0; i< N ; i++){ // 배열에 입력받은 값들 저장
            arr[i] = Double.parseDouble(br.readLine());
        }

        for(int i = 0; i<str.length(); i++){    // 후위표기식 문자 수만큼 반복
            if(str.charAt(i)>=65&& str.charAt(i)<=90){  // 만약 'A'~'Z'일 경우
                stack.add(arr[str.charAt(i)-65]);       // 배열에서 알파벳에 맞는 숫자를 가져와 stack에 저장
            }else if(str.charAt(i)=='+'){   // 만약 '+' 면
                double a = stack.pop();
                double b = stack.pop();
                stack.add(b+a); // 늦게 가져온 값 + 먼저 가져온 값
            }else if(str.charAt(i)=='-'){   // 만약 '-' 면
                double a = stack.pop();
                double b = stack.pop();
                stack.add(b-a); // 늦게 가져온 값 - 먼저 가져온 값
            }else if(str.charAt(i)=='*'){   // 만약 '*' 면
                double a = stack.pop();
                double b = stack.pop();
                stack.add(b*a); // 늦게 가져온 값 * 먼저 가져온 값
            }else if(str.charAt(i)=='/'){   // 만약 '/' 면
                double a = stack.pop();
                double b = stack.pop();
                stack.add(b/a); // 늦게 가져온 값 / 먼저 가져온 값
            }
        }
        System.out.printf("%.2f",stack.pop());  // 최종출력(소숫점 둘째 자리까지)
    }
}