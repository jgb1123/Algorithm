// 음양 더하기(https://school.programmers.co.kr/learn/courses/30/lessons/76501)

class Programmers76501 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i < absolutes.length; i++) {
            if(signs[i]) {  // signs가 참이면
                answer += absolutes[i]; // 더하기
            } else {    // 아니면
                answer -= absolutes[i]; // 빼기
            }
        }
        return answer;
    }
}