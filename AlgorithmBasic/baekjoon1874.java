// https://www.acmicpc.net/problem/1874

import java.io.*;
import java.util.Stack;

public class baekjoon1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();   // 값 넣을 stack 생성
        int N = Integer.parseInt(br.readLine());    // 수열의 수
        int[] target= new int[N];
        for(int i= 0 ; i<N ;i++){
            target[i] = Integer.parseInt(br.readLine());    // 입력받아서 목표로 하는 수열을 배열로 생성
        }
        int max = 0;    // max값 0에서 시작
        int toMaxIndex; // max값까지의 거리 (toMaxIndex -1 = stack에 push해야 하는 횟수)
        for(int i = 0; i<N; i++){           // target 배열 순회
            if(target[i]>max) {             // max값보다 target값이 클 때
                toMaxIndex = target[i]-max; // max값까지의 거리가 바뀜
                max = target[i];            // max값도 수정
                for (int j = toMaxIndex-1; j > 0; j--) {    // push해야 할 횟수
                    stack.push(target[i]-j);           // stack에 max값 이전의 값들 push함
                    sb.append("+\n");                       // push할때마다 StringBuilder에 "+" 추가
                }
                sb.append("+\n-\n");    // StringBulider에 "+" "-" 추가 (max값은 시간 감소를 위해 굳이 stack.push(), stack.pop() 안함)
            }else {                                 // target의 값이 max보다 작을 때
                if(stack.pop().equals(target[i])){  // stack에서 빼온 값이 target과 같으면
                    sb.append("-\n");               //  StringBulider에 "-"만 추가 (위 조건식에서 pop으로 이미 빼와 짐)
                }else{                              // 빼온 값이 target[i]와 다르면
                    System.out.println("NO");       // NO출력 후
                    return;                         // main 메서드 종료
                }
            }
        }
        System.out.println(sb); // StringBuilder 출력
    }
}