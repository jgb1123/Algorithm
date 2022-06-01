// https://www.acmicpc.net/problem/1541

import java.io.*;
import java.util.Arrays;

public class baekjoon1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine(); // 연산 식 입력 받아옴
        String[] strArr = str.split("-");  // +연산을 모두 한 다음 -연산을 하면 최소값이 되므로 구분자를 "-"로 split
        int[][] intArr = new int[strArr.length][];  // +연산을 위한 2차원 배열 생성
        int[] intArr2 = new int[intArr.length]; // +연산이 모두 끝난 수가 -연산을 하기위해 저장될 배열

        for(int i=0 ; i<strArr.length; i++ ){   // 구분자를 "+"로 나눈 뒤 2차원 정수형 배열에 저장
            intArr[i] = Arrays.stream(strArr[i].split("\\+")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = 0; i<intArr.length; i++){           // 2차원 정수형 배열들을 각각 +연산들을 모두 진행 한 뒤 그 값들을
            for(int j = 0; j<intArr[i].length ; j++){   // 최종적으로 -연산을 하기 위한 배열에 저장
                intArr2[i] += intArr[i][j];
            }
        }
        int result = intArr2[0];    // 처음 값은 -연산이 아니기 때문에 초기값을 배열의 처음 값으로 지정
        for(int i = 1; i<intArr2.length; i++){  // -연산을 모두 진행
            result -= intArr2[i];
        }
        System.out.println(result); // 결과 출력
    }
}