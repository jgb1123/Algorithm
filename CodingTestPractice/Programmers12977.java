// 소수 만들기(https://school.programmers.co.kr/learn/courses/30/lessons/12977)

class Programmers12977 {
    public int solution(int[] nums) {
        int answer = 0; // 소수의 수
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    int num = nums[i] + nums[j] + nums[k];  // 해당 배열의 요소들 중 3가지를 조합하여 더한 수
                    for(int a = 2; a < num; a++) {
                        if(num % a == 0) {  // 2부터 num - 1까지의 수 중에서 나누어 떨어지는 수가 있으면 소수가 아님
                            break;  // 소수를 찾기위한 반복문 탈출
                        }
                        if(a == num - 1) {  // num - 1까지 다 돌았는데도 나누어떨어지는 수가 없었으면 소수이므로
                            answer++;   // answer+1
                        }
                    }
                }
            }
        }

        return answer;  // 최종 반환
    }
}
