// https://www.acmicpc.net/problem/8958

import java.io.*;
import java.util.Arrays;

public class baekjoon8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N; i++){   // 반복 횟수만큼 반복
            String a = br.readLine();
            char[] arr = new char[a.length()];  // 읽어온 값을 넣을 char배열 생성
            for (int j=0; j<a.length(); j++){   // char배열에 입력
                arr[j] = a.charAt(j);
            }
            int[] arr2 = new int[a.length()];   // 점수 합산용 배열 생성
            if (arr[0]=='O') arr2[0]=1; // 배열 첫 요소가 'O'이면 1점

            for(int k=1; k<a.length(); k++){

                if(arr[k-1]==arr[k]&&arr[k]=='O') arr2[k] = arr2[k-1]+1;    // 배열의 요소가 'O'이고 전 요소와 같으면, 전 요소의 점수+1점
                else if (arr[k]=='O') arr2[k] = 1;  // 'O'이면 1점
                else arr2[k]=0; // 'X'면 0점
            }
            sb.append(Arrays.stream(arr2).sum()).append("\n");  // 점수 합산
        }
        System.out.println(sb);
    }
}