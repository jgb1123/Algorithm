// https://www.acmicpc.net/problem/1065
/*
입력이 적어 시간복잡도를 고려하지 않고 풀어도 되는 문제로, 간단한 브루트포스 문제이다.
각 자리수가 등차수열을 이루는지만 확인하면 됐다. (이 문제에선 이런 수를 한수라고 함)
99까지는 무조건 다 한수가 된다. 그래서 그 이후인 100부터 1000까지만 확인하면 된다.
만약 N이 99이하이면 그냥 N을 출력하면되고, N이 100이상이면 100이상인 한수만 확인 후 99를 더해주면 된다.

입력이 1000이하인 자연수로, 4자리수는 1000밖에 없다.
1000은 한수가 아니므로, 한수를 찾은 메서드를 맨 아래의 주석처리한 메서드와 같이 해서 풀어도 된다.
*/


import java.io.*;
import java.util.*;

public class baekjoon1065 {
    static ArrayList<Integer> list; // 반복문을 돌며 한수를 저장할 list

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 숫자를 입력 받음
        list = new ArrayList<>();   // list 생성
        find(N);    // 한수 찾기
        if (N < 100) System.out.println(N); // N이 100 이하이면 그냥 N출력
        else System.out.println(99 + list.size());    // 100이상이면 100부터 찾은 한수 + 99(99까지의 한수)
    }

    static void find(int N) {
        for (int i = 100; i <= N; i++) {
            int a = i / 1000 % 10;  // 1000의자리
            int b = i / 100 % 10;   // 100의자리
            int c = i / 10 % 10;    // 10의자리
            int d = i % 10;       // 1의자리
            if (i < 1000) {    //만약 3자리 수이면
                if (c - b == d - c) list.add(i);   // 100의자리, 10의자리, 1의자리로만 비교
            } else {
                if (b - a == c - b && c - b == d - c) list.add(i); // 1000이상이면(이 문제에선 1000밖에 없음) 1000의자리도 고려
            }
        }
    }
}
/*
    static void find(int N){
        for(int i = 100; i <= N; i++){
            int a = i/100;  // 주의해야 할 부분이 i/100%10으로 하면 1000일때 100의자리가 0이 되서 한수처리가 되어버림
            int b = i/10%10;
            int c = i%10;
            if(b-a==c-b) list.add(i);
        }
    }
*/
