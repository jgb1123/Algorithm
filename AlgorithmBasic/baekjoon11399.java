// https://www.acmicpc.net/problem/11399

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 사람 수
        StringTokenizer st = new StringTokenizer(br.readLine());    // 각 사람이 돈을 인출하는데 필요한 시간
        ArrayList<Integer> list = new ArrayList<>();    // 인출 시간들을 저장할 ArrayList생성

        for(int i=0; i<N; i++){
            list.add(Integer.parseInt(st.nextToken())); // 인출 시간들을 ArrayList에 저장
        }
        Collections.sort(list); // Arraylist를 오름차순으로 정렬
        int sum = 0;    // 인출하기까지 걸린 시간
        int result = 0; // 사람들이 인출까지 걸린 시간들의 총합
        for(int i : list){
            sum = sum+i;    // 해당 사람이 인출하기까지 걸린 시간
            result += sum;  // result에 그 걸린 시간을 넣음
        }
        System.out.println(result); // 최종 출력
    }
}