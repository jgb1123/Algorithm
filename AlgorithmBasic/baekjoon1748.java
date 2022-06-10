// https://www.acmicpc.net/problem/1748
/*
최초 시도는 plus 변수를 1로 초기화 후 for문을 이용하여 plus의 값을 더하며
자릿수가 바뀔때마다 plus의 값을 +1씩 더해주는 방식으로 하였고, 속도가 200ms 정도로 좀 느리게 나왔다.
그래서 다른 방식으로 해결하기로 하였고 1자리 이상인 수, 2자리 이상인 수, 3자리 이상인수... 를 구하여 합하는 방식으로 바꿨다.
예를 들면 예제에 있는 120의 경우 1자리 이상인 수 120개(120-1+1), 2자리 이상인 수 111개(120-10+1), 
3자리 이상인 수 21개(120-100+1)로 120+111+21을 하면 252가 된다.
*/


import java.io.*;

public class baekjoon1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;  // 최종 자릿수를 표현할 count 변수
        for(int i = 1; i<=N ; i*=10){   // i가 1이면 1자리 이상인 수의 개수, 그 다음 i가 10이 되면 2자리 이상인 수의 개수 이런식으로 반복
            count += N-i+1; // 그 개수들을 모두 합하면 원하는 결과를 얻을 수 있음
        }
        System.out.println(count);  //최종 출력
    }
}