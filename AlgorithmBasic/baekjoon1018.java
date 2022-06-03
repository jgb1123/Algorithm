// https://www.acmicpc.net/problem/1018

import java.io.*;
import java.util.*;

public class baekjoon1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> result = new ArrayList<>();  // black으로 시작할때 칠해야 하는 수 + white로 시작할때 칠해야 하는 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());   // 입력받은 보드의 세로크기
        int b = Integer.parseInt(st.nextToken());   // 입력받은 보드의 가로크기
        char[][] arr = new char[a][b];  // 입력받은 보드를 저장할 2차원 char배열 생성

        for(int i =0; i<a; i++){    // char배열에 저장함
            String str = br.readLine();
            for(int j = 0; j<b; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        for(int o = 0; o<=a-8; o++){    // 보드를 8x8로 잘라내고, 세로의 첫 인덱스
            for(int p = 0; p<=b-8; p++){    // 보드를 8x8로 잘라내고, 가로의 첫 인덱스
                int count1 = 0;    // 칠해야 하는 수            (white시작 혹은 black시작)
                int count2 = 0;    // 다른 경우의, 칠해야 하는 수 (black시작 혹은 white시작)
                for(int i=o; i<o+8; i++){       // 8x8크기만큼 돌면서 칠해야 하는 수 확인
                    for(int j = p; j<p+8; j++){ // 8x8크기만큼 돌면서 칠해야 하는 수 확인
                        if(arr[i][j]!='B' && i%2==0 && j%2==0){  // 시작할 때 칠해야 하는 수 구하기 (white시작 혹은 black시작)
                            count1++;
                        }else if(arr[i][j]!='W' && i%2==0 && j%2==1){
                            count1++;
                        }else if(arr[i][j]!='W' && i%2==1 && j%2==0){
                            count1++;
                        }else if(arr[i][j]!='B' && i%2==1 && j%2==1){
                            count1++;
                        }
                        if(arr[i][j]!='W' && i%2 ==0 && j%2==0){ // 다른 경우의, 시작할 때 칠해야 하는 수 구하기 (black시작 혹은 white시작)
                            count2++;
                        }else if(arr[i][j]!='B' && i%2==0 && j%2==1){
                            count2++;
                        }if(arr[i][j]!='B' && i%2 ==1 && j%2==0){
                            count2++;
                        }else if(arr[i][j]!='W' && i%2==1 && j%2==1){
                            count2++;
                        }
                    }
                }
                result.add(count1);    // ArrayList에 칠해야 하는 수 집어넣음
                result.add(count2);    // ArrayList에 칠해야 하는 수 집어넣음
            }
        }
        System.out.println(Collections.min(result));
    }
}