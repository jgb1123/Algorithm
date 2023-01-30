package lv1;// 문자열을 정수로 바꾸기(https://school.programmers.co.kr/learn/courses/30/lessons/12925)

class Programmers12925 {
    public int solution(String s) {
        int answer;
        if(s.charAt(0) == '-') {    // 맨 앞 문자가 '-'면
            answer = -Integer.parseInt(s.substring(1, s.length())); // 맨 앞 글자를 제외한 문자열을 Integer로 변환 후 -로
        } else if(s.charAt(0) == '+') { // 맨 앞 문자가 '+'면
            answer = Integer.parseInt(s.substring(1, s.length()));  // 맨 앞 글자를 제외한 문자열을 Integer로 변환
        } else {
            answer = Integer.parseInt(s);   // 그 외에는 그냥 Integer로 변환
        }
        return answer;
    }
}