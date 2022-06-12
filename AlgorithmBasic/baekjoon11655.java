// https://www.acmicpc.net/problem/11655
/*
영어 알파벳을 13글자씩 밀어서 암호를 만들면 되는 간단한 문제이다.
문제를 보고 바로 아스키코드를 이용해 풀면 되겠다고 생각했고,
그나마 조심해야 할 부분은 그 알파벳의 아스키코드에서 +13을 했을때 알파벳 범위 밖으로 나가면 다시 -26을 해주면 됐다.
*/

import java.io.*;

public class baekjoon11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine(); // 암호화할 문자열 받아옴
        for(int i = 0 ; i < str.length() ; i++){    // 문자열의 길이만큼 반복
            if(str.charAt(i) >= 97 && str.charAt(i) <= 122){  // 만약 그 문자가 소문자면
                if(str.charAt(i) + 13 <= 122) sb.append((char)(str.charAt(i) + 13));  // 그 문자의 아스키코드에 +13을 해도 알파벳 범위 이내이면, 그냥 +13을 한 후 다시 char형으로 저장
                else sb.append((char)(str.charAt(i) - 13));    // 그 문자의 아스키코드에 +13을 했을때 알파벳 범위를 벗어나면, 다시 -26을 해줘서 결국 -13을 한 후 char형으로 저장
            }else if(str.charAt(i) >= 65 && str.charAt(i) <= 90) {  // 그 문자가 대문자 일 경우, 소문자와 동일한 방식
                if (str.charAt(i) + 13 <= 90) sb.append((char)(str.charAt(i) + 13));
                else sb.append((char)(str.charAt(i) - 13));
            }else sb.append(str.charAt(i)); //알파벳이 아니면 (띄어쓰기) 그대로 저장
        }
        System.out.println(sb); // 최종 출력
    }
}