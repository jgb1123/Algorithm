// https://www.acmicpc.net/problem/13305

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 주유소 수 (사용하지 않았음)
        StringTokenizer distance = new StringTokenizer(br.readLine());  // 주유소간 거리
        StringTokenizer oil = new StringTokenizer(br.readLine());   // 기름 가격

        long min = 1000000000;  // 기름 minimum 가격 1억
        long total=0;   // 총 금액
        while(distance.hasMoreTokens()){ // 다음 주유소가 있으면 반복문 실행

            long a = Long.parseLong(oil.nextToken());   // oil가격
            if(min>=a){                                 // 현재 오일이 minumum보다 싸면
                min = a;                                // minimum은 현재 오일가격
            }
            total += Long.parseLong(distance.nextToken())*min; // 총 금액에 minimum가격 기준으로 거리비례 해서 합산
        }
        System.out.println(total);  // 최종 출력
    }
}