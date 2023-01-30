package lv1;// 기사단원의 무기(https://school.programmers.co.kr/learn/courses/30/lessons/136798)

class Programmers136798 {
    public int solution(int number, int limit, int power) {
        int answer = 0; // 총 무게
        for(int i = 2; i <= number; i++) {  // i는 2부터 시작
            int count = 0;  // 약수의 수
            for(int j = 2; j * j <= i; j++) {    // 수의 약수를 구할 때는 제곱근 까지만 찾으면 좌우 대칭임
                                                // 예시로, 16인 경우 약수는 1 2 4 8 16인데 12의 제곱근인 4까지만(1 2 4만) 찾으면 대칭으로 짝이 생김
                if(j * j == i) {    // j * j가 i면
                    count += 1; // 약수의 수는 1개만 더함
                } else if(i%j == 0) {  // 그 외에는 만약 i와 j가 나누어 떨어지면
                    count += 2;    // 약수의 수는 2개를 더함 (대칭으로 짝이 생김)
                }
            }
            if(count > limit) { // 만약 약수의 수가 제한치보다 크면
                answer += power;    // 총 무게에 power를 더함
            } else {    // 약수의수가 제한치 이하이면
                answer += count;    // 총 무게에 약수의 수를 더함
            }
        }
        return answer;  // 결과 리턴
    }
}
