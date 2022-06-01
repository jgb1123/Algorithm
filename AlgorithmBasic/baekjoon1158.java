// https://www.acmicpc.net/problem/1158

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int index = K;  // 다음 빼낼 요소까지 이동할 거리
        ArrayList<Integer> list = new ArrayList<>();    // ArrayList 생성
        for(int i =0; i<N; i++){    // ArrayList에 1~N까지의 숫자 입력
            list.add(i+1);
        }
        int[] result = new int[N];  // 결과값이 될 배열 result 배열 생성
        for(int i = 0; i<N; i++){
            result[i]=list.remove(index-1); // list에서 index-1의 위치 요소 빼냄
            if(list.size()==1){ //만약 list에 요소가 하나만 남아있으면 (N-1번 돌았을 때)
                result[i+1]=list.remove(0); //남은 요소를 뺀 후 result 배열 마지막 에 넣음
                break;
            }                                          // index + K - 1은 다음 뺴낼 요소까지의 거리가 된다.
            if(index+K-1>list.size()&&list.size()>0) { // index + K - 1의 값이 list.size()보다 크고, list가 비어있지 않으면
                index=(index+K-1)%list.size();         // 다음 뺴낼 요소의 index는 (index + K - 1)%list.size()가 된다.
                if(index==0) index = index+list.size();// 만약 index==0이면 index는 index+list.size()
            }
            else index=index+K-1;   // index +K -1이 list.size()보다 작으면 그대로 적용
        }
        String s = Arrays.toString(result); // result배열을 String으로 변경
        s= s.replace("[","<");  // "["를 "<"로 변경
        s= s.replace("]", ">"); // "]"를 ">"로 변경
        System.out.println(s);  // 최종 출력
    }
}