// 소수 찾기(https://school.programmers.co.kr/learn/courses/30/lessons/12921)

class Programmers12921 {
    public int solution(int n) {
        int[] arr = new int[n+1];   // i가 소수라면 arr[i] = 0, i가 소수가 아니면 arr[i] = 1;
        for(int i = 2; i <= n/2; i++) {   // i = 2부터 n/2까지만 반복해도 됨
            if(arr[i]==0) {  // i가 소수라면
                for(int j = 2 * i; j <= n; j += i) {    // i의 배수들은 모두 소수가 아니므로
                    arr[j] = 1; // 1로 변경
                }
            }
        }
        int count = 0;  // 소수 개수
        for(int i = 2; i <= n; i++) {    // arr에서 0의 개수를 구하면 됨
            if(arr[i] == 0) count++;
        }

        return count;   // 최종 리턴
    }
}
