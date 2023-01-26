// 평균 구하기(https://school.programmers.co.kr/learn/courses/30/lessons/12944)

class Programmers12944 {
    public double solution(int[] arr) {
        double sum = 0;
        for(int i = 0; i < arr.length; i++) {   // 배열의 모든 값을 더하고
            sum += arr[i];
        }
        double answer = sum / arr.length;   // 배열의 길이로 나누면 평균
        return answer;
    }
}
