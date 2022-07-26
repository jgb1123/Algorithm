// https://www.acmicpc.net/problem/2504
/*
정말 난이도에 비해 너무 힘들게 풀었다.
기존 괄호 문제들과 같이, 괄호가 닫힐 때 정상적인 괄호인지 판단하면서, 연산을 해보는 식으로 접근을 했는데 아무리해도 안됬다.
그래서 이런저런 방법을 다 시도해봤고, 결국은 괄호가 열릴 때 연산을 하는 식으로, 구현을 해봤다. (분배법칙을 통한 접근방식)
결국 푸는데 성공했지만, 문제를 푸는데 너무 많은 시간을 소비했다.

분배법칙을 이용해서 접근하면 되었고 예제인 (()[[]])([])의 경우,
+2*2 +2*3*3 +2*3 과 같은 느낌으로 접근하면 된다.
간단히 설명하면 괄호가 열릴때마다 해당 괄호의 할당 값으로 곱한다.
그리고 괄호가 닫힐때는 해당 괄호의 할당 값으로 다시 나누며, 이때 바로 이전 문자가 여는 괄호면 그때까지 곱해진 값을 최종 값에 더하면 된다.

실제 구현 방식은 다음과 같다.
우선 입력받은 문자열을 char Array로 변환한다.
그리고 for문을 통해 순회하면서 연산을 해나가면 된다.
우선은 현재의 곱의 값을 의미하는 cur변수를 1로 초기화한다. (곱을 해야하기 때문)
만약 '('괄호면 cur 값에 2를 곱한 후 스택에 '('을 저장하고,
'['괄호면 cur 값에 3을 곱한 후 스택에 '['를 저장한다.

만약 ')'괄호일경우,
stack이 비어있거나, peek한 값이 '('가 아니면 0출력후 종료한다.
peek한 값이 만약 '('이면 stack에서 pop을해서 꺼내고, cur값은 2로 나누어준다.
peek 한 값이 '('이면서, 해당 문자의 이전 문자가 '('이면 이전 result값에 cur값을 더한다.
']'괄호일 경우는 괄호랑 cur값을 3으로 나누어 주는것만 다르고 똑같다.

설명하려고하니 굉장히 복잡해보인다.
코드를 보는게 훨씬 이해하기 편할 것 같다.

난이도가 그렇게 높지 않아서(실버1) 편안한 마음으로 도전했다가 엄청난 시간을 쏟은 문제였다.
지금까지는 그냥 괄호문제 나오면 그냥 stack쓰면 되겠구나 정도로 생각하고 풀었었는데, 이러한 문제 유형이 있다는 것도 알았다.
그래도 다음에 비슷한 문제가 나오면 금방 풀 수 있을 것이다.
*/


import java.io.*;
import java.util.Stack;

public class baekjoon2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int result = 0; // 현재 최종 합
        int cur = 1;    // 현재 곱의 값

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {    // 만약 '('이면
                stack.push('(');    // stack에 해당 문자를 저장하고
                cur *= 2;   // cur = cur*2;
            } else if (arr[i] == '[') { // 위 '('일 경우와 곱하는 숫자만 다르고 똑같다.
                stack.push('[');
                cur *= 3;
            } else if (arr[i] == ')') { // 만약 ')'이면
                if (stack.isEmpty() || stack.peek() != '(') {   // stack이 비어있거나, peek한 값이 '('이 아니면
                    System.out.println(0);  // 0출력 후
                    return; // 종료
                } else {    // peek한 값이 '('이면
                    if(arr[i-1]== '(') result += cur;   // 만약 이전문자가 '('라면 result에 지금의 cur값 더함
                    stack.pop();    // pop한다.
                    cur /= 2;   // cur = cur/2가 된다.
                }
            } else if (arr[i] == ']') { // 위 ')'일경우와 괄호와 나누는 숫자만 다르고 똑같다.
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    return;
                } else {
                    if(arr[i-1]== '[') result += cur;
                    stack.pop();
                    cur /= 3;
                }
            }
        }
        if(stack.isEmpty()) System.out.println(result); // 만약 stack이 비어있으면 result출력
        else System.out.println(0); // 비어있지 않으면 0출력
    }
}