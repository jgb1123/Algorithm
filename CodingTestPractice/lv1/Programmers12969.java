package lv1;// 직사각형 별찍기(https://school.programmers.co.kr/learn/courses/30/lessons/12969)

import java.io.*;
import java.util.*;

class Programmers12969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < a; i++) {    // a개 만큼 별을 찍고
            sb.append("*");
        }
        for(int i = 0; i < b; i++) {    // a개 만큼 찍은 별을 b줄 만큼 찍음
            System.out.println(sb.toString());
        }
    }
}
