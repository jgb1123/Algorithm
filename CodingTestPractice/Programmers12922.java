// 수박수박수박수박수박수?(https://school.programmers.co.kr/learn/courses/30/lessons/12922)

class Programmers12922 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {    // n번 반복
            if(i % 2 == 0) sb.append("수");  // i가 2로 나누어 떨어지면 (짝수번째면) sb에 "수" 추가
            else sb.append("박");    // 그 외에는 sb에 "박" 추가
        }
        return sb.toString();   // 문자열로 변환 후 리턴
    }
}
