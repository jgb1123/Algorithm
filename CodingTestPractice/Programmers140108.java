// 문자열 나누기(https://school.programmers.co.kr/learn/courses/30/lessons/140108)

class Programmers140108 {
    public int solution(String s) {
        int cur = 0;    // 현재 기준 문자의 인덱스
        int o = 1;  // 현재 같은 문자 수 (첫글자는 같으므로 1부터 시작)
        int x = 0;  // 현재 다른 문자 수
        int answer = 1; // 분해된 문자열 수는 1부터 시작 (마지막에 잘린 문자열을 고려)

        for(int i = 1; i < s.length(); i++) {   // 반복문에서 i는 1부터 시작 (현재 같은 문자 수는 1부터 시작함)
            if(o == x) {    // 만약 기준 문자와 같았던 문자의 수와 달랐던 문자의 수가 같아지면
                answer++;   // 분해된 문자열 수 + 1
                cur = i;    // 기준 문자를 현재 문자로 변경
                o = 0;      // 같았던 문자 수 0으로 초기화
                x = 0;      // 달랐던 문자 수 0으로 초기화
            }
            if(s.charAt(cur) == s.charAt(i)) {  // 만약 기준 문자와 해당 문자가 같으면
                o++;     // o + 1
            } else {    // 다르면
                x++;    // x + 1
            }
        }
        return answer;  // 분해된 문자열 수 리턴
    }
}