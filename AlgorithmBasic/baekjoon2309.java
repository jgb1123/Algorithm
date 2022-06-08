// https://www.acmicpc.net/problem/2309
/*
간단한 브루트포스 문제로, 9난쟁이 중 7난쟁이의 키의 합이 100이되는 7난쟁이를 찾는 문제이다.
9난쟁이의 키의 합을 먼저 구하고, 키의 합에 두 난쟁이의 키를 빼서 100이되면 두 난쟁이는 가짜난쟁이로 판별하는 방식으로 진행했다.
*/

import java.io.*;
import java.util.Arrays;

public class baekjoon2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[9]; // 난쟁이 키가 들어갈 배열
        int sum = 0;    // 9난쟁이의 키의 합
        for(int i = 0 ; i<9 ; i++){ // 배열에 난쟁이들의 키를 넣고, 키의 총 합을 구함
            arr[i] = Integer.parseInt(br.readLine());
            sum +=arr[i];
        }

        Arrays.sort(arr);   // 배열 오름차순 정렬
        boolean[] no = new boolean[9];  // 가짜난쟁이를 판별할 boolean배열 no
        boolean found = false;  // 판별이 끝난 여부를 확인할 boolean 변수 found
        for(int i = 0; i<9 ; i++){
            for(int j = i+1; j<9 ; j++) {
                if(sum-arr[i]-arr[j]==100){ // 만약 키의 총 합 - 두 난쟁이의 키가 100이되면
                    no[i]=no[j]=true;   // 두 난쟁이는 가짜난쟁이
                    found = true;   // 판별이 완료됨을 확인
                    break;  // 반복문 탈출
                }
            }
            if(found) break; // 만약 판별 끝났으면 반복문 탈출
        }
        for(int i = 0 ; i < 9 ; i++){   // 진짜 난쟁이들 키를 StringBuilder에 입력
            if(!no[i]) sb.append(arr[i]).append("\n");
        }
        System.out.println(sb); // 최종 출력
    }
}