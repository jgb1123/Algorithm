package lv1;// 핸드폰 번호 가리기(https://school.programmers.co.kr/learn/courses/30/lessons/12948)

class Programmers12948 {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        int len = phone_number.length();
        for(int i = 0; i < len - 4; i++) {  // 해당 문자열의 0번째 인덱스부터 뒷 4자리 전까지는 *로 추가
            sb.append("*");
        }
        for(int i = len - 4; i < len; i++) {    // 해당 문자열의 뒷 4자리는 그대로 추가
            sb.append(phone_number.charAt(i));
        }
        return sb.toString();   // String으로 반환
    }
}
