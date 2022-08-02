// https://www.acmicpc.net/problem/1629
/*
처음엔 뭐 이런문제가 이 난이도지..? 라고 생각하고 풀었다가 시간초과가 된걸 보고 분할정복의 개념을 적용해야 한다는 것을 깨달았다.
나의 접근 방식은 다음과 같다.
현재 곱한횟수는 count라 하고, 현재 곱해진 값을 result라고 한다.
일단 현재 count * 2가 B보다 작으면 result = result*result가 되고, count = count*2가 되며,
ArrayList에 그 result 값과, count를 SavedResult라는 객체를 이용해 저장한다. (SavedResult는 result와 count만 갖고있는 객체)

예를 들면 최종적으로는 아래와 같이 ArrayList에 저장될 것이다.
index  0         1         2         3         4         5
result 3         3*3       3^2*3^2   3^4*3^4   3^8*3^8   3^16*3^16
count  1         2         4         8         16        32

다시 정리하자면 count*2가 B보다 작을때까지는 count=count*2, result=result*result로 구하면서 위와같은 ArrayList를 만든다.
그리고 count가 곱해야 하는 횟수인 B의 절반보다 작다면, ArrayList에 저장되어있는 수 중 큰수부터 차례대로 비교해가며,
count + list의 해당 인덱스에 저장된 count값 <= B라면 count에 해당 인덱스의 count값을 더하고, result에 해당 인덱스의 result값을 곱한다.
위 예시의 과정을 살펴보자면,
위와같이 count가 32가 될때까지는 위에 말한 설명처럼 count와 result를 구해가며 ArrayList에 저장한다.
그럼 count값이 31이 부족한 상태이다. 그러면 ArrayList의 뒤쪽부터 순회를 한다.
32+16 <= B 이므로,result = result * list에 4번째 저장된 3^8*3^8, count = count + list에 4번째 저장된 16이 되고,
또 다음엔 48+8<=B이므로, result = result * list에 3번째 저장된 3^4*3^4, count = count + list에 3번째 저장된 8이 된다.
이런식으로 값을 구해나가면 된다.

그리고 이 문제에서 고려해야 할 부분은 최종적으로 C로 나눈 나머지 값을 구해야 하는 문제인데,
이 부분은 곱할때마다 C로 나누어 주며 연산해 나가면 된다.

역시나 글로 설명하려고 하니 굉장히 힘들다.
코드를 보면 더 이해가 쉬울 것 같다.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());    // 곱해야 하는 자연수
        long B = Long.parseLong(st.nextToken());    // 곱해야 하는 횟수
        long C = Long.parseLong(st.nextToken());    // C로 나눈 나머지를 구해야 함
        long result = A%C;  // 처음 result값은 A를 C로 나눈 값
        long count = 1; // 현재 곱한 수
        ArrayList<SavedResult> list = new ArrayList<>();    // result값과 count값을 저장할 ArrayList
        list.add(new SavedResult(result, count));   // 현재의 result값과 count값을 저장
        int forStartIndex = 1;  // ArrayList의 요소들을 뒤에서부터 탐색할때, 중복 횟수를 줄이기 위해 for문의 시작 index를 위한 변수이다.
        while(count<B){ // count가 B보다 작을때까지만 반복
            if(count*2<=B){ // 만약 count*2가 B이하이면
                result = result*result%C;   // result = result*result%C
                count = count*2;    // count = count*count
                list.add(new SavedResult(result, count));   // 해당 result와 count값을 ArrayList에 저장한다.
            }else{  // count*2가 B보다 큰 경우
                for (int i = list.size()-1-forStartIndex; i >= 0; i--) {    // 위에서 구한 result와 count값이 저장된 list을 뒤에서부터 탐색하며
                    if(count+list.get(i).count<=B){ // 만약 count+list의 해당 인덱스에 저장된 count값이 B보다 작으면
                        result = result * list.get(i).result % C;   // result는 result * 해당 인덱스에 저장된 result % C
                        count = count + list.get(i).count;  // count는 count + 해당 인덱스에 저장된 count
                        forStartIndex++;    // list탐색의 중복을 없애기 위한 forStartIndex++;
                    }
                }
            }
        }
        System.out.println(result); // 최종 result 출력
    }
    static class SavedResult {  // ArrayList에 result값과 count값을 편하게 저장하기 위한 SavedResult 클래스
        long result;
        long count;

        public SavedResult(long result, long count) {
            this.result = result;
            this.count = count;
        }
    }
}