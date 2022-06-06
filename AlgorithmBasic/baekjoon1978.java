// https://www.acmicpc.net/problem/1978

/*
입력 데이터 수가 적어 단순하게 이중반목문으로 소수인지만 판별하면 되는 간단한 문제였다.
*/

import java.io.*;
import java.util.*;

public class baekjoon1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 숫자 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;  // 소수를 카운팅할 변수
        for(int i = 0 ; i < N ; i++){
            int a = Integer.parseInt(st.nextToken());   // 수를 받아옴
            if(a==1) continue;  // 만약에 그 수가 1이면 continue
            boolean prime = true;  // 소수인지를 나타낼 변수 prime
            for(int j = 2; j <= Math.sqrt(a); j++){ // 2부터 그 숫자의 제곱근까지만 반복
                if(a%j==0){ // 만약 나누어 떨어지면
                    prime = false; // prime을 false로 변경
                    break;  // 반복문 탈출
                }
            }
            if(prime) count++; // 만약 prime이 여전히 true이면 소수이므로 count + 1
        }
        System.out.println(count);  // count 출력
    }
}