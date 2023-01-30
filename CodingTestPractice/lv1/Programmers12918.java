package lv1;// 문자열 다루기 기본(https://school.programmers.co.kr/learn/courses/30/lessons/12918)

class Programmers12918 {
    public boolean solution(String s) {
        if(s.length() == 4 || s.length() == 6) {    // 길이가 4 혹은 6이면
            for(int i = 0; i < s.length(); i++) {   // 길이만큼 반복
                if(s.charAt(i) < '0' || s.charAt(i) > '9')  // 각인덱스에 해당하는 문자가 아스키코드 상 0보다 작고 9보다 크면(숫자가 아니면)
                    return false;   // false 리턴
            }
            return true;    // 검증이 모두 완료되면 true 리턴
        }
        return false;   // 그 외에는 모두 false 리턴
    }
}
