// https://www.acmicpc.net/problem/1929

/*
소수인지를 판별해야 하는 수가 최대 100만개로 상당히 많기 때문에, 이중 반복문으로 소수를 판별하면 시간 복잡도가 O(n^2)이므로 시간 초과
stream의 filter를 이용해 소수가 아닌 수를 거르는 방식으로 진행
에라토스테네스의 체를 정확히 이해하고 있었다면 시간단축이 더 가능했다. (레퍼런스코드 대비 속도가 좀 더 느렸다.)
*/

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class baekjoon1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        IntStream intstream = IntStream.rangeClosed(from, to);  // from~to까지의 IntStream 생성
        for(int i = 2; i <= Math.sqrt(to); i++) {   // 2부터 to의 제곱근까지만 반복
            boolean prime = true;   // 소수인지를 판별할 변수 prime
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {   // 현재 수 i가 소수가 아니면
                    prime = false;  // prime은 false
                    break;
                }
            }
            int num = i ;   // num은 i
            if(prime){  // 현재 수 i가 만약 소수이면
                intstream = intstream.filter(x->x<=num||x%num!=0);  // 그 수보다 작거나, 그 수로 나눈 값이 0이 아닌 수만 남김
            }                                                       // 나눌 소수보다 큰데 나눈값이 0이면 삭제됨
        }
        Integer[] result = intstream.boxed().toArray(Integer[]::new);   // 다 걸러진 IntStream을 Integer 배열로 변환
        for(int a : result){
            if(a==1) continue;  // 만약 1이면 다음 수로 건너뜀
            sb.append(a).append("\n");  // StringBuilder에 그 값을 넣음
        }
        System.out.println(sb); // StringBuilder 출력
    }
}