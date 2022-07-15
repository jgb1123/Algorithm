// https://www.acmicpc.net/problem/1759
/*
생각보다 간단한 브루트포스 문제이다.
비밀번호의 알파벳 순서는 오름차순이고, 적어도 1개 이상의 모음과 2개 이상의 자음으로 구성되어 있다고 한다.
이부분만 고려해서 재귀를 통해 구현하면 된다.
arr 배열은 비밀번호 후보 알파벳들의 목록이고, password 배열은 최종 비밀번호를 저장할 배열이다.
오름차순의 경우 arr배열을 정렬 한 후 재귀메서드를 돌면 해결된다.
적어도 1개이상의 모음과 2개 이상의 자음이 있어야하는 조건의 경우,
재귀를 돌 때 알파벳을 password에 저장할 때마다 모음인지 자음인지 판별해서 그 수를 카운트하면 된다.
(모음이면 moeum+1, 자음이면 jaeum+1로 재귀)
각각의 케이스마다 마지막 요소까지 저장되고, moeum이 1이상이면서 jaeum이 2이상이면,
StringBuilder에 향상된 for문을 통해 해당 password를 넣는다.

난이도에 비해서 생각보다 간단해서 추가적인 설명은 아래 코드로 하면 될 것 같다.
*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon1759 {
    static char[] arr, password;
    static int L, C;
    static StringBuilder result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());   // 비밀번호 후보 알파벳의 수
        C = Integer.parseInt(st.nextToken());   // 비밀번호의 길이

        arr = new char[C];  // 비밀번호 후보 알파벳들을 저장할 arr배열 생성
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st2.nextToken().charAt(0);
        }
        Arrays.sort(arr);   // 알파벳 모두 저장 후 오름차순으로 정렬

        result = new StringBuilder();   // 비밀번호들을 저장할 StringBuilder
        password = new char[L]; // 각 케이스마다의 비밀번호가 될 password 배열
        recur(0, 0, 0, 0);  // depth 0, 반복문 시작 index 0, 모음 수 0, 자음 수 0으로 시작

        System.out.println(result); // 최종 출력
    }
    public static void recur(int depth, int index, int moeum, int jaeum){
        if(depth<L) {   // depth가 최종 비밀번호 길이보다 작으면
            for (int i = index; i < C; i++) {   // 반복문은 index부터 시작 (중복을 없애기 위함)
                password[depth]=arr[i]; // password에 비밀번호 후보 알파벳 저장
                if(arr[i]=='a' || arr[i]=='e' || arr[i]=='i' || arr[i]=='o' || arr[i]=='u'){    //만약 그 알파벳이 모음이면
                    recur(depth + 1, i + 1, moeum+1, jaeum);    // depth+1, 반복문 시작 index는 i+1, moeum+1, jaeum으로 재귀
                } else {
                    recur(depth+1, i+1, moeum, jaeum+1);    //모음이 아니면 depth+1, 반복문 시작 index는 i+1, moeum, jaeum+1로 재귀
                }
            }
        } else {    // depth가 최종 비밀번호 길이보다 작지 않으면 (같아질 경우)
            if(moeum>=1 && jaeum>=2){    // 모음이 1개 이상이면서 자음이 2개이상이면
                for (char c : password) {   // 해당 password StringBuilder에 저장
                    result.append(c);
                }
                result.append("\n");    // 저장하고 줄바꿈
            }
        }
    }
}