import java.io.*;
import java.util.Stack;

public class baekjoon1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] arr = br.readLine().split("");
        int N = Integer.parseInt(br.readLine());
        Stack<String> stack1 = new Stack<>();   // 초기 문자열이 저장될 stack1
        Stack<String> stack2 = new Stack<>();   // 커서 이동에 따라 문자열이 저장될 stack2, stack1과 stack2의 사이가 커서 위치라 생각하면 됨
        for(String s : arr){    // 초기 문자열 stack1에 모두 push
            stack1.push(s);
        }
        for(int i = 0 ; i<N ; i++){ // 반복 횟수만큼 반복
            String s = br.readLine();   // 문자열을 받아옴
            switch(s.charAt(0)){    // 문자열의 첫 문자를 기준으로 switch문 생성
                case 'P':   // 첫 문자가 P이면
                    stack1.push(String.valueOf(s.charAt(2))); // stack1에 바로 띄어쓰기로 구분된 문자(3번째 문자) push
                    break;
                case 'L':   // 첫 문자가 L이면
                    if(!stack1.isEmpty()) stack2.push(stack1.pop()); // stack1가 비어있지 않으면 stack1 pop한 값을 stack2에 push
                    break;                                           // 커서 왼쪽으로 이동과 같음
                case 'D':
                    if(!stack2.isEmpty()) stack1.push(stack2.pop()); // stack2가 비어있지 않으면 stack2 pop한 값을 stack1에 push
                    break;                                           // 커서 오른쪽으로 이동과 같음
                case 'B':
                    if(!stack1.isEmpty())stack1.pop();  // stack1이 비어있지 않으면 stack1 pop
                    break;
            }
        }
        for(String s:stack1){   // stack1 차례대로 StringBuilder에 입력
            sb.append(s);
        }
        for(int i = stack2.size()-1; i>=0; i--){    // stack2 거꾸로 StringBuilder에 입력
            sb.append(stack2.get(i));
        }
        System.out.println(sb); // StringBuilder 출력
    }
}