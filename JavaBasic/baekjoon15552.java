// https://www.acmicpc.net/problem/15552

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i=0 ; i<T ; i++) {
            StringTokenizer inputStr = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(inputStr.nextToken());
            int b = Integer.parseInt(inputStr.nextToken());
            bw.write(a+b+"\n");
        }
        bw.close();
    }
}
