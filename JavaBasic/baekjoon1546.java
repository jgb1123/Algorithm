// https://www.acmicpc.net/problem/1546

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] arr = new double[N];
        for (int i = 0; i<N ; i++){ // 입력받은 숫자들 배열에 입력
            arr[i] = Double.parseDouble(st.nextToken());
        }
        double max = arr[0];
        for (int i = 1; i <N ; i++){    // 최댓값 확인
            if(max<arr[i]) max=arr[i];
        }
        for(int i = 0; i<N; i++){   // 점수/최대점수*100 적용(문제 조건)
            arr[i] = (arr[i]/max)*100;
        }
        double sum = 0; // 평균용 sum
        for(double a : arr){
            sum += a;
        }
        double newAvr = sum/N;  // 평균
        System.out.println(newAvr);
    }
}