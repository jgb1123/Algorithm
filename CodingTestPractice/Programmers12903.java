// 가운데 글자 가져오기(https://school.programmers.co.kr/learn/courses/30/lessons/12903)

class Programmers12903 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        if(len % 2 == 0) {  // 문자열 길이가 짝수면
            sb.append(s.charAt(len / 2 - 1));   // len / 2 - 1번째 문자 추가
        }
        sb.append(s.charAt(len / 2));   // len / 2번째 문자 추가
        return sb.toString();   // String으로 변환 후 리턴
    }
}
