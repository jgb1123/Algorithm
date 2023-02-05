package lv2;// JadenCase 문자열 만들기(https://school.programmers.co.kr/learn/courses/30/lessons/12951)

class Programmers12951 {
    public String solution(String s) {
        String str = s.toLowerCase();
        int dis = 'A' - 'a';
        StringBuilder sb = new StringBuilder();
        if (str.charAt(0) >= 'a' && str.charAt(0) <= 'z') {  // 첫글자가 소문자면
            sb.append((char) (str.charAt(0) + dis));    // 대문자로 저장
        } else {    // 그외에는
            sb.append(str.charAt(0));   // 그대로 저장
        }
        for (int i = 1; i < str.length(); i++) { // 1부터 반복
            if (str.charAt(i - 1) == ' ' && str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {    // 전 문자가 공백(' ')이고, 소문자면
                sb.append((char) (str.charAt(i) + dis));    // 대문자로 저장
            } else {    // 그외에는
                sb.append(str.charAt(i));   // 그대로 저장
            }

        }
        return sb.toString();   // 문자열로 변환 후 리턴턴
    }
}
