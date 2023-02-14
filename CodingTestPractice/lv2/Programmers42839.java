package lv2;// 소수 찾기(https://school.programmers.co.kr/learn/courses/30/lessons/42839)

import java.util.*;

class Programmers42839 {
    static boolean[] used;
    static boolean[] prime;
    static boolean[] counted;
    static int count;
    public int solution(String numbers) {
        used = new boolean[numbers.length()];   // 숫자카드의 사용유무를 저장할 배열
        counted = new boolean[9999999]; // 이미 카운트한 수인지를 저장할 배열
        prime = new boolean[9999999];   // 소수인지를 저장할 배열
        getPrimeArray();    // 에라토스테네스의 체를 사용하여 prime배열을 구함
        StringBuilder sb = new StringBuilder();
        recur(sb, numbers); // 재귀를 통한 완전탐색 구현
        return count;   // count 리턴
    }

    public void getPrimeArray() {
        Arrays.fill(prime, true);   // true로 채움
        prime[0] = false;   // 0은 소수가 아님
        prime[1] = false;   // 1은 소수가 아님
        for(int i = 2; i < prime.length; i++) { // 2부터
            if(prime[i]) {  // 만약 해당숫자가 소수라면
                for(int j = i * 2; j < prime.length; j += i) {  // 해당숫자의 배수들 모두 소수가 아니므로
                    prime[j] = false;   // false처리
                }
            }
        }
    }

    public void recur(StringBuilder sb, String numbers) {
        if(sb.length() <= numbers.length()) {   // sb의 길이가 number의 길이 이하일때까지만 반복
            for(int i = 0; i < numbers.length(); i++) {
                if(!used[i]) {  // 만약 사용된 숫자가 아니라면
                    used[i] = true; // 사용 완료 처리를 하고
                    sb.append(numbers.charAt(i));   // sb에 해당 숫자 저장
                    int num = Integer.parseInt(sb.toString());  // sb to int 변환
                    if(!counted[num] && prime[num]) {   // 이미 카운트된 수가 아니고, 소수라면
                        count++;    // count + 1
                        counted[num] = true;    // counted 배열 갱신
                    }
                    recur(sb, numbers); // 해당sb로 다시 재귀
                    used[i] = false;    // 재귀끝나면 해당 숫자 미사용 처리
                    sb.deleteCharAt(sb.length() - 1);   // sb의 마지막 숫자도 다시 제거
                }
            }
        }
    }
}
