package lv2;// 숫자의 표현(https://school.programmers.co.kr/learn/courses/30/lessons/12924)

class Programmers12924 {
    public int solution(int n) {
        int count = 0;
        for(int i = 1; i <= n; i++) {   // i는 1부터 n까지
            int sum = 0;
            for(int j = i; j <= n; j++) {   // j는 i부터 n까지
                sum += j;   // j를 sum에 더함
                if(sum > n) {   // 만약 n보다 커지면 break
                    break;
                }
                if(sum == n) {  // 만약 n과 같다면 count + 1 하고 break
                    count++;
                    break;
                }
            }
        }
        return count;   // count 리턴
    }
}
