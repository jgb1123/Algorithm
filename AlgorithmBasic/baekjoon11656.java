// https://www.acmicpc.net/problem/11656

import java.io.*;
import java.util.*;

public class baekjoon11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine(); // 문자열 입력
        char[] charArr = str.toCharArray(); // 문자열을 char배열로 변환
        String[] arr = new String[str.length()];    // 문자열 배열 생성

        for(int i = 0; i< str.length() ; i++){                                  // 문자열의 길이 만큼
            arr[i] = String.copyValueOf(charArr, i, charArr.length-i);    // 앞에 한자리씩 없애면서 문자열배열에 저장
        }

        Arrays.sort(arr);   // 문자열 배열 오름차순으로 정렬

        for(String s : arr) {   // 정렬된 배열 StringBuilder에 추가
            sb.append(s).append("\n");
        }

        System.out.println(sb); // StringBuilder 출력
    }
}