// https://www.acmicpc.net/problem/1436

import java.io.*;
import java.util.*;

public class baekjoon1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();    // 연달아 666이 들어가는 수를 저장할 list
        int N = Integer.parseInt(br.readLine());    // 입력값 N
        int num = 666;  // 666이 들어간 제일 작은수가 666이니 666부터 시작
        while(list.size()<=N){  // N번째 수를 구하면 되기 떄문에, list의 크기가 N일때 까지만 반복문 실행
            int count = 0;  // 자리마다 6이 오는지 카운팅할 변수
            int numIn = num;    // num을 직접 나누면서 확인하면 안되니 다른변수 선언
            while(numIn>0){ // 0보다 클때까지만 확인
                if(numIn % 10 == 6){    // 만약 10으로 나눈 나머지가 6이면
                    count++;            // 카운트 +1
                }else count = 0;    // 만약 6이 아닌 수가 나오면 0부터 다시 시작 (6이 연달아 3번 나와야 count가 3이됨)
                if(count == 3 ){     // count가 3이 되면 (6이 연달아 3번 나오면)
                    list.add(num);   // list에 그 값을 집어넣음
                    break;           // 안쪽 반복문 종료
                }
                numIn /= 10;        // 10을 나눈 후 다시 반복문을 돌며 다음 자릿수 확인
            }
            num++;  // num +1한 후 다시 반복문
        }
        System.out.println(list.get(N-1));  // N번째 수를 출력
    }
}