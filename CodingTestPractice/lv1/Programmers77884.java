package lv1;// 약수의 개수와 덧셈(https://school.programmers.co.kr/learn/courses/30/lessons/77884)

class Programmers77884 {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++) {
            int count = 0;
            for(int j = 1; j * j <= i; j++){    // 약수의 개수는 제곱근까지만 구하고 *2해줘도 됨
                if(j * j == i) {    // 제곱근일 경우 +1
                    count += 1;
                }else if(i % j == 0) {  // 약수일 경우 +2
                    count += 2;
                }
            }
            if(count % 2 == 0){ // 약수의 수가 짝수면 +
                answer += i;
            } else {    // 약수의 수가 홀수면 -
                answer -= i;
            }
        }
        return answer;  // 리턴
    }
}
