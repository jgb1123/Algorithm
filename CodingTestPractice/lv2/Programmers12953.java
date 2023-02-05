package lv2;// N개의 최소공배수(https://school.programmers.co.kr/learn/courses/30/lessons/12953)

import java.util.*;

class Programmers12953 {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int gcd = 0;
        int a = arr[0];
        int b = 0;
        for(int i = 1; i < arr.length; i++) {   // 반복문을 통해 a와 b의 최소공배수를 n-1번 구하면 됨, 최소 공배수 = 두 수의 곱 / 최대 공약수
            b = arr[i];
            int max = Math.max(a, b);
            for(int j = max; j >= 0; j--) {
                if(a % j == 0 && b % j == 0) {
                    gcd = j;
                    break;
                }
            }
            a = a * b / gcd;    // a와 b의 최대공약수를 다시 a라 하고 다시 다음 숫자를 b로 해서 반복하여 최대공약수를 구하면 됨
        }

        return a;
    }
}
