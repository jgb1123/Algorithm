// https://www.acmicpc.net/problem/6588
/*
이전에 입력데이터가 많은 경우에 소수를 구하는 문제를 풀어본 적이 있다. (baekjoon1929)
다 풀고 나서 에라토스테네스의 체라는걸 이용하면 더 간단히 풀 수 있다는걸 알게 되었다.
이번에도 입력데이터가 많고, 소수를 판별해야 하는 부분이 있어서 에라토스테네스의 체를 이용하여 풀었다.
에라토스테네스의 체를 이용하여 푸니 간단한 문제가 되었다.
*/

import java.io.*;

public class baekjoon6588 {
    static boolean[] prime;     // 전역 변수로 소수인지를 확인할 boolean 배열 prime 생성
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        prime = new boolean[1000001];   // prime 배열의 수를 100만+1개로 설정
        primeMethod();  // 그 수가 소수인지를 판별할 배열을 만들 메서드
        while(true){    // 마지막을 알리는 숫자인 0이 들어올때까진 무한루프
            int num = Integer.parseInt(br.readLine());  // 검증할 숫자를 받아온다
            if(num==0) break;   // 0이면 반복문 탈출
            boolean isGoldbach = true;  // 골드바흐인지를 판별할 boolean 타입의 isGoldbach 변수
            for(int i = 2; i <= num/2; i++){    // 검증할 수의 절반 이하까지만 확인하면 된다.
                if(!prime[i]) {         // i가 소수면
                    if(!prime[num-i]) { // num-i도 소수면
                        sb.append(num).append(" = ").append(i).append(" + ").append(num-i).append("\n"); // StringBuilder에 저장
                        break;  // 반복문 탈출
                    }
                }
                if(i==num/2) isGoldbach = false; //만약 반복문을 다 돌때까지 반복문을 탈출 못했으면 isGoldbach는 false
            }
            if(!isGoldbach) sb.append("Goldbach's conjecture is wrong.\n"); // 만약 isGoldbach가 false면 해당 문자열 StringBuilder에 저장
        }

        System.out.println(sb); // 최종 출력
    }
    static void primeMethod(){  // 에라토스테네스의 체를 구현한 메서드
        prime[0]=prime[1]=true; // 0과 1은 소수가 아니므로 true (true면 소수가 아니다)
        for(int i = 2; i<=1000 ; i++){  // 수의 범위가 6~ 1000000이므로, 1000000의 제곱근인 1000까지만 반복
            if(prime[i]){   // 만약 소수가 아니라면
                continue;   //  다음 수로 넘어감
            }
            for(int j = i*i; j< prime.length; j=j+i){   // 소수라면 소수의 제곱부터 그 수의 배수들을 모두 true처리
                prime[j]= true;
            }
        }
    }
}