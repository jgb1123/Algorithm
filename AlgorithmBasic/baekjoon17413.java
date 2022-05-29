// https://www.acmicpc.net/problem/17413

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class baekjoon17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();    // 단어를 뒤집을때 사용할 Stack 생성
        ArrayList<String> result = new ArrayList<>();   // 결과를 집어넣을 result ArrayList 생성
        String s = br.readLine();   // 문자열을 받아옴
        String[] arr = s.split(""); // 문자열을 한 문자의 배열로 만듬
        boolean tag = false;    // true면 단어 뒤집기 안함
        int repeat;
        for(int i = 0; i<s.length() ; i++){
            if(tag){    // true이면 단어 뒤집기 안함
                if(arr[i].equals(">")){ // 만약 ">"면
                    result.add(arr[i]); // result에 그대로 넣음
                    tag=false;  // false로 변경 (태그 끝남)
                }else{
                    result.add(arr[i]); // ">"가 아니면 result에 그대로 넣음
                }
            }else{
                if(arr[i].equals("<")){                //만약 태그가 시작되면
                    repeat = stack.size();
                    for(int j = 0; j < repeat ; j++){  // stack의 크기만큼 반복해서
                        result.add(stack.pop());       // stack에 저장된 요소를 result에 넣음 (역순이 됨)
                    }
                    tag=true;                          // tag가 시작됨 (단어 안뒤집음)
                    result.add(arr[i]);                // result에 "<" 넣음
                }
                else if(arr[i].equals(" ")){            // 만약 공백을 만나면
                    repeat = stack.size();
                    for(int j = 0; j < repeat ; j++){   // stack의 크기만큼 반복해서
                        result.add(stack.pop());        // stack에 저장된 요소를 result에 넣음(역순이 됨)
                    }
                    result.add(arr[i]);                 // result에 " "넣음
                }else{                   // 태그도 안만나고 공백도 안만나면
                    stack.push(arr[i]);  // 스택에 저장함 (역순 출력을 위함)
                }
            }
            if(i==s.length()-1){                  // 마지막에
                repeat = stack.size();
                for(int j = 0; j < repeat ; j++){ // stack에 크기만큼 반복해서
                    result.add(stack.pop());      // stack에 저장된 요소를 result에 넣고(역순이 됨) 끝
                }
            }
        }
        for(String z : result){ // result 값 StringBuilder에 모두 저장
            sb.append(z);
        }
        System.out.println(sb); // 결과 출력
    }
}