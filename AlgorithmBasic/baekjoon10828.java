// https://www.acmicpc.net/problem/10828

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baekjoon10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();    // ArrayList를 이용해 Stack 구현
        for (int i = 0; i<N ; i++){ // 입력받은 반복 횟수만큼 반복
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a= st.nextToken();
            switch (a) {    // switch문으로 기능 구현
                case "push":    // Stack의 push 구현
                    list.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":     // Stack의 pop 구현
                    if (list.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(list.remove(list.size() - 1)).append("\n");
                    break;
                case "size":    // Stack의 size 구현
                    sb.append(list.size()).append("\n");
                    break;
                case "empty":       // Stack의 empty 구현
                    if (list.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "top":     // Stack의 top 구현
                    if (list.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(list.get(list.size() - 1)).append("\n");
                    break;
            }
        }
        System.out.println(sb); // 결과 출력
    }
}