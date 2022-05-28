// https://www.acmicpc.net/problem/9093

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i= 0 ; i<N ;i++){   // 입력되는 문장 수만큼 반복
            StringTokenizer st = new StringTokenizer(br.readLine());    // 문장 단어 단위로 읽어옴
            while(st.hasMoreTokens()){  // 다음 단어가 있으면
                String a = st.nextToken();  // 다음 단어를 가져옴
                for(int j = a.length() -1 ; j>=0 ; j--){    // StringBuilder에 단어의 뒷글자부터 입력
                    sb.append(a.charAt(j));
                }
                sb.append(" "); // 단어 입력 다 됐으면 띄어쓰기 후 다시 while문
            }sb.append("\n");   // 한 문장 작업 끝날때마다 줄바꿈
        }
        System.out.println(sb); // StringBuilder 출력
    }
}