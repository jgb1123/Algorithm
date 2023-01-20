// 삼총사(https://school.programmers.co.kr/learn/courses/30/lessons/131705)

class Programmers131705 {
    public int solution(int[] number) {
        int answer = 0;

        for(int i = 0; i < number.length - 2; i++) {    // 3중 반복문을 사용하면 되는 브루트포스 문제
            for(int j = i + 1; j < number.length - 1; j++) {
                for(int k = j + 1; k < number.length; k++) {
                    if(number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}

