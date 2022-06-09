// https://www.acmicpc.net/problem/1476
/*
간단한 브루트포스 문제였다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int a, b, c;
        a = b = c = 1;  // a b c 는 1년일때인 1 1 1부터 시작
        int count = 1;  // 실제 연도 1년부터 시작
        while(true){
            if(a == E && b == S && c == M) break;   // 만약 a b c가 E S M과 같아진다면 반복문 탈출
            else{   // 다르다면
                a++;    // a+1
                if(a==16) a=1;  // 만약 a가 16이되면 1로 초기화
                b++;    // b+1
                if(b==29) b=1;  // 만약 b가 29가되면 1로 초기화
                c++;    // c+1
                if(c==20) c=1;  // 만약 c가 20이되면 1로 초기화
                count++;    // 실제 연도 1년 증가
            }
        }
        System.out.println(count);  // 실제 연도 출력
    }
}