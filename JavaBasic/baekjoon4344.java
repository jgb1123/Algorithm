// https://www.acmicpc.net/problem/4344

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i<testCase; i++){
            st = new StringTokenizer(br.readLine());
            int testCase2 = Integer.parseInt(st.nextToken());
            int[] arr = new int[testCase2];
            int sum= 0;
            for(int j = 0; j < testCase2 ; j++){
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];
            }
            int average=sum/testCase2;
            long count = Arrays.stream(arr).filter(x -> x>average).count();
            double rate = (double)count/testCase2*100;
            sb.append(String.format("%.3f", rate)).append("%\n");
        }
        System.out.println(sb);
    }
}