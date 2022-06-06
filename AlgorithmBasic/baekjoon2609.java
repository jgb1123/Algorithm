// https://www.acmicpc.net/problem/2609

/*
두 수의 최대 공약수를 먼저 구하고,
두 수의 곱에 최대공약수를 나눠 최소 공배수를 구하면 되는 간단한 문제였다.
*/

import java.io.*;
import java.util.*;

public class baekjoon2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int min = Math.max(A, B);   // 두 수중 작은 수를 구함
        int GCD = 1;    // 최대공약수는 1로 초기화
        for(int i = 2 ; i <= min ; i++){    // 두 수중 작은 수까지만 확인
            if(A%i==0&& B%i==0){ // 두 수 모두와 나누어 떨어지면
                GCD = i;    // 최대 공약수는 그 수로 변경
            }
        }
        System.out.println(GCD);    // 최대 공약수 출력
        System.out.println(A*B/GCD);    // 최소 공배수 출력 (두 수의 곱 / 최대공약수)
    }
}