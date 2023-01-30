package lv1;// 시저 암호(https://school.programmers.co.kr/learn/courses/30/lessons/12926)

class Programmers12926 {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);   // 현재 문자 c
            if(c >= 'A' && c <= 'Z') {  // c가 대문자면
                if(c + n > 'Z') sb.append((char)(c + n - 26));  // (c + n)이 'Z'보다 크면 (c + n - 26)을 저장
                else sb.append((char)(c + n));  // 아니면 (c + n) 저장
            } else if( c >= 'a' && c <= 'z') {  // c가 소문자면
                if(c + n > 'z') sb.append((char)(c + n - 26));  // (c + n)이 'z'보다 크면 (c + n - 26)을 저장
                else sb.append((char)(c + n));  // 아니면 (c + n) 저장
            } else {    // 그 외 문자는 그대로 저장
                sb.append(c);
            }
        }
        return sb.toString();   // 문자열로 변환 후 리턴
    }
}