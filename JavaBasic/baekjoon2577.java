// https://www.acmicpc.net/problem/2577

import java.io.*;

public class baekjoon2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int result = A*B*C;
        int[] arr = new int[10];    //각 숫자별 counting용 배열 생성
        String str = Integer.toString(result);  // String으로 변환(자릿수 확인용)
        int n = str.length();
        for (int i=0; i<n;i++){ // result의 자릿수 만큼 반복
            arr[(str.charAt(i)-'0')]+=1;    // counting용 배열에 카운팅
        }
        for (int i=0; i<10; i++){
            System.out.println(arr[i]);
        }
    }
}