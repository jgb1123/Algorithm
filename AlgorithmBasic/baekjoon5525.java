// https://www.acmicpc.net/problem/5525
/*
문자열 관련 문제이다.
주어진 길이 만큼 반복되는 IOI 반복 문자가 문자열 내에 몇개 들어있나 확인하는 문제이다.
(N이 1이면 IOI, N이 2이면 IOIOI, ...)
단순하게 2중 for문으로 구현해도 결과는 얻을 수 있겠지만, 시간복잡도를 고려해보면 O(N^2)으로 분명 시간초과가 될것이다.
그래서 어떻게 구현해볼까 고민을 하다가 Queue를 이용하면 for문 하나로 풀 수 있을 것 같아서 그렇게 접근해봤다.

구현 방법은 다음과 같다.
우선 문자열을 저장할 Queue를 만든다.
그래고 for문을 통해 주어진 문자열들을 하나씩 순회하면서 if문을 통해 정해놓은 조건에 따라 문자를 하나씩 확인해보면 된다.

1. 조건1) Queue가 비어있고, 해당 문자가 I이면 Queue에 offer
2. 조건2) Queue가 비어있지 않고, 해당 문자가 I이면서 이전 문자가 O였으면 Queue에 offer
3. 조건3) Queue가 비어있지 않고, 해당 문자가 O이면서 이전 문자가 I였으면 Queue에 offer
4. 조건4) 위 조건 모두 해당하지 않으면 Queue를 clear하고, 만약 해당 문자가 I이면 Queue에 offer
5. 위 조건에 따라 문자를 확인하고 나서, 만약 Queue의 size가 2N+1이 되는순간 count++을 하고 문자 2개를 poll로 꺼내면 된다.

문제를 딱 보고 빠르게 생각해 낸 방법으로 푼 것이며, 실제 돌려보니 성능은 좋은편은 아니였다.
그래도 빠르게 풀어냈다는 것에 의의를 두자.
다른 사람들의 코드들을 봤는데 다들 참 아이디어가 좋은 것 같다고 느꼈다.
더 분발해야겠다.
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon5525 {
    
    static char[] arr;
    static Queue<Character> Q;
    static boolean before;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();
        Q = new LinkedList<>();
        before = false;    // 이전 문자를 기록하기 위한 boolean 변수로, true면 이전 문자는 'I'
        int count = 0;
        for (int i = 0; i < M; i++) {
            char cur = arr[i];
            validChar(cur);

            if(Q.size()==2*N+1){   // 위 설명 5번 
                count++;
                Q.poll();
                Q.poll();
            }

        }
        System.out.println(count);  // count 최종 출력
    }

    static void validChar(char cur) {
        if(Q.size()==0&& cur =='I'){   // 위 설명 조건1
            Q.offer(cur);
            before = true;
        }else if(Q.size()!=0&& cur =='O'&&before){    // 위 설명 조건2
            Q.offer(cur);
            before = false;
        }else if(Q.size()!=0&& cur =='I'&&!before) {  // 위 설명 조건3
            Q.offer(cur);
            before = true;
        }else{  // 위 설명 조건 4
            Q.clear();
            if(cur =='I'){
                Q.offer(cur);
                before = true;
            }
        }
    }
}